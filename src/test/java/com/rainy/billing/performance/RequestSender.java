package com.rainy.billing.performance;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;

/**
 * Title: <br>
 * Description: <br>
 * Project: billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.com Inc. All rights reserved.<br>
 * 
 * @2011-11-24
 * @author rainy
 * @version 1.0
 */
public class RequestSender {

	public String get(String url) throws HttpException, IOException {

		HttpClient client = new HttpClient();
		HttpMethod method = new GetMethod(url);

		client.executeMethod(method);
		String response = method.getResponseBodyAsString();
		System.out.println("get response: " + response);
		method.releaseConnection();

		return response;
	}

	public String post(String url) throws HttpException, IOException {

		HttpClient client = new HttpClient();
		HttpMethod method = new GetMethod(url);

		client.executeMethod(method);
		String response = method.getResponseBodyAsString();
		System.out.println("get response: " + response);
		method.releaseConnection();

		return response;
	}

}
