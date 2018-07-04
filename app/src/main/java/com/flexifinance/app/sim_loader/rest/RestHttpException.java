package com.flexifinance.app.sim_loader.rest;

import android.support.annotation.NonNull;

import com.flexifinance.app.sim_loader.entity.ErrorEntity;

import org.alfonz.rest.HttpException;

import java.io.IOException;
import java.lang.annotation.Annotation;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;


public class RestHttpException extends HttpException
{
	public RestHttpException(Response<?> response)
	{
		super(response);
	}


	@Override
	public Object parseError(@NonNull Response<?> response)
	{
		try
		{
			Converter<ResponseBody, ErrorEntity> converter = RetrofitClient.getRetrofit().responseBodyConverter(ErrorEntity.class, new Annotation[0]);
			return converter.convert(response.errorBody());
		}
		catch(IOException | NullPointerException e)
		{
			e.printStackTrace();
			ErrorEntity error = new ErrorEntity();
			error.setMessage("Unknown error");
			return error;
		}
	}
}
