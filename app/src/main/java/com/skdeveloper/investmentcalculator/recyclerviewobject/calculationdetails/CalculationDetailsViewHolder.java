package com.skdeveloper.investmentcalculator.recyclerviewobject.calculationdetails;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.skdeveloper.investmentcalculator.R;
import com.skdeveloper.investmentcalculator.models.CalculationDetailsViewModel;

import java.text.NumberFormat;
import java.util.Locale;

public class CalculationDetailsViewHolder extends RecyclerView.ViewHolder {
    private TextView year = itemView.findViewById(R.id.year_text);
    private TextView investedamount = itemView.findViewById(R.id.investedamount_text);
    private TextView interestrate = itemView.findViewById(R.id.interestrate_text);
    private TextView interestamount = itemView.findViewById(R.id.interestamount_text);
    private TextView maturityamount = itemView.findViewById(R.id.maturityamount_text);

    public CalculationDetailsViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public void Bind(CalculationDetailsViewModel model) {
        try
        {
            NumberFormat Currencyformater = NumberFormat.getCurrencyInstance(new Locale("en","IN"));
            NumberFormat Numberformater = NumberFormat.getNumberInstance(new Locale("en","IN"));
            year.setText(String.valueOf(model.getYear()));
            investedamount.setText(Currencyformater.format(model.getInvestedAmount()));
            interestrate.setText(Numberformater.format(model.getInterestRate()));
            interestamount.setText(Currencyformater.format(model.getInterestPaid()));
            maturityamount.setText(Currencyformater.format(model.getTotalAmount()));
        }
        catch (Exception ex)
        {

        }
    }
}
