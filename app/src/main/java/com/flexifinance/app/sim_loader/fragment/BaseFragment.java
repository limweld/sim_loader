package com.flexifinance.app.sim_loader.fragment;

import android.content.Context;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.flexifinance.app.sim_loader.StocksApplication;
import com.flexifinance.app.sim_loader.event.SnackbarEvent;
import com.flexifinance.app.sim_loader.event.ToastEvent;
import com.flexifinance.app.sim_loader.viewmodel.BaseViewModel;

import org.alfonz.arch.AlfonzBindingFragment;
import org.alfonz.utility.Logcat;


public abstract class BaseFragment<T extends BaseViewModel, B extends ViewDataBinding> extends AlfonzBindingFragment<T, B>
{
	@Override
	public void onAttach(Context context)
	{
		Logcat.v("");
		super.onAttach(context);
	}


	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		Logcat.v("");
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
		setupObservers();
	}


	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		Logcat.v("");
		return super.onCreateView(inflater, container, savedInstanceState);
	}


	@Override
	public void onViewCreated(@NonNull View view, Bundle savedInstanceState)
	{
		Logcat.v("");
		super.onViewCreated(view, savedInstanceState);
	}


	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		Logcat.v("");
		super.onActivityCreated(savedInstanceState);
	}


	@Override
	public void onStart()
	{
		Logcat.v("");
		super.onStart();
	}


	@Override
	public void onResume()
	{
		Logcat.v("");
		super.onResume();
	}


	@Override
	public void onPause()
	{
		Logcat.v("");
		super.onPause();
	}


	@Override
	public void onStop()
	{
		Logcat.v("");
		super.onStop();
	}


	@Override
	public void onDestroyView()
	{
		Logcat.v("");
		super.onDestroyView();
	}


	@Override
	public void onDestroy()
	{
		Logcat.v("");
		super.onDestroy();

		// leak canary watcher
		StocksApplication.getRefWatcher().watch(this);
		if(getActivity().isFinishing()) StocksApplication.getRefWatcher().watch(getViewModel());
	}


	@Override
	public void onDetach()
	{
		Logcat.v("");
		super.onDetach();
	}


	public void showToast(String message)
	{
		Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
	}


	public void showSnackbar(String message)
	{
		if(getView() != null)
		{
			Snackbar.make(getView(), message, Snackbar.LENGTH_LONG).show();
		}
	}


	private void setupObservers()
	{
		getViewModel().observeEvent(this, ToastEvent.class, toastEvent -> showToast(toastEvent.message));
		getViewModel().observeEvent(this, SnackbarEvent.class, snackbarEvent -> showSnackbar(snackbarEvent.message));
	}
}
