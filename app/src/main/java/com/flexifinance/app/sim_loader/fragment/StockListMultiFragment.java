package com.flexifinance.app.sim_loader.fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;

import com.flexifinance.app.sim_loader.activity.StockDetailActivity;
import com.flexifinance.app.sim_loader.adapter.StockListMultiAdapter;
import com.flexifinance.app.sim_loader.databinding.FragmentStockListBinding;
import com.flexifinance.app.sim_loader.entity.LookupEntity;
import com.flexifinance.app.sim_loader.ui.StockListView;
import com.flexifinance.app.sim_loader.viewmodel.StockListViewModel;


public class StockListMultiFragment extends BaseFragment<StockListViewModel, FragmentStockListBinding> implements StockListView
{
	@Override
	public StockListViewModel setupViewModel()
	{
		StockListViewModel viewModel = ViewModelProviders.of(this).get(StockListViewModel.class);
		getLifecycle().addObserver(viewModel);
		return viewModel;
	}


	@Override
	public FragmentStockListBinding inflateBindingLayout(@NonNull LayoutInflater inflater)
	{
		return FragmentStockListBinding.inflate(inflater);
	}


	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		getBinding().executePendingBindings(); // helps to reload recycler scroll position after orientation change
		setupAdapter();
	}


	@Override
	public void onItemClick(View view, int position, long id, int viewType)
	{
	}


	@Override
	public void onItemLongClick(View view, int position, long id, int viewType)
	{
	}


	@Override
	public void onItemClick(LookupEntity lookup)
	{
		startStockDetailActivity(lookup.getSymbol());
		getViewModel().addItem();
	}


	@Override
	public boolean onItemLongClick(LookupEntity lookup)
	{
		getViewModel().updateItem(lookup);
		return true;
	}


	private void setupAdapter()
	{
		StockListMultiAdapter adapter = new StockListMultiAdapter(this, getViewModel());
		getBinding().stockListRecycler.setAdapter(adapter);
	}


	private void startStockDetailActivity(String symbol)
	{
		Intent intent = StockDetailActivity.newIntent(getActivity(), symbol);
		getActivity().startActivity(intent);
	}
}
