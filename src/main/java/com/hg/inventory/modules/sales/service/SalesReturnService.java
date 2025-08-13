package com.hg.inventory.modules.sales.service;

import com.hg.inventory.common.domain.form.PageQuery;
import com.hg.inventory.common.domain.vo.PageInfo;
import com.hg.inventory.modules.sales.domain.entity.SalesReturn;
import com.hg.inventory.modules.sales.domain.form.SalesReturnForm;

import java.util.List;

public interface SalesReturnService {
    SalesReturn save(SalesReturn salesReturn);

    SalesReturn getById(Long id);

    boolean deleteById(Long id);

    PageInfo<SalesReturn> page(SalesReturnForm salesReturnForm, PageQuery pageQuery);

    List<SalesReturn> list(SalesReturnForm salesReturnForm);
}
