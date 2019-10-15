package com.grg.shopping.service;

import com.grg.shopping.entity.ProductInfo;

import java.util.List;

/**
 * 商品服务
 *
 * @author Lee
 * @version v1.0
 * @date 2019/10/15 11:53
 */
public interface ProductService {
    /**
     * 添加商品
     *
     * @param product 商品信息
     */
    void createProduct(ProductInfo product);

    /**
     * 查询商品
     *
     * @param page     当前页
     * @param pageSize 分页大小
     * @return 分页结果
     */
    List<ProductInfo> queryProduct(int page, int pageSize);
}
