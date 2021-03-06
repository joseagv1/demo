package com.tes.demo.dao;

import com.tes.demo.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    Transaction save(Transaction transaction);

}
