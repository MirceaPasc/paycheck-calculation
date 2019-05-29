package org.fasttrackit.paycheckcalculation.transfer;

import javax.validation.constraints.NotBlank;

public class CreatePaycheckRequest {

    @NotBlank
    private String name;
    private double grossPay;

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

    @Override
    public String toString() {
        return "CreatePaycheckRequest{" +
                "name='" + name + '\'' +
                ", grossPay=" + grossPay +
                '}';
    }
}

