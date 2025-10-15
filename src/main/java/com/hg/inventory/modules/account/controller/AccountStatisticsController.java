package com.hg.inventory.modules.account.controller;

import com.hg.inventory.common.domain.vo.Result;
import com.hg.inventory.modules.account.domain.form.AccountStatisticsForm;
import com.hg.inventory.modules.account.domain.model.AccountStatisticsItem;
import com.hg.inventory.modules.account.service.AccountStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 账单统计
 */
@RequestMapping("/account/statistics")
@RestController
public class AccountStatisticsController {
    @Autowired
    private AccountStatisticsService accountStatisticsService;

    /**
     * 查询单个时间类型统计
     */
    @GetMapping("/getStatisticsByTimeType")
    public Result<AccountStatisticsItem> statisticsByTimeType(AccountStatisticsForm statisticsForm){
        return Result.success(accountStatisticsService.statisticsByTimeType(statisticsForm));
    }

    /**
     * 查询多个时间类型统计
     */
    @GetMapping("/listStatisticsByTimeType")
    public Result<List<AccountStatisticsItem>> listStatisticsByTimeType(AccountStatisticsForm statisticsForm){
        return Result.success(accountStatisticsService.listStatisticsByTimeType(statisticsForm));
    }
}
