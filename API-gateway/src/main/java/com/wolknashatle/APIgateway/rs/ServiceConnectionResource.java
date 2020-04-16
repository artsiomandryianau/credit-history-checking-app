package com.wolknashatle.APIgateway.rs;

import com.wolknashatle.APIgateway.model.reports.XmlOverdueLoansReport;
import com.wolknashatle.APIgateway.model.reports.XmlSingleClientReport;
import com.wolknashatle.APIgateway.model.reports.XmlUnpaidLoansReport;
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
    public XmlOverdueLoansReport getOverdueReport() {
        return connectionService.getOverdueReport();
    }

    @RequestMapping("/client-report/{clientId}")
    public XmlSingleClientReport getSingleClientReport(@PathVariable("clientId") String clientId) {
                return connectionService.getSingleClientReport(clientId);
    }

    @RequestMapping("/unpaid-report")
    public XmlUnpaidLoansReport getUnpaidReport() {
        return connectionService.getUnpaidReport();
    }

}
