package com.hg.inventory.modules.base.product.service;

import com.hg.inventory.common.domain.form.PageQuery;
import com.hg.inventory.common.domain.vo.PageInfo;
import com.hg.inventory.modules.base.product.domain.entity.Product;
import com.hg.inventory.modules.base.product.domain.form.ProductForm;

import java.util.List;

public interface ProductService {

    Product save(Product product);

    Product getById(Long id);

    List<Product> getByIds(List<Long> ids);

    Boolean deleteById(Long id);

    List<Product> list(ProductForm productForm);

    PageInfo<Product> page(ProductForm productForm, PageQuery pageQuery);
}
