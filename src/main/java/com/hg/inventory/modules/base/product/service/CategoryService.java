package com.hg.inventory.modules.base.product.service;

import com.hg.inventory.modules.base.product.domain.entity.Category;

import java.util.List;

public interface CategoryService {
    Category save(Category category);

    Category getById(Long id);

    List<Category> getByIds(List<Long> ids);

    Boolean deleteById(Long id);

    List<Category> list();
}
