package com.tes.demo.dao;

import com.tes.demo.model.TransactionDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionDetailsRepository extends JpaRepository<TransactionDetails, Long>{

}
