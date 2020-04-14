package com.wolknashatle.loandataservice.sr;


import com.wolknashatle.loandataservice.models.Loan;
import com.wolknashatle.loandataservice.repositories.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/loans")
public class LoansCheckingService {

    @Autowired
    private LoanRepository loanRepository;

    @RequestMapping("/{clientId}")
    public List<Loan> getLoansOfClient(@PathVariable("clientIf") String id) {
        return loanRepository.findByUserIdent(Integer.parseInt(id));
    }
}
