package org.fasttrackit.paycheckcalculation.transfer;

import java.util.Objects;

public class PaycheckResponse {

    private long id;
    private String name;
    private double grossPay;
    private double socialSecurity;
    private double medicalInsurance;
    private double incomeTax;
    private double netPay;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public double getSocialSecurity() {
        return socialSecurity;
    }

    public void setSocialSecurity(double socialSecurity) {
        this.socialSecurity = socialSecurity;
    }

    public double getMedicalInsurance() {
        return medicalInsurance;
    }

    public void setMedicalInsurance(double medicalInsurance) {
        this.medicalInsurance = medicalInsurance;
    }

    public double getIncomeTax() {
        return incomeTax;
    }

    public void setIncomeTax(double incomeTax) {
        this.incomeTax = incomeTax;
    }

    public double getNetPay() {
        return netPay;
    }

    public void setNetPay(double netPay) {
        this.netPay = netPay;
    }

    @Override
    public String toString() {
        return "Paycheck{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grossPay=" + grossPay +
                ", socialSecurity=" + socialSecurity +
                ", medicalInsurance=" + medicalInsurance +
                ", incomeTax=" + incomeTax +
                ", netPay=" + netPay +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaycheckResponse that = (PaycheckResponse) o;
        return id == that.id &&
                Double.compare(that.grossPay, grossPay) == 0 &&
                Double.compare(that.socialSecurity, socialSecurity) == 0 &&
                Double.compare(that.medicalInsurance, medicalInsurance) == 0 &&
                Double.compare(that.incomeTax, incomeTax) == 0 &&
                Double.compare(that.netPay, netPay) == 0 &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, grossPay, socialSecurity, medicalInsurance, incomeTax, netPay);
    }
}