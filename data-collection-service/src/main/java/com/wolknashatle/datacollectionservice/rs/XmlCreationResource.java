package com.wolknashatle.datacollectionservice.rs;


import com.wolknashatle.datacollectionservice.model.ClientInfo;
import com.wolknashatle.datacollectionservice.model.LoanInfo;
import com.wolknashatle.datacollectionservice.model.reports.OverdueLoansReport;
import com.wolknashatle.datacollectionservice.model.reports.UnpaidLoansReport;
import com.wolknashatle.datacollectionservice.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/getReport")
@RestController
public class XmlCreationResource {

    @Autowired
    private ReportService reportService;

    @RequestMapping("/clientsLoans/{clientId}")
    public ClientInfo getClientLoansReport(@PathVariable("clientId") String clientId){
        return reportService.getClientLoansReport(clientId);
    }

    @RequestMapping("/loanReport/{loanId}")
    public LoanInfo getLoanReport(@PathVariable("loanId") String loanId){
        return reportService.getLoanReport(loanId);
    }

    @RequestMapping("/overdueReport")
    public OverdueLoansReport getOverdueReport(){
        return reportService.getOverdueReport();
    }

    @RequestMapping("/unpaid")
    public UnpaidLoansReport getUnpaidReport() {
        return reportService.getUnpaidReport();
    }




}
