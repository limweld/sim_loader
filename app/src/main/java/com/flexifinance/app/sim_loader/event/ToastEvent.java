package com.flexifinance.app.sim_loader.event;

import org.alfonz.arch.event.Event;


public class ToastEvent extends Event
{
	public final String message;


	public ToastEvent(String message)
	{
		this.message = message;
	}
}
