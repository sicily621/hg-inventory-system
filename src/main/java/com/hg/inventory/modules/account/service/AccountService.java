package com.hg.inventory.modules.account.service;

import com.hg.inventory.common.domain.vo.PageInfo;
import com.hg.inventory.common.domain.vo.Result;
import com.hg.inventory.modules.account.domain.entity.Account;
import com.hg.inventory.modules.account.domain.form.AccountForm;

import java.util.List;

public interface AccountService {
    Account save(Account account);

    Account getById(Long id);

    List<Account> getByIds(List<Long> ids);

    Boolean deleteById(Long id);

    List<Account> list();

    PageInfo<Account> page(AccountForm accountForm);

    List<Account> getByOrderId(Long orderId);

    Result<Boolean> batchSave(List<Account> accounts);
}
