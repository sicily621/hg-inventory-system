package com.hg.inventory.modules.base.supplier.service;

import com.hg.inventory.common.domain.vo.PageInfo;
import com.hg.inventory.modules.base.supplier.domain.entity.Supplier;
import com.hg.inventory.modules.base.supplier.domain.form.SupplierForm;

import java.util.List;

public interface SupplierService {
    Supplier save(Supplier supplier);

    Supplier getById(Long id);

    List<Supplier> getByIds(List<Long> ids);

    Boolean deleteById(Long id);


    PageInfo<Supplier> page(SupplierForm supplierForm);

    List<Supplier> list();
}
