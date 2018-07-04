package com.flexifinance.app.sim_loader.viewmodel;

import android.content.Context;

import com.flexifinance.app.sim_loader.event.ToastEvent;
import com.flexifinance.app.sim_loader.StocksApplication;

import org.alfonz.arch.AlfonzViewModel;
import org.alfonz.utility.Logcat;


public abstract class BaseViewModel extends AlfonzViewModel
{
	@Override
	public void onCleared()
	{
		Logcat.v("");
		super.onCleared();
	}


	public Context getApplicationContext()
	{
		return StocksApplication.getContext();
	}


	public void handleError(String message)
	{
		sendEvent(new ToastEvent(message));
	}
}
