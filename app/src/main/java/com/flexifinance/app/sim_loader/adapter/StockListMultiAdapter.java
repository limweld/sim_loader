package com.flexifinance.app.sim_loader.adapter;

import com.flexifinance.app.sim_loader.R;
import com.flexifinance.app.sim_loader.entity.LookupEntity;
import com.flexifinance.app.sim_loader.ui.StockListView;
import com.flexifinance.app.sim_loader.viewmodel.StockListViewModel;

import org.alfonz.adapter.MultiDataBoundRecyclerAdapter;


public class StockListMultiAdapter extends MultiDataBoundRecyclerAdapter
{
	public StockListMultiAdapter(StockListView view, StockListViewModel viewModel)
	{
		super(
				view,
				viewModel.headers,
				viewModel.lookups,
				viewModel.footers
		);
	}


	@Override
	public int getItemLayoutId(int position)
	{
		Object item = getItem(position);
		if(item instanceof String)
		{
			return R.layout.fragment_stock_list_header;
		}
		else if(item instanceof LookupEntity)
		{
			return R.layout.fragment_stock_list_item_clickable;
		}
		else if(item instanceof Object)
		{
			return R.layout.fragment_stock_list_footer;
		}
		throw new IllegalArgumentException("Unknown item type " + item);
	}
}
