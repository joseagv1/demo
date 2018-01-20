package com.tes.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "transactions")
@Access(AccessType.FIELD)
public class Transaction extends ParentEntity {

    private static final long serialVersionUID = 5061764309856156507L;

    @Column(name = "transaction_name", nullable = false, length = 255)
    private String transactionName;

    /*@Column(name = "transaction_date", nullable = false)
    private Date transactionDate;*/

    @Column(name = "transaction_user", nullable = false)
    @JoinTable(name="users", joinColumns = @JoinColumn(name = "id"))
    private Integer transactionUser;

    public String getTransactionName() {
        return transactionName;
    }

    public void setTransactionName(String transactionName) {
        this.transactionName = transactionName;
    }

    /*public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }*/

    public Integer getTransactionUser() {
        return transactionUser;
    }

    public void setTransactionUser(Integer transactionUser) {
        this.transactionUser = transactionUser;
    }
}
