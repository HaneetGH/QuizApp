package com.technorapper.ui.home;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;


import com.technorapper.global.interfaces.RecyclerViewClickListener;
import com.technorapper.model.Question;
import com.technorapper.quizapp.R;
import com.technorapper.quizapp.databinding.ItemCellBinding;

import java.util.List;

public class AnsListAdapter extends RecyclerView.Adapter<AnsListAdapter.MyViewHolder> {

    private List<String> material;
    private RecyclerViewClickListener mListener;

    public AnsListAdapter(List<String> material, RecyclerViewClickListener mListener) {
        this.material = material;
        this.mListener = mListener;

    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ItemCellBinding binding;

        public MyViewHolder(ItemCellBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemCellBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_cell, parent, false);
        return new MyViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.binding.setModel(material.get(position));
        holder.binding.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null)
                    mListener.onClick(v, position);
            }
        });


    }


    @Override
    public int getItemCount() {
        return material.size();
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
}
