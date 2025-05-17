package com.raphael.investControlApi.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL) //oneToMany lazy default (eager  "puxar fio de cabelo vir a peruca")
    private List<Investment> investments;

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public List<Investment> getInvestments() {
        return investments;
    }
    public void setInvestments(List<Investment> investments) {
        this.investments = investments;
    }

}
