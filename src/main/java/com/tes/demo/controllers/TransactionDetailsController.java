package com.tes.demo.controllers;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tes.demo.model.TransactionDetails;
import com.tes.demo.service.TransactionDetailsService;
import com.tes.demo.util.RestResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class TransactionDetailsController {

    @Autowired
    protected TransactionDetailsService transactionDetailsService;

    protected ObjectMapper mapper;

    @RequestMapping(value = "/saveOrUpdateTransactionDetails", method = RequestMethod.POST)
    public RestResponse saveOrUpdateTransaction(@RequestBody String transactionDetailsJson) throws JsonParseException, JsonMappingException, IOException{
        this.mapper = new ObjectMapper();
        TransactionDetails transactionDetails = this.mapper.readValue(transactionDetailsJson, TransactionDetails.class);

        if(!this.validate(transactionDetails)){
            return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(), "The Fields are incorrect");
        }
        this.transactionDetailsService.save(transactionDetails);
        return new RestResponse(HttpStatus.OK.value(),"Operation Successful!!!");
    }

    private boolean validate(TransactionDetails transactionDetails){
        boolean isValid = true;

        if(org.apache.commons.lang3.StringUtils.trimToNull(transactionDetails.getTransactionDescription())  == null)
            isValid = false;
        if(transactionDetails.getTransactionsId()  == null)
            isValid = false;

        return isValid;
    }
}
