package com.skdeveloper.investmentcalculator.models;

public class CalculationDetailsViewModel {
    public CalculationDetailsViewModel(int year, Double investedAmount, Double totalAmount, Double interestPaid, Double interestRate) {
        Year = year;
        InvestedAmount = investedAmount;
        TotalAmount = totalAmount;
        InterestPaid = interestPaid;
        InterestRate = interestRate;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }

    public Double getInvestedAmount() {
        return InvestedAmount;
    }

    public void setInvestedAmount(Double investedAmount) {
        InvestedAmount = investedAmount;
    }

    public Double getTotalAmount() {
        return TotalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        TotalAmount = totalAmount;
    }

    public Double getInterestPaid() {
        return InterestPaid;
    }

    public void setInterestPaid(Double interestPaid) {
        InterestPaid = interestPaid;
    }

    public Double getInterestRate() {
        return InterestRate;
    }

    public void setInterestRate(Double interestRate) {
        InterestRate = interestRate;
    }

    public int Year;
    public Double InvestedAmount;
    public Double TotalAmount;
    public Double InterestPaid;
    public Double InterestRate;
}
