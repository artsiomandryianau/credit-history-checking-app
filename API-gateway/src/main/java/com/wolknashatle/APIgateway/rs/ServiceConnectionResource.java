package com.wolknashatle.APIgateway.rs;

import com.wolknashatle.APIgateway.model.ClientInfo;
import com.wolknashatle.APIgateway.model.LoanInfo;
import com.wolknashatle.APIgateway.model.reports.OverdueLoansReport;
import com.wolknashatle.APIgateway.model.reports.UnpaidLoansReport;
import com.wolknashatle.APIgateway.model.statistics.UnpaidLoansStatistic;
import com.wolknashatle.APIgateway.service.ConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceConnectionResource {

    @Autowired
    private ConnectionService connectionService;

    @RequestMapping("/overdue-report")
    public OverdueLoansReport getOverdueReport() {
        return connectionService.getOverdueReport();
    }

    @RequestMapping("/client-report/{clientId}")
    public ClientInfo getSingleClientReport(@PathVariable("clientId") String clientId) {
                return connectionService.getSingleClientReport(clientId);
    }

    @RequestMapping("/unpaid-report")
    public UnpaidLoansReport getUnpaidReport() {
        return connectionService.getUnpaidReport();
    }

    @RequestMapping("/get-loan-report/{loanId}")
    public LoanInfo getLoanReport(@PathVariable("loanId") String loanId) {
        return connectionService.getLoanReport(loanId);
    }

    @RequestMapping("/get-loan-stat-report")
    public UnpaidLoansStatistic getLoansStatReport() {
        return connectionService.getStatisticsReport();
    }

}
