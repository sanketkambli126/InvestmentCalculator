package com.skdeveloper.investmentcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.math.BigDecimal;

import constants.IntentKeys;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn_calculate = findViewById(R.id.calculate_btn);
        EditText et_amount, et_no_of_year_to_hold, et_no_of_years_to_pay, et_interest;
        et_amount = findViewById(R.id.amount_txt);
        et_no_of_year_to_hold = findViewById(R.id.noofyears_txt);
        et_no_of_years_to_pay = findViewById(R.id.noofyears_pay_txt);
        RadioGroup rg_premium_type = findViewById(R.id.paid_duration_btn);
        et_interest = findViewById(R.id.interest_rate_text);
        et_interest.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length() > 0 && Integer.valueOf(s.toString()) > 100)
                {
                    et_interest.setText(String.valueOf(100));
                    Toast.makeText(getApplicationContext(),"Interest Rate cannot be greater than 100",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(et_amount.getText().toString().equals("") || et_amount.getText().toString() == null
                || et_no_of_year_to_hold.getText().toString().equals("") || et_no_of_year_to_hold.getText().toString() == null
                || et_no_of_years_to_pay.getText().toString().equals("") || et_no_of_years_to_pay.getText().toString() == null
                || et_interest.getText().toString() == null || et_interest.getText().toString()=="")
                {
                    Toast.makeText(getApplicationContext(),"Please provide all the required data!!!",Toast.LENGTH_SHORT).show();
                }
                else if(Integer.valueOf(et_no_of_year_to_hold.getText().toString()) < Integer.valueOf(et_no_of_years_to_pay.getText().toString()))
                {
                    Toast.makeText(getApplicationContext(),"Years to hold cannot be less than years to pay",Toast.LENGTH_SHORT).show();
                }
                else {
                  Double  YearlyPremiumAmount = Double.valueOf(0);
                    switch(rg_premium_type.getCheckedRadioButtonId())
                    {
                        case  R.id.paid_duration_monthly_btn:
                            YearlyPremiumAmount = Double.valueOf(et_amount.getText().toString()) * 12;
                            break;
                        case R.id.paid_duration_yearly_btn:
                            YearlyPremiumAmount = Double.valueOf(et_amount.getText().toString());
                        default:
                            break;
                    }
                    Intent i = new Intent(MainActivity.this,CalculationDetailsActivity.class);
                    i.putExtra(IntentKeys.Amount,YearlyPremiumAmount.toString());
                    i.putExtra(IntentKeys.NoofYearsToHold,et_no_of_year_to_hold.getText().toString());
                    i.putExtra(IntentKeys.NoofYearsToPay,et_no_of_years_to_pay.getText().toString());
                    i.putExtra(IntentKeys.InterestRate,et_interest.getText().toString());
                    startActivity(i);
                }
            }
        });
    }
}