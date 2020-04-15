package com.wolknashatle.loandataservice.rs;


import com.wolknashatle.loandataservice.models.Loan;
import com.wolknashatle.loandataservice.models.LoanList;
import com.wolknashatle.loandataservice.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loans")
public class LoansCheckingResource {

    @Autowired
    public LoanService loanService;

    @RequestMapping("/loan/{loanId}")
    public Loan getLoanById(@PathVariable("loanId") String id) {
        return loanService.getLoanById(Integer.parseInt(id));
    }

    @RequestMapping("/client/{clientId}")
    public LoanList getLoansListByClientId(@PathVariable("clientId") String id) {
        return new LoanList(loanService.getLoanByClientId(Integer.parseInt(id)));
    }

    @RequestMapping("/overdue")
    public LoanList getLoansOfClient() {
        return new LoanList(loanService.getListOfOverdue());
    }

    @RequestMapping("/unpaid")
    public LoanList getListOfNotPayed() {
        return new LoanList(loanService.getListOfNotPayed());
    }
}
