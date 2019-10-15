package com.grg.shopping.entity;

import lombok.Data;

/**
 * 商品描述
 *
 * @author Lee
 * @date 2019/10/15 11:51
 * @version v1.0
 */
@Data
public class ProductDescript {

    private Long id;

    /**
     * 所属商品id
     */
    private Long productInfoId;

    /**
     * 商品描述
     */
    private String descript;

    /**
     * 所属店铺id
     */
    private Long storeInfoId;

}
