package com.wolknashatle.dataanalizeservice.service;

import com.wolknashatle.dataanalizeservice.model.*;
import com.wolknashatle.dataanalizeservice.model.reports.LoansInfoReport;
import com.wolknashatle.dataanalizeservice.model.statistics.UnpaidLoansStatistic;
import com.wolknashatle.dataanalizeservice.properties.ApplicationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.validation.ConstraintViolationException;
import java.util.Collections;

@Service
public class GettingDataService {

    @Autowired
    private ApplicationProperties applicationProperties;

    @Autowired
    private RestTemplate restTemplate;

    public UnpaidLoansStatistic getLoansReport() {
        try {
            //Getting data from client-data-service!
            String clientServiceUrl = "http://" + applicationProperties.getDataCollectionServiceHost() + ":" + applicationProperties.getDataCollectionServicePort();
            LoansInfoReport loansInfoReport = restTemplate.getForObject(clientServiceUrl + "/getReport/allLoans/", LoansInfoReport.class);
            LoanList loanList = new LoanList();
            for (ClientInfo clientInfo: loansInfoReport.getClientInfos()) {
                loanList.getList().addAll(clientInfo.getLoanList().getList());
            }
            ClientList clientList = new ClientList();
            for (ClientInfo clientInfo: loansInfoReport.getClientInfos()) {
                clientList.getClientList().add(clientInfo.getClient());
            }
            UnpaidLoansStatistic unpaidLoansStatistic = new UnpaidLoansStatistic();
            for (Loan loan: loanList.getList()) {
                if(!loan.isLoan_is_payed()) {
                    unpaidLoansStatistic.setAllClientsTotalDept(unpaidLoansStatistic.getAllClientsTotalDept() + loan.getLoan_amount());
                    unpaidLoansStatistic.setNumberOfDebts(unpaidLoansStatistic.getNumberOfDebts()+ 1);
                } else {
                    unpaidLoansStatistic.setAmountOfLoansPayedBack(unpaidLoansStatistic.getAmountOfLoansPayedBack() + loan.getLoan_amount());
                }
            }
            unpaidLoansStatistic.setAverageDept(unpaidLoansStatistic.getAllClientsTotalDept()/unpaidLoansStatistic.getNumberOfDebts());
            for (ClientInfo clientInfo: loansInfoReport.getClientInfos()) {
                for(Loan loan: clientInfo.getLoanList().getList()) {
                    if(!loan.isLoan_is_payed()) {
                        unpaidLoansStatistic.setNumberOfDebtors(unpaidLoansStatistic.getNumberOfDebtors() + 1);
                        break;
                    }
                }
            }

            return unpaidLoansStatistic;
        } catch (RuntimeException re) {
            throw new ConstraintViolationException("error", Collections.emptySet());

        }
    }


}
