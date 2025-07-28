package com.hg.inventory.modules.base.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hg.inventory.common.enums.DelFlagEnum;
import com.hg.inventory.modules.base.product.domain.entity.Category;
import com.hg.inventory.modules.base.product.mapper.CategoryMapper;
import com.hg.inventory.modules.base.product.service.CategoryService;
import com.hg.inventory.modules.system.department.domain.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public Category save(Category category) {
        int flag = 0;
        if(category.getId()==null){
            flag= categoryMapper.insert(category);
        }else{
            flag = categoryMapper.updateById(category);
        }
        if(flag>0){
            return categoryMapper.selectById(category.getId());
        }else{
            return null;
        }

    }

    @Override
    public Category getById(Long id) {
        return categoryMapper.selectById(id);
    }

    @Override
    public List<Category> getByIds(List<Long> ids) {
        LambdaQueryWrapper<Category> lqw = Wrappers.lambdaQuery();
        lqw.eq(Category::getDelFlag, DelFlagEnum.NORMAL.getValue());
        lqw.in( Category::getId, ids);
        return categoryMapper.selectList(lqw);
    }

    @Override
    public Boolean deleteById(Long id) {
        categoryMapper.deleteById(id);
        return true;
    }

    @Override
    public List<Category> list() {
        LambdaQueryWrapper<Category> lqw = Wrappers.lambdaQuery();
        lqw.eq( Category::getDelFlag, DelFlagEnum.NORMAL.getValue());
        return categoryMapper.selectList(lqw);
    }
}
