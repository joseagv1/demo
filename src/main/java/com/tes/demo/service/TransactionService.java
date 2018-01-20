package com.tes.demo.service;

import com.tes.demo.model.Transaction;

import java.util.List;

public interface TransactionService {

    Transaction save(Transaction transaction);

    List<Transaction> findAll();
}
