package org.fasttrackit.paycheckcalculation.transfer;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

public class CreatePaycheckRequest {

    @NotBlank
    private String name;
    private double grossPay;
    private LocalDate date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGrossPay() {
        return grossPay;
    }

    public void setGrossPay(double grossPay) {
        this.grossPay = grossPay;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}


