package com.advance.academy.homework.bank.system.model;

import com.advance.academy.homework.bank.system.model.enums.UserType;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "customers")
@Where(clause = "is_deleted = false")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private UserType type;

    @NotEmpty
    @Column(name = "email")
    private String email;

    @NotEmpty
    @Column(name = "user_name")
    private String userName;

    @Column(name = "is_deleted")
    private boolean isDeleted = false;

    public Integer getId() {
        return id;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

}


