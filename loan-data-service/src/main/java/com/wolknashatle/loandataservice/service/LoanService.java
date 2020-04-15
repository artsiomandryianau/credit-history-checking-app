package com.wolknashatle.loandataservice.service;


import com.mongodb.*;
import com.wolknashatle.loandataservice.detials.ProjectDetails;
import com.wolknashatle.loandataservice.models.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoanService {

    @Autowired
    public ProjectDetails projectDetails;

    MongoClient mongo;
    DB db;
    DBCollection table;

    public LoanService() {
        mongo = new MongoClient("localhost", 27017);
        db = mongo.getDB("admin");
        table = db.getCollection("loans");
    }

    public Loan getLoanById(Integer id){
        
        return new Loan();
    }


    public List<Loan> getListOfOverdue() {
        return getListOfNotPayed().stream()
                .filter(loan -> LocalDate.of(Integer.parseInt(loan.getDate_loan_take().substring(0,4)),
                        Integer.parseInt(loan.getDate_loan_take().substring(5,7)), Integer.parseInt(loan.getDate_loan_take().substring(8,10))).
                        plusMonths(loan.getLoan_number_month_back()).isBefore(LocalDate.now()))
                .sorted(Comparator.comparing(Loan::getLoan_amount))
                .collect(Collectors.toList());
        }






    public List<Loan> getListOfNotPayed(){
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("loan_is_payed", false);
        List<Loan> list = new ArrayList<>();

        DBCursor cursor = table.find(searchQuery);

        while (cursor.hasNext()) {
            DBObject theObj = cursor.next();
            Loan loan = new Loan();
            loan.setLoan_id((Integer)theObj.get("loan_id"));
            loan.setClient_id((Integer)theObj.get("client_id"));
            loan.setLoan_is_payed((Boolean) theObj.get("loan_is_payed"));
            loan.setDate_loan_take((String)theObj.get("date_loan_was_taken"));
            loan.setLoan_number_month_back((Integer)theObj.get("loan_number_month_back"));
            loan.setLoan_amount((Integer)theObj.get("loan_amount"));
            list.add(loan);
        }
        return list;
    }

}
