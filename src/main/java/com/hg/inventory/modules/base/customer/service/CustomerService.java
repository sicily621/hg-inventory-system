package com.hg.inventory.modules.base.customer.service;

import com.hg.inventory.common.domain.vo.PageInfo;
import com.hg.inventory.modules.base.customer.domain.entity.Customer;
import com.hg.inventory.modules.base.customer.domain.form.CustomerForm;
import com.hg.inventory.modules.base.product.domain.entity.Product;

import java.util.List;

public interface CustomerService {
    Customer save(Customer customer);

    Customer getById(Long id);

    List<Customer> getByIds(List<Long> ids);

    Boolean deleteById(Long id);

    List<Customer> list();

    PageInfo<Customer> page(CustomerForm customerForm);
}
