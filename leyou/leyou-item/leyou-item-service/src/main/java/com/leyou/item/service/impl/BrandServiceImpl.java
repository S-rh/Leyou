package com.leyou.item.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.leyou.common.pojo.PageResult;
import com.leyou.item.mapper.BrandMapper;
import com.leyou.item.pojo.Brand;
import com.leyou.item.service.BrandService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service("brandService")
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    @Override
    public PageResult<Brand> queryBrandsByPage(String key, Integer page, Integer rows, String sortBy, Boolean desc) {
        //初始化example对象
        Example example = new Example(Brand.class);
        Example.Criteria criteria = example.createCriteria();

        // 根据name模糊查询，或根据首字符查询
        if (StringUtils.isNotBlank(key)) {
            criteria.andLike("name","%" + key + "%").orEqualTo("letter", key);
        }

        // 添加分页条件
        PageHelper.startPage(page,rows);

        //添加排序条件
        if (StringUtils.isNotBlank(sortBy)) {
            example.setOrderByClause(sortBy + " " + (desc ? "desc" : "asc"));
        }

        List<Brand> brands = this.brandMapper.selectByExample(example);

        // 包装成pageInfo
        PageInfo<Brand> pageInfo = new PageInfo<>(brands);

        // 包装成分页结果集
        return new PageResult<>(pageInfo.getTotal(),pageInfo.getList());
    }

    @Override
    @Transactional
    public void saveBrand(Brand brand, List<Long> cids) {
        // brand表
        this.brandMapper.insertSelective(brand);

        // category_brand表
        cids.forEach(cid->{
            this.brandMapper.insertCategoryBrand(cid, brand.getId());
        });
    }

    @Override
    @Transactional
    public void uploadBrand(Brand brand, List<Long> cids) {
        Example example = new Example(Brand.class);
        this.brandMapper.updateByPrimaryKeySelective(brand);

        this.brandMapper.deleteCategoryBrand(brand.getId());

        cids.forEach(cid->{
            this.brandMapper.insertCategoryBrand(cid, brand.getId());
        });
    }

    @Override
    public void deleteBrand(Long bid) {
        this.brandMapper.deleteCategoryBrand(bid);
        this.brandMapper.deleteByPrimaryKey(bid);
    }

    @Override
    public List<Brand> queryBrandsByCid(Long cid) {
        return this.brandMapper.queryBrandsByCid(cid);
    }
}
