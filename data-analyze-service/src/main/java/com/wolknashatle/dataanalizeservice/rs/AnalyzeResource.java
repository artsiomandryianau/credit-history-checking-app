package com.wolknashatle.dataanalizeservice.rs;

import com.wolknashatle.dataanalizeservice.model.statistics.UnpaidLoansStatistic;
import com.wolknashatle.dataanalizeservice.service.GettingDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/getStat")
public class AnalyzeResource {

    @Autowired
    private GettingDataService gettingDataService;


    @RequestMapping("/getLoansInfoReport")
    public UnpaidLoansStatistic getLoansInfoReport() {
        return gettingDataService.getLoansReport();
    }
}
