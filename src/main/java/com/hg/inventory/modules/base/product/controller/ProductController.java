package com.hg.inventory.modules.base.product.controller;
import com.hg.inventory.common.domain.vo.PageInfo;
import com.hg.inventory.common.domain.vo.Result;
import com.hg.inventory.modules.base.product.domain.entity.Product;
import com.hg.inventory.modules.base.product.domain.form.ProductForm;
import com.hg.inventory.modules.base.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/product")
@RestController
public class ProductController {
    @Autowired
    private ProductService productService;
    /**
     * 新建商品
     */
    @PostMapping()
    public Result<Product> create(@RequestBody Product product){
        return Result.success(productService.save(product));
    }
    /**
     * 修改商品
     * @param product
     * @return
     */
    @PutMapping()
    public Result<Product> update(@RequestBody Product product){
        return Result.success(productService.save(product));
    }
    /**
     * 根据商品Id查询商品
     */
    @GetMapping("{id}")
    public Result<Product> getById(@PathVariable("id") Long id){
        return Result.success(productService.getById(id));
    }
    /**
     * 根据商品Ids查询商品列表
     */
    @GetMapping("/getByIds/{ids}")
    public Result<List<Product>> getById(@PathVariable("ids") List<Long> ids){
        return Result.success(productService.getByIds(ids));
    }

    /**
     * 删除商品
     */
    @DeleteMapping("{id}")
    public Result<Void> deleteById(@PathVariable("id") Long id){
        productService.deleteById(id);
        return Result.success();
    }
    /**
     * 查询商品列表
     */
    @GetMapping("/list")
    public Result<List<Product>> list(){
        return Result.success(productService.list());
    }

    /**
     * 分页查询商品列表
     */
    @GetMapping("/page")
    public Result<PageInfo<Product>> page(ProductForm productForm){
        return Result.success(productService.page(productForm));
    }

}
