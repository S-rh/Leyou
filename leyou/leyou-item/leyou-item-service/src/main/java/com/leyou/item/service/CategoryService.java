package com.leyou.item.service;

import com.leyou.item.pojo.Category;

import java.util.List;

public interface CategoryService {

    /**
     * 根据父节点查询子节点
     * @param pid
     * @return
     */
    List<Category> queryCategoriesByPid(Long pid);

    /**
     * 根据品牌id查询分类信息
     * @param bid
     * @return
     */
    List<Category> queryCategoriesByBid(Long bid);

    /**
     * 根据Ids查询分类名称
     * @param ids
     * @return
     */
    List<String> queryNamesByIds(List<Long> ids);
}
