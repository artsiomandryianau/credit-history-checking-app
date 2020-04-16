package com.wolknashatle.datacollectionservice.rs;


import com.wolknashatle.datacollectionservice.model.reports.XmlOverdueLoansReport;
import com.wolknashatle.datacollectionservice.model.reports.XmlSingleClientReport;
import com.wolknashatle.datacollectionservice.model.reports.XmlUnpaidLoansReport;
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
    public XmlSingleClientReport getClientLoansReport(@PathVariable("clientId") String clientId){
        return reportService.getClientLoansReport(clientId);
    }

    @RequestMapping("/overdueReport")
    public XmlOverdueLoansReport getOverdueReport(){
        return reportService.getOverdueReport();
    }

    @RequestMapping("/unpaid")
    public XmlUnpaidLoansReport getUnpaidReport() {
        return reportService.getUnpaidReport();
    }




}
