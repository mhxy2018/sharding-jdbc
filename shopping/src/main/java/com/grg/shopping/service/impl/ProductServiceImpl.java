package com.grg.shopping.service.impl;

import com.grg.shopping.entity.ProductDescript;
import com.grg.shopping.entity.ProductInfo;
import com.grg.shopping.dao.ProductDao;
import com.grg.shopping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 商品服务
 *
 * @author Lee
 * @version v1.0
 * @date 2019/10/15 11:54
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDao productDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createProduct(ProductInfo productInfo) {
        ProductDescript productDescript = new ProductDescript();
        //设置商品描述 信息
        productDescript.setDescript(productInfo.getDescript());
        //调用dao向商品信息表
        productDao.insertProductInfo(productInfo);
        //将商品信息id设置到productDescript
        productDescript.setProductInfoId(productInfo.getProductInfoId());
        //设置店铺id
        productDescript.setStoreInfoId(productInfo.getStoreInfoId());
        //向商品描述信息表插入数据
        productDao.insertProductDescript(productDescript);
    }

    @Override
    public List<ProductInfo> queryProduct(int page, int pageSize) {
        int start = (page - 1) * pageSize;
        return productDao.selectProductList(start, pageSize);
    }
}
