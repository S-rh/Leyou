package com.leyou.item.mapper;

import com.leyou.item.pojo.Brand;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface BrandMapper extends Mapper<Brand> {

    /**
     * 增加品牌与分类关系
     * @param cid
     * @param bid
     */
    @Insert("insert into tb_category_brand(category_id, brand_id) values(#{cid}, #{bid})")
    void insertCategoryBrand(@Param("cid") Long cid, @Param("bid") Long bid);

    /**
     * 删除品牌与分类关系
     * @param bid
     */
    @Delete("delete from tb_category_brand where brand_id = #{bid}")
    void deleteCategoryBrand(Long bid);

    /**
     * 根据分类id查询品牌信息
     * @param cid
     * @return
     */
    @Select("select * from tb_brand where id in (select brand_id from tb_category_brand where category_id = #{cid})")
    List<Brand> queryBrandsByCid(Long cid);
}
