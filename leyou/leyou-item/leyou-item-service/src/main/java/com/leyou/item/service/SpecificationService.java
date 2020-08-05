package com.leyou.item.service;

import com.leyou.item.pojo.SpecGroup;
import com.leyou.item.pojo.SpecParam;

import java.util.List;

public interface SpecificationService {

    /**
     * 根据分类id查询参数组
     * @param cid
     * @return
     */
    List<SpecGroup> queryGroupsByCid(Long cid);

    /**
     * 根据参数组id查询参数
     * @param gid
     * @return
     */
    List<SpecParam> queryParams(Long gid);
}
