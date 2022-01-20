package com.skdeveloper.investmentcalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.skdeveloper.investmentcalculator.businesslogic.BL_CalculationDetails;
import com.skdeveloper.investmentcalculator.models.CalculationDetailsViewModel;
import com.skdeveloper.investmentcalculator.recyclerviewobject.calculationdetails.CalculationDetailsAdapter;

import java.util.ArrayList;
import java.util.List;

import constants.IntentKeys;

public class CalculationDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculation_details);
        Intent i = getIntent();
        if(i!=null)
        {
            Double Amount = Double.valueOf(i.getStringExtra(IntentKeys.Amount));
            int YeartoHold = Integer.valueOf(i.getStringExtra(IntentKeys.NoofYearsToHold));
            int YearToPay = Integer.valueOf(i.getStringExtra(IntentKeys.NoofYearsToPay));
            Double InterestRate = Double.valueOf(i.getStringExtra(IntentKeys.InterestRate));
            RecyclerView rcv_calculationdetails = findViewById(R.id.recyclerview_calculationdetails);
            rcv_calculationdetails.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            CalculationDetailsAdapter adapter = new CalculationDetailsAdapter();
            List<CalculationDetailsViewModel> list = new BL_CalculationDetails().BL_GetCalculationDetailsList(Amount, YeartoHold, YearToPay, InterestRate);
            adapter.submitList(list);
            rcv_calculationdetails.setAdapter(adapter);
        }
    }
}