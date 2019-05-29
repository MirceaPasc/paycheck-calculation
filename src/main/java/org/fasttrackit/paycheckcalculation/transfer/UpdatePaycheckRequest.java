package org.fasttrackit.paycheckcalculation.transfer;

public class UpdatePaycheckRequest {


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

