package com.hg.inventory.modules.base.warehouse.service;

import com.hg.inventory.common.domain.form.PageQuery;
import com.hg.inventory.common.domain.vo.PageInfo;
import com.hg.inventory.modules.base.warehouse.domain.entity.Shelf;
import com.hg.inventory.modules.base.warehouse.domain.form.ShelfForm;

import java.util.List;

public interface ShelfService {
    Shelf save(Shelf shelf);

    Shelf getById(Long id);

    List<Shelf> getByIds(List<Long> ids);

    Boolean deleteById(Long id);

    List<Shelf> list(ShelfForm shelfForm);

    PageInfo<Shelf> page(ShelfForm shelfForm, PageQuery pageQuery);
}
