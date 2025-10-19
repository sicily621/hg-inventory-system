package com.hg.inventory.modules.base.product.service.impl;

import cn.hutool.core.collection.CollStreamUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hg.inventory.common.domain.form.PageQuery;
import com.hg.inventory.common.domain.vo.PageInfo;
import com.hg.inventory.common.enums.DelFlagEnum;
import com.hg.inventory.common.exception.ServiceException;
import com.hg.inventory.modules.base.product.domain.entity.Product;
import com.hg.inventory.modules.base.product.domain.form.ProductForm;
import com.hg.inventory.modules.base.product.mapper.ProductMapper;
import com.hg.inventory.modules.base.product.service.CategoryService;
import com.hg.inventory.modules.base.product.service.ProductService;
import com.hg.inventory.modules.purchase.domain.entity.PurchaseOrderDetail;
import com.hg.inventory.modules.purchase.domain.form.PurchaseOrderDetailForm;
import com.hg.inventory.modules.purchase.service.PurchaseOrderDetailService;
import com.hg.inventory.modules.sales.domain.entity.SalesOrderDetail;
import com.hg.inventory.modules.sales.domain.form.SalesOrderDetailForm;
import com.hg.inventory.modules.sales.service.SalesOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private PurchaseOrderDetailService purchaseOrderDetailService;
    @Autowired
    private SalesOrderDetailService salesOrderDetailService;
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
        PurchaseOrderDetailForm purchaseOrderDetailForm = new PurchaseOrderDetailForm();
        purchaseOrderDetailForm.setProductId(id);
        List<PurchaseOrderDetail> PurchaseOrderDetails = purchaseOrderDetailService.list(purchaseOrderDetailForm);
        if(CollUtil.isNotEmpty(PurchaseOrderDetails)){
            throw new ServiceException("存在关联的采购订单，无法删除");
        }
        SalesOrderDetailForm salesOrderDetailForm = new SalesOrderDetailForm();
        salesOrderDetailForm.setProductId(id);
        List<SalesOrderDetail> salesOrderDetailList = salesOrderDetailService.list(salesOrderDetailForm);
        if(CollUtil.isNotEmpty(salesOrderDetailList)){
            throw new ServiceException("存在关联的销售订单，无法删除");
        }
        productMapper.deleteById(id);
        return true;
    }

    @Override
    public List<Product> list(ProductForm productForm) {
        LambdaQueryWrapper<Product> lqw = getQueryWrapper(productForm);
        return productMapper.selectList(lqw);
    }



    @Override
    public PageInfo<Product> page(ProductForm productForm, PageQuery pageQuery) {
        LambdaQueryWrapper<Product> lqw = getQueryWrapper(productForm);
        Page<Product> page = pageQuery.build();
        Page<Product> result = productMapper.selectPage(page, lqw);
        PageInfo<Product> tableDataInfo = PageInfo.build(result);
        return tableDataInfo;
    }

    @Override
    public List<Product> batchSave(List<Product> products) {
        productMapper.insertOrUpdateBatch(products);
        List<Long> list = CollStreamUtil.toList(products,Product::getId);
        List<Product> result = getByIds(list);
        return result;
    }

    private LambdaQueryWrapper<Product> getQueryWrapper(ProductForm productForm) {
        Long categoryId = productForm.getCategoryId();
        List<Long> categoryIds = categoryService.findAllChild(categoryId, true);
        LambdaQueryWrapper<Product> lqw = Wrappers.lambdaQuery();
        lqw.like(productForm.getCode()!=null, Product::getCode, productForm.getCode());
        lqw.like(productForm.getName()!=null, Product::getName, productForm.getName());
        lqw.in(CollUtil.isNotEmpty(categoryIds), Product::getCategoryId, categoryIds);
        lqw.eq( Product::getDelFlag, DelFlagEnum.NORMAL.getValue());
        return lqw;
    }
}
