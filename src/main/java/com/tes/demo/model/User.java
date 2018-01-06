package com.tes.demo.model;

import javax.persistence.*;

@Entity
@Table(name="users")
@Access(AccessType.FIELD)
public class User extends ParentEntity{
    private static final long serialVersionUID = 2162425402859174042L;

    @Column(name="first_name", nullable = false, length = 255)
    private String firstName;
    @Column(name="last_name", nullable = false, length = 255)
    private String lastName;
    @Column(name="user_name", nullable = false, length = 100)
    private String userName;
    @Column(name="user_password", nullable = false, length = 100)
    private String userPassword;
    @Column(name="phone", nullable = true, length = 30)
    private String phone;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
