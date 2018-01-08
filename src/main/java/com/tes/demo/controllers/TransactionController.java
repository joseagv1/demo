package com.tes.demo.controllers;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tes.demo.model.Transaction;
import com.tes.demo.service.TransactionService;
import com.tes.demo.util.RestResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class TransactionController {

    @Autowired
    protected TransactionService transactionService;

    protected ObjectMapper mapper;

    @RequestMapping(value="/saveOrUpdateTransaction", method = RequestMethod.POST)
    public RestResponse saveOrUpdateTransaction(@RequestBody String transactionJson) throws JsonParseException, JsonMappingException, IOException{
        this.mapper = new ObjectMapper();
        Transaction transaction = this.mapper.readValue(transactionJson, Transaction.class);

        if(!this.validate(transaction)){
            return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(), "The Fields are incorrect");
        }
        this.transactionService.save(transaction);
        return new RestResponse(HttpStatus.OK.value(),"Operation Successful!!!");
    }

    private boolean validate(Transaction transaction){
        boolean isValid = true;

        if(org.apache.commons.lang3.StringUtils.trimToNull(transaction.getTransactionName())  == null){
            isValid = false;
        }
        /*if(transaction.getTransactionDate()  == null){
            isValid = false;
        }*/
        if(transaction.getTransactionUser()  == null){
            isValid = false;
        }

        return isValid;
    }
}
