package com.flexifinance.app.sim_loader.fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;

import com.flexifinance.app.sim_loader.activity.StockDetailActivity;
import com.flexifinance.app.sim_loader.adapter.StockListCustomAdapter;
import com.flexifinance.app.sim_loader.databinding.FragmentStockListBinding;
import com.flexifinance.app.sim_loader.entity.LookupEntity;
import com.flexifinance.app.sim_loader.ui.StockListView;
import com.flexifinance.app.sim_loader.viewmodel.StockListViewModel;


public class StockListCustomFragment extends BaseFragment<StockListViewModel, FragmentStockListBinding> implements StockListView
{
	private StockListCustomAdapter mAdapter;


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
		int lookupPosition = mAdapter.getLookupPosition(position);
		startStockDetailActivity(getViewModel().lookups.get(lookupPosition).getSymbol());
//		getViewModel().addItem();
//		mAdapter.notifyDataSetChanged();
	}


	@Override
	public void onItemLongClick(View view, int position, long id, int viewType)
	{
		int lookupPosition = mAdapter.getLookupPosition(position);
		getViewModel().updateItem(lookupPosition);
		mAdapter.notifyItemChanged(position);
	}


	@Override
	public void onItemClick(LookupEntity lookup)
	{
	}


	@Override
	public boolean onItemLongClick(LookupEntity lookup)
	{
		return true;
	}


	private void setupAdapter()
	{
		if(mAdapter == null)
		{
			mAdapter = new StockListCustomAdapter(this, getViewModel());
			getBinding().stockListRecycler.setAdapter(mAdapter);
		}
	}


	private void startStockDetailActivity(String symbol)
	{
		Intent intent = StockDetailActivity.newIntent(getActivity(), symbol);
		getActivity().startActivity(intent);
	}
}
