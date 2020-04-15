package com.wolknashatle.loandataservice.sr;


import com.wolknashatle.loandataservice.models.Loan;
import com.wolknashatle.loandataservice.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/loans")
public class LoansCheckingService {

    @Autowired
    public LoanService loanService;

    @RequestMapping("/loan/{loanId}")
    public Loan getLoanById(@PathVariable("loanId") String id) {
        return loanService.getLoanById(Integer.parseInt(id));
    }

    @RequestMapping("/client/{clientId}")
    public List<Loan> getLoansListByClientId(@PathVariable("clientId") String id) {
        return loanService.getLoanByClientId(Integer.parseInt(id));
    }

    @RequestMapping("/overdue")
    public List<Loan> getLoansOfClient() {
        return loanService.getListOfOverdue();
    }

    @RequestMapping("/unpaid")
    public List<Loan> getListOfNotPayed() {
        return loanService.getListOfNotPayed();
    }
}
