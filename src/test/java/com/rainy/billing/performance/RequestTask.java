package com.rainy.billing.performance;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * Title: <br>
 * Description: <br>
 * Project:  billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.com Inc. All rights reserved.<br>
 *
 * @2011-11-24
 * @author rainy
 * @version 1.0
 */
public class RequestTask implements Runnable {
	
	private String requestMehtod;
	private String url;
	private Integer id;
	private Map<Integer, Float> cost;
	private CountDownLatch startLatch;
	private CountDownLatch doneLatch;
	private Random ran = new Random();

	public RequestTask(Integer id, Map<Integer, Float> cost, String requestMehtod, String url, CountDownLatch startLatch, CountDownLatch doneLatch) {
		this.requestMehtod = requestMehtod;
		this.url = url;
		this.id = id;
		this.cost = cost;
		this.startLatch = startLatch;
		this.doneLatch = doneLatch;
	}
 	
	@Override
	public void run() {
		try {
			startLatch.await();
			Thread.sleep(ran.nextInt(10000));
			long start = System.currentTimeMillis();
			if(requestMehtod.equalsIgnoreCase("get")) {
				new RequestSender().get(url);
			} else {
				new RequestSender().post(url);
			}
			cost.put(id, Float.valueOf((System.currentTimeMillis() - start)/1000.000F));
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			doneLatch.countDown();
		}
	}

}
