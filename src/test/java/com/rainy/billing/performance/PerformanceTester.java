package com.rainy.billing.performance;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.rainy.billing.dao.AreaDao;
import com.rainy.billing.dao.ProjectDao;
import com.rainy.billing.entity.Area;
import com.rainy.billing.entity.Project;
import com.rainy.billing.service.AbstractServiceTest;

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
public class PerformanceTester extends AbstractServiceTest {
	
	private String url = "http://localhost:8080/server/getprovider.aspx?imsi=9460004060359417&projectid=1010&plmn=46000&sc=0755&uid=2012001&ver=003";
	private int count = 100;
	private List<Area> areas;
	private List<Project> projects;
	private List<String> uids;
	private Random rand;
	
	@Autowired
	private AreaDao areaDao;
	
	@Autowired
	private ProjectDao projectDao;
	
	public void init() {
		areas = areaDao.queryEntity(new HashMap<String, Object>());
		projects = projectDao.queryEntity(new HashMap<String, Object>());
		uids = Arrays.asList(new String[]{"00000000", ""});
		rand = new Random();
	}

	
	private  String getUrl() {
		Area area = areas.get(rand.nextInt(areas.size()));
		Project project = projects.get(rand.nextInt(projects.size()));
		String uid = uids.get(rand.nextInt(uids.size()));
		
		String url_ = new String(url);
		url_ = url_.replace("1010", project.getId().toString());
		url_ = url_.replace("0755", area.getCmCode());
		url_ = url_.replace("2012001", uid);
		url_ = url_.replace("9460004060359417", new Random().nextLong() + "" );
		
		System.out.println("full url: " + url_);
		return url_;
	}
	
	private void printResult(Map<Integer, Float> cost) {
		int length = cost.values().size();
		if(length == 0) return;
		Double average = 0d;
		for(Float co : cost.values()) {
			average += (co*1000/1000/length);
		}
		System.out.println("average cost: " + average);
		
		Object[] times = cost.values().toArray();
		Arrays.sort(times);
		
		System.out.println("min cost: " + times[0]);
		System.out.println("max cost: " + times[times.length - 1]);
	}
	
	public void testChannelRequest() throws InterruptedException {
		Map<Integer, Float> cost = new HashMap<Integer, Float>(count);
		CountDownLatch startLatch = new CountDownLatch(1);
		CountDownLatch doneLatch = new CountDownLatch(count);
		for(int i = 0 ; i < count; i++) {
			new Thread(new RequestTask(i, cost, "get", getUrl() + i , startLatch, doneLatch)).start();
		}
		
		System.out.println("begin to run:");
		startLatch.countDown();
		doneLatch.await();
		
		printResult(cost);
	}
	
	@Test
	public void testBegin() {
		init();
		long start = System.currentTimeMillis();
		for(int i = 0 ; i < 10 ; i++) {
			try {
				testChannelRequest();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(" total time: " + (System.currentTimeMillis() - start) / 1000.00F);
	}

}
