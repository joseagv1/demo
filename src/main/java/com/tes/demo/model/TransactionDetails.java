package com.tes.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "transactiondetails")
@Access(AccessType.FIELD)
public class TransactionDetails extends ParentEntity {

    private static final long serialVersionUID = -2822026344013997832L;

    @Column(name = "transaction_description", nullable = false, length = 400)
    private String transactionDescription;

    @Column(name = "transactions_id", nullable = false)
    @JoinTable(name = "transactions", joinColumns = @JoinColumn(name = "id"))
    public Integer transactionsId;

    public String getTransactionDescription() {
        return transactionDescription;
    }

    public void setTransactionDescription(String transactionDescription) {
        this.transactionDescription = transactionDescription;
    }

    public Integer getTransactionsId() {
        return transactionsId;
    }

    public void setTransactionsId(Integer transactionsId) {
        this.transactionsId = transactionsId;
    }
}