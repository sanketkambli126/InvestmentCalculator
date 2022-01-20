package com.skdeveloper.investmentcalculator.businesslogic;

import com.skdeveloper.investmentcalculator.models.CalculationDetailsViewModel;

import java.util.ArrayList;
import java.util.List;

public class BL_CalculationDetails {
    public List<CalculationDetailsViewModel> BL_GetCalculationDetailsList(Double PremiumAmount, int YeartoHold, int YearToPay, Double InterestRate)
    {
        List<CalculationDetailsViewModel> data = new ArrayList<CalculationDetailsViewModel>();
        int CurrentYear = 1;
        Double OldTotalAmount = Double.valueOf(0);
        BindList(data,PremiumAmount,YeartoHold,YearToPay,InterestRate,CurrentYear,null);
        return data;
    }

    private void BindList(List<CalculationDetailsViewModel> data, Double premiumAmount, int yeartoHold, int yearToPay, Double interestRate, int currentYear, CalculationDetailsViewModel previousdata) {
        if(currentYear <= yeartoHold) {
            if (currentYear == 1) {
                int year = currentYear;
                Double InvestedAmount = currentYear <= yearToPay ? premiumAmount : Double.valueOf(0);
                Double InterestAmount = (currentYear <= yearToPay ? premiumAmount : Double.valueOf(0)) * interestRate / 100;
                Double TotalAmount = InvestedAmount + InterestAmount;
                CalculationDetailsViewModel VM = new CalculationDetailsViewModel(currentYear, InvestedAmount, TotalAmount, InterestAmount, interestRate);
                data.add(VM);
                BindList(data, premiumAmount, yeartoHold, yearToPay, interestRate, currentYear + 1, VM);
            } else if (currentYear == yeartoHold) {
                int year = currentYear;
                Double InvestedAmount = previousdata.getInvestedAmount() + (currentYear <= yearToPay ? premiumAmount : Double.valueOf(0));
                Double InterestAmount = ((previousdata.getTotalAmount() + ((currentYear <= yearToPay ? premiumAmount : Double.valueOf(0)))) * interestRate) / 100;
                Double TotalAmount = previousdata.getTotalAmount() + ((currentYear <= yearToPay ? premiumAmount : Double.valueOf(0))) + InterestAmount;
                CalculationDetailsViewModel VM = new CalculationDetailsViewModel(currentYear, InvestedAmount, TotalAmount, InterestAmount, interestRate);
                data.add(VM);
            } else {
                int year = currentYear;
                Double InvestedAmount = previousdata.getInvestedAmount() + (currentYear <= yearToPay ? premiumAmount : Double.valueOf(0));
                Double InterestAmount = ((previousdata.getTotalAmount() + ((currentYear <= yearToPay ? premiumAmount : Double.valueOf(0)))) * interestRate) / 100;
                Double TotalAmount = previousdata.getTotalAmount() + ((currentYear <= yearToPay ? premiumAmount : Double.valueOf(0))) + InterestAmount;
                CalculationDetailsViewModel VM = new CalculationDetailsViewModel(currentYear, InvestedAmount, TotalAmount, InterestAmount, interestRate);
                data.add(VM);
                BindList(data, premiumAmount, yeartoHold, yearToPay, interestRate, currentYear + 1, VM);
            }
        }
    }
}
