package com.raphael.investControlApi.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public class InvestmentDTO {

    @NotBlank(message = "Nome obrigatório")
    private String name;

    @NotBlank(message = "Tipo de investimento obrigatório")
    private String type;

    @DecimalMin(value = "0.01", message = "Valor investido deve ser maior que 0")
    private double valueInvested;

    @NotNull(message = "Data do investimento obrigatória")
    @PastOrPresent(message = "A data do investimento não pode estar no futuro.")
    private LocalDate investmentDate;


    public string getName() {
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


}
