package com.tes.demo.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "transactions")
@Access(AccessType.FIELD)
public class Transaction extends ParentEntity {

    private static final long serialVersionUID = 5061764309856156507L;

    @Column(name = "transaction_name", nullable = false, length = 255)
    private String transactionName;

    @Column(name = "transaction_date", nullable = false)
    private Date transactionDate;
    
    @Column(name = "transaction_user", nullable = false)
    private Integer transactionUser;
}
