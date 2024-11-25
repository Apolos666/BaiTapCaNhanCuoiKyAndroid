package com.example.luyenandroid;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CongViecAdapter extends RecyclerView.Adapter<CongViecAdapter.CongViecViewHolder> {
    private List<CongViec> congViecList;

    public CongViecAdapter(List<CongViec> congViecList) {
        this.congViecList = congViecList;
    }

    @NonNull
    @Override
    public CongViecViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.item_congviec, null);
        return new CongViecViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CongViecViewHolder holder, int position) {
        CongViec congViec = congViecList.get(position);
        holder.titleTextView.setText(congViec.getTitle());
        holder.companyTextView.setText(congViec.getCompany());
        holder.dateTextView.setText(congViec.getDate());
    }

    @Override
    public int getItemCount() {
        return congViecList.size();
    }

    static class CongViecViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView, companyTextView, dateTextView;

        public CongViecViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            companyTextView = itemView.findViewById(R.id.companyTextView);
            dateTextView = itemView.findViewById(R.id.dateTextView);
        }
    }
}
