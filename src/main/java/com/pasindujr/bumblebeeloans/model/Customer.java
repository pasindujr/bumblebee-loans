package com.pasindujr.bumblebeeloans.model;

public class Customer {

    private int customerId;
    private String name;
    private String dob;
    private String loanBalance;
    private String usedAmount;
    private String installmentPlan;


    public Customer(int customerId, String name, String dob, String loanBalance, String usedAmount, String installmentPlan) {
        this.customerId = customerId;
        this.name = name;
        this.dob = dob;
        this.loanBalance = loanBalance;
        this.usedAmount = usedAmount;
        this.installmentPlan = installmentPlan;
    }

    public Customer(String name, String dob, String loanBalance, String usedAmount, String installmentPlan) {
        this.name = name;
        this.dob = dob;
        this.loanBalance = loanBalance;
        this.usedAmount = usedAmount;
        this.installmentPlan = installmentPlan;
    }

    public Customer() {
    }

    public Customer(String name, String dob, String loanBalance, String installmentPlan) {
        this.name = name;
        this.dob = dob;
        this.loanBalance = loanBalance;
        this.installmentPlan = installmentPlan;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getLoanBalance() {
        return loanBalance;
    }

    public void setLoanBalance(String loanBalance) {
        this.loanBalance = loanBalance;
    }

    public String getUsedAmount() {
        return usedAmount;
    }

    public void setUsedAmount(String usedAmount) {
        this.usedAmount = usedAmount;
    }

    public String getInstallmentPlan() {
        return installmentPlan;
    }

    public void setInstallmentPlan(String installmentPlan) {
        this.installmentPlan = installmentPlan;
    }
}
