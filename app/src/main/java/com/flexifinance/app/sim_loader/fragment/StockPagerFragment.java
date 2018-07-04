package com.flexifinance.app.sim_loader.fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;

import com.flexifinance.app.sim_loader.R;

import com.flexifinance.app.sim_loader.databinding.FragmentStockPagerBinding;
import com.flexifinance.app.sim_loader.ui.StockPagerView;
import com.flexifinance.app.sim_loader.viewmodel.StockPagerViewModel;

import org.alfonz.adapter.SimpleDataBoundPagerAdapter;


public class StockPagerFragment extends BaseFragment<StockPagerViewModel, FragmentStockPagerBinding> implements StockPagerView
{
	@Override
	public StockPagerViewModel setupViewModel()
	{
		StockPagerViewModel viewModel = ViewModelProviders.of(this).get(StockPagerViewModel.class);
		getLifecycle().addObserver(viewModel);
		return viewModel;
	}


	@Override
	public FragmentStockPagerBinding inflateBindingLayout(@NonNull LayoutInflater inflater)
	{
		return FragmentStockPagerBinding.inflate(inflater);
	}


	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		setupAdapter();
	}


	private void setupAdapter()
	{
		SimpleDataBoundPagerAdapter adapter = new SimpleDataBoundPagerAdapter(
				R.layout.fragment_stock_pager_item,
				this,
				getViewModel().lookups);
		getBinding().stockPagerPager.setAdapter(adapter);
	}
}
