package com.hg.inventory.modules.account.service;

import com.hg.inventory.modules.account.domain.form.AccountStatisticsForm;
import com.hg.inventory.modules.account.domain.model.AccountStatisticsItem;

import java.util.List;

public interface AccountStatisticsService {

    AccountStatisticsItem statisticsByTimeType(AccountStatisticsForm statisticsForm);

    List<AccountStatisticsItem> listStatisticsByTimeType(AccountStatisticsForm statisticsForm);
}
