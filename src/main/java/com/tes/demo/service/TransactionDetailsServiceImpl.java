package com.tes.demo.service;

import com.tes.demo.dao.TransactionDetailsRepository;
import com.tes.demo.model.TransactionDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionDetailsServiceImpl implements TransactionDetailsService {

    @Autowired
    protected TransactionDetailsRepository transactionDetailsRepository;

    @Override
    public TransactionDetails save(TransactionDetails transactionDetails){
        return this.transactionDetailsRepository.save(transactionDetails);
    }
}
