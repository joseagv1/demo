package com.tes.demo.controllers;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tes.demo.model.User;
import com.tes.demo.service.UserService;
import com.tes.demo.util.RestResponse;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class UserController {

    @Autowired
    protected UserService userService;

    protected ObjectMapper mapper;

    @RequestMapping(value="/saveOrUpdate", method = RequestMethod.POST)
    public RestResponse saveOrUpdate(@RequestBody String userJson) throws JsonParseException, JsonMappingException, IOException{
        this.mapper = new ObjectMapper();
        User user = this.mapper.readValue(userJson, User.class);

        if(!this.validate(user)){
            return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(), "The Fields are incorrect");
        }
        this.userService.save(user);
        return new RestResponse(HttpStatus.OK.value(),"Operation Successful!!!");
    }

    private boolean validate(User user){
        boolean isValid = true;

        if(org.apache.commons.lang3.StringUtils.trimToNull(user.getFirstName())  == null){
            isValid = false;
        }
        if(org.apache.commons.lang3.StringUtils.trimToNull(user.getLastName()) == null){
            isValid = false;
        }
        if(org.apache.commons.lang3.StringUtils.trimToNull(user.getUserName()) == null){
            isValid = false;
        }
        if(org.apache.commons.lang3.StringUtils.trimToNull(user.getUserPassword()) == null){
            isValid = false;
        }
        return isValid;
    }
}
