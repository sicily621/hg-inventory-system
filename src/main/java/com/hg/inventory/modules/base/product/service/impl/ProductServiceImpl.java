package com.hg.inventory.modules.base.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hg.inventory.common.domain.vo.PageInfo;
import com.hg.inventory.common.enums.DelFlagEnum;
import com.hg.inventory.modules.base.product.domain.entity.Product;
import com.hg.inventory.modules.base.product.domain.form.ProductForm;
import com.hg.inventory.modules.base.product.mapper.ProductMapper;
import com.hg.inventory.modules.base.product.service.ProductService;
import com.hg.inventory.modules.system.role.domain.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;
    @Override
    public Product save(Product product) {
        int flag = 0;
        if(product.getId()==null){
            flag= productMapper.insert(product);
        }else{
            flag = productMapper.updateById(product);
        }
        if(flag>0){
            return productMapper.selectById(product.getId());
        }else{
            return null;
        }

    }

    @Override
    public Product getById(Long id) {
        return productMapper.selectById(id);
    }

    @Override
    public List<Product> getByIds(List<Long> ids) {
        LambdaQueryWrapper<Product> lqw = Wrappers.lambdaQuery();
        lqw.eq(Product::getDelFlag, DelFlagEnum.NORMAL.getValue());
        lqw.in( Product::getId, ids);
        return productMapper.selectList(lqw);
    }

    @Override
    public Boolean deleteById(Long id) {
        productMapper.deleteById(id);
        return true;
    }

    @Override
    public List<Product> list() {
        LambdaQueryWrapper<Product> lqw = Wrappers.lambdaQuery();
        lqw.eq( Product::getDelFlag, DelFlagEnum.NORMAL.getValue());
        return productMapper.selectList(lqw);
    }

    @Override
    public PageInfo<Product> page(ProductForm productForm) {
        LambdaQueryWrapper<Product> lqw = Wrappers.lambdaQuery();
        lqw.like(productForm.getCode()!=null, Product::getCode, productForm.getCode());
        lqw.like(productForm.getName()!=null, Product::getName, productForm.getName());
        lqw.eq(productForm.getCategoryId()!=null, Product::getCategoryId, productForm.getCategoryId());
        lqw.eq( Product::getDelFlag, DelFlagEnum.NORMAL.getValue());
        Page<Product> page = productForm.build();
        Page<Product> result = productMapper.selectPage(page, lqw);
        PageInfo<Product> tableDataInfo = PageInfo.build(result);
        return tableDataInfo;
    }
}
