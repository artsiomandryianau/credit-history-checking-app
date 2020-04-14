package com.wolknashatle.loandataservice.repositories;

import com.wolknashatle.loandataservice.models.Loan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface LoanRepository extends MongoRepository<Loan, Integer> {

    @Query("{loan_is_payed : false}")
    List<Loan> findLoanNotPayed();

    @Query("{'client_id : ?0'}")
    List<Loan> findByUserIdent(Integer userId);

}
