package com.hg.inventory.modules.account.service;

import com.hg.inventory.modules.account.domain.form.AccountStatisticsForm;
import com.hg.inventory.modules.account.domain.model.AccountStatisticsItem;

import java.util.List;

public interface AccountStatisticsService {

    AccountStatisticsItem getSalesStatisticsByTimeType(AccountStatisticsForm statisticsForm);

    List<AccountStatisticsItem> listSalesStatisticsByTimeType(AccountStatisticsForm statisticsForm);
}
