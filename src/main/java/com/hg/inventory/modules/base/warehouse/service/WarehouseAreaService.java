package com.hg.inventory.modules.base.warehouse.service;

import com.hg.inventory.common.domain.form.PageQuery;
import com.hg.inventory.common.domain.vo.PageInfo;
import com.hg.inventory.modules.base.warehouse.domain.entity.WarehouseArea;
import com.hg.inventory.modules.base.warehouse.domain.form.WarehouseAreaForm;

import java.util.List;

public interface WarehouseAreaService {
    WarehouseArea save(WarehouseArea warehouseArea);

    WarehouseArea getById(Long id);

    List<WarehouseArea> getByIds(List<Long> ids);

    Boolean deleteById(Long id);

    List<WarehouseArea> list(WarehouseAreaForm warehouseAreaForm);

    PageInfo<WarehouseArea> page(WarehouseAreaForm warehouseAreaForm, PageQuery pageQuery);
}
