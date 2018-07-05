package com.flexifinance.app.sim_loader.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.flexifinance.app.sim_loader.ui.LoadingListView;
import com.flexifinance.app.sim_loader.viewmodel.LoadingListViewModel;

public class LoadingListCustomAdapter  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
    private LoadingListView mView;
    private LoadingListViewModel mViewModel;

    public LoadingListCustomAdapter(LoadingListView view, LoadingListViewModel viewModel)
    {
        mView = view;
        mViewModel = viewModel;
    }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


}
