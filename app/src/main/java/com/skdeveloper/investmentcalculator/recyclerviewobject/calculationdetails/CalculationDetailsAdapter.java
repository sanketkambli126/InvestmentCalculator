package com.skdeveloper.investmentcalculator.recyclerviewobject.calculationdetails;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.skdeveloper.investmentcalculator.R;
import com.skdeveloper.investmentcalculator.models.CalculationDetailsViewModel;

public class CalculationDetailsAdapter extends ListAdapter<CalculationDetailsViewModel,CalculationDetailsViewHolder> {
    private static DiffUtil.ItemCallback<CalculationDetailsViewModel> diffCallback = new DiffUtil.ItemCallback<CalculationDetailsViewModel>() {
        @Override
        public boolean areItemsTheSame(@NonNull CalculationDetailsViewModel oldItem, @NonNull CalculationDetailsViewModel newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull CalculationDetailsViewModel oldItem, @NonNull CalculationDetailsViewModel newItem) {
            return (oldItem.getYear() == newItem.getYear());
        }
    };
    public CalculationDetailsAdapter() {
        super(diffCallback);
    }

    @NonNull
    @Override
    public CalculationDetailsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_calculation_details_item,parent,false);
        return new CalculationDetailsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CalculationDetailsViewHolder holder, int position) {
        holder.Bind(getItem(position));
    }
}
