package com.raphael.investControlApi.dto;

import com.raphael.investControlApi.model.Investment;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

import java.math.BigDecimal;


public class InvestmentDTO {

    @NotBlank(message = "Nome obrigatório")
    private String name;

    @NotBlank(message = "Tipo de investimento obrigatório")
    private String type;

    @DecimalMin(value = "0.01", message = "Valor investido deve ser maior que 0")
    private BigDecimal valueInvested;

    @NotNull(message = "Data do investimento obrigatória")
    @PastOrPresent(message = "A data do investimento não pode estar no futuro.")
    private LocalDate investmentDate;

    public InvestmentDTO(Investment investment) {
        this.name =investment.getName();
        this.type = investment.getType();
        this.valueInvested = investment.getValueInvested();
        this.investmentDate = investment.getInvestmentDate();
        
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
    public BigDecimal getValueInvested() {
        return valueInvested;
    }
    public void setValueInvested(BigDecimal valueInvested) {
        this.valueInvested = valueInvested;
    }
    public LocalDate getInvestmentDate() {
        return investmentDate;
    }
    public void setInvestmentDate(LocalDate investmentDate) {
        this.investmentDate = investmentDate;
    }


}
