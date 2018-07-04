package com.flexifinance.app.sim_loader.viewmodel;

import android.databinding.BaseObservable;

import com.flexifinance.app.sim_loader.entity.LookupEntity;
import com.flexifinance.app.sim_loader.StocksConfig;


public class StockPagerItemViewModel extends BaseObservable
{
	public final LookupEntity lookup;


	public StockPagerItemViewModel(LookupEntity lookup)
	{
		this.lookup = lookup;
	}


	public String getChartUrl()
	{
		return String.format(StocksConfig.CHART_BASE_URL, lookup.getSymbol());
	}
}
