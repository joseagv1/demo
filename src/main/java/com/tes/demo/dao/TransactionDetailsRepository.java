package com.tes.demo.dao;

import com.tes.demo.model.TransactionDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TransactionDetailsRepository extends JpaRepository<TransactionDetails, Long>{

    TransactionDetails save(TransactionDetails transactionDetails);

}
