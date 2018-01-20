package com.tes.demo.service;

import com.tes.demo.model.TransactionDetails;

import java.util.List;

public interface TransactionDetailsService {

    TransactionDetails save(TransactionDetails transactionDetails);

    List<TransactionDetails> findAll();

}
