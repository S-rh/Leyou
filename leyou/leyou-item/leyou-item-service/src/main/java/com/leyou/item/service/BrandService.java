package com.leyou.item.service;

import com.leyou.common.pojo.PageResult;
import com.leyou.item.pojo.Brand;

import java.util.List;

public interface BrandService {
    /**
     * 分页查询品牌信息
     * @param key
     * @param page
     * @param rows
     * @param sortBy
     * @param desc
     * @return
     */
    PageResult<Brand> queryBrandsByPage(String key, Integer page, Integer rows, String sortBy, Boolean desc);

    /**
     * 保存品牌信息
     * @param brand
     * @param cids
     */
    void saveBrand(Brand brand, List<Long> cids);

    /**
     * 修改品牌信息
     * @param brand
     * @param cids
     */
    void uploadBrand(Brand brand, List<Long> cids);

    /**
     * 删除品牌信息
     * @param bid
     */
    void deleteBrand(Long bid);

    /**
     * 根据分类ID查询品牌
     * @param cid
     * @return
     */
    List<Brand> queryBrandsByCid(Long cid);
}
