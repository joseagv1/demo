package com.tes.demo.service;

import com.tes.demo.dao.TransactionRepository;
import com.tes.demo.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    protected TransactionRepository transactionRepository;

    @Override
    public Transaction save(Transaction transaction){
        return this.transactionRepository.save(transaction);
    }

    @Override
    public List<Transaction> findAll(){
        return transactionRepository.findAll();
    }
}
