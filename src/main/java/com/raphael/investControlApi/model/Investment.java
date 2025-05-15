package com.raphael.investControlApi.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "investments")
public class Investment {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;
    private double valueInvested;
    private LocalDate investmentDate;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public double getValueInvested() {
        return valueInvested;
    }
    public void setValueInvested(double valueInvested) {
        this.valueInvested = valueInvested;
    }
    public LocalDate getInvestmentDate() {
        return investmentDate;
    }
    public void setInvestmentDate(LocalDate investmentDate) {
        this.investmentDate = investmentDate;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

}
