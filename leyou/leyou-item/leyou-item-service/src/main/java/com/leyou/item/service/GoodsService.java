package com.leyou.item.service;

import com.leyou.common.pojo.PageResult;
import com.leyou.item.bo.SpuBo;
import com.leyou.item.pojo.Sku;
import com.leyou.item.pojo.SpuDetail;

import java.util.List;

public interface GoodsService {

    /**
     * 分页查询商品信息
     * @param key
     * @param saleable
     * @param page
     * @param rows
     * @return
     */
    PageResult<SpuBo> querySpuByPage(String key, Boolean saleable, Integer page, Integer rows);

    /**
     * 保存商品
     * @param spuBo
     */
    void saveGoods(SpuBo spuBo);

    /**
     * 更新商品信息
     * @param spuBo
     */
    void updateGoods(SpuBo spuBo);

    /**
     * 根据SpuId查询SpuDetail
     * @param spuId
     * @return
     */
    SpuDetail querySpuDetailBySpuId(Long spuId);

    /**
     * 根据SpuId查询Skus
     * @param spuId
     * @return
     */
    List<Sku> querySkusBySpuId(Long spuId);


}
