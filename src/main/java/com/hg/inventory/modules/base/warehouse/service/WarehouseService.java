package com.hg.inventory.modules.base.warehouse.service;

import com.hg.inventory.common.domain.form.PageQuery;
import com.hg.inventory.common.domain.vo.PageInfo;
import com.hg.inventory.modules.base.warehouse.domain.entity.Warehouse;
import com.hg.inventory.modules.base.warehouse.domain.form.WarehouseForm;

import java.util.List;

public interface WarehouseService {
    Warehouse save(Warehouse warehouse);

    Warehouse getById(Long id);

    List<Warehouse> getByIds(List<Long> ids);

    Boolean deleteById(Long id);

    List<Warehouse> list(WarehouseForm warehouseForm);

    PageInfo<Warehouse> page(WarehouseForm warehouseForm, PageQuery pageQuery);
}
