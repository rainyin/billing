package com.rainy.billing.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rainy.billing.util.VelocityUtil;

/**
 * Title: <br>
 * Description: <br>
 * Project: billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.com Inc. All rights reserved.<br>
 * 
 * @2011-11-14
 * @author rainy
 * @version 1.0
 */
@Controller
@RequestMapping("/demo/")
public class DemoController extends BaseController {

	@Autowired
	private VelocityUtil velocityUtil;

	@RequestMapping(value = "chart")
	public void chart(Map<String, Object> model) {

	}
	
	@RequestMapping(value = "chat")
	public void chat(Map<String, Object> model) {
	}
	
	public static class SessionMap {
		private String id;
		private String name;
		
		SessionMap(String id, String name) {
			this.id = id;
			this.name = name;
		}
		
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
	}

	private void writeData(String data, HttpServletResponse response) {
		response.setContentType("text/xml");
		try {
			response.getWriter().write(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "area2D")
	public void area2D(Map<String, Object> model, HttpServletResponse response) {
		String data = velocityUtil.generateChartData("Area2D.vm");

		writeData(data, response);
	}

	@RequestMapping(value = "bar2D")
	public void bar2D(Map<String, Object> model, HttpServletResponse response) {
		String data = velocityUtil.generateChartData("Bar2D.vm");

		writeData(data, response);
	}

	@RequestMapping(value = "candlestick")
	public void candlestick(Map<String, Object> model,
			HttpServletResponse response) {
		String data = velocityUtil.generateChartData("Candlestick.vm");

		writeData(data, response);
	}

	@RequestMapping(value = "col2DLineDY")
	public void col2DLineDY(Map<String, Object> model,
			HttpServletResponse response) {
		String data = velocityUtil.generateChartData("Col2DLineDY.vm");

		writeData(data, response);
	}

	@RequestMapping(value = "col3DLineDY")
	public void col3DLineDY(Map<String, Object> model,
			HttpServletResponse response) {
		String data = velocityUtil.generateChartData("Col3DLineDY.vm");

		writeData(data, response);
	}

	@RequestMapping(value = "column2D")
	public void column2D(Map<String, Object> model, HttpServletResponse response) {
		String data = velocityUtil.generateChartData("Column2D.vm");

		writeData(data, response);
	}

	@RequestMapping(value = "column3D")
	public void column3D(Map<String, Object> model, HttpServletResponse response) {
		String data = velocityUtil.generateChartData("Column3D.vm");

		writeData(data, response);
	}

	@RequestMapping(value = "doughnut2D")
	public void doughnut2D(Map<String, Object> model,
			HttpServletResponse response) {
		String data = velocityUtil.generateChartData("Doughnut2D.vm");

		writeData(data, response);
	}

	@RequestMapping(value = "funnel")
	public void funnel(Map<String, Object> model, HttpServletResponse response) {
		String data = velocityUtil.generateChartData("Funnel.vm");

		writeData(data, response);
	}

	@RequestMapping(value = "gantt")
	public void gantt(Map<String, Object> model, HttpServletResponse response) {
		String data = velocityUtil.generateChartData("Gantt.vm");

		writeData(data, response);
	}

	@RequestMapping(value = "line2D")
	public void line2D(Map<String, Object> model, HttpServletResponse response) {
		String data = velocityUtil.generateChartData("Line2D.vm");

		writeData(data, response);
	}

	@RequestMapping(value = "mSArea2D")
	public void mSArea2D(Map<String, Object> model, HttpServletResponse response) {
		String data = velocityUtil.generateChartData("MSArea2D.vm");

		writeData(data, response);
	}

	@RequestMapping(value = "mSBar2D")
	public void mSBar2D(Map<String, Object> model, HttpServletResponse response) {
		String data = velocityUtil.generateChartData("MSBar2D.vm");

		writeData(data, response);
	}

	@RequestMapping(value = "mSColumn2D")
	public void mSColumn2D(Map<String, Object> model,
			HttpServletResponse response) {
		String data = velocityUtil.generateChartData("MSColumn2D.vm");

		writeData(data, response);
	}

	@RequestMapping(value = "mSColumn3D")
	public void mSColumn3D(Map<String, Object> model,
			HttpServletResponse response) {
		String data = velocityUtil.generateChartData("MSColumn3D.vm");

		writeData(data, response);
	}

	@RequestMapping(value = "mSLine")
	public void mSLine(Map<String, Object> model, HttpServletResponse response) {
		String data = velocityUtil.generateChartData("MSLine.vm");

		writeData(data, response);
	}

	@RequestMapping(value = "pie2D")
	public void pie2D(Map<String, Object> model, HttpServletResponse response) {
		String data = velocityUtil.generateChartData("Pie2D.vm");

		writeData(data, response);
	}

	@RequestMapping(value = "pie3D")
	public void pie3D(Map<String, Object> model, HttpServletResponse response) {
		String data = velocityUtil.generateChartData("Pie3D.vm");

		writeData(data, response);
	}

	@RequestMapping(value = "stArea2D")
	public void stArea2D(Map<String, Object> model, HttpServletResponse response) {
		String data = velocityUtil.generateChartData("StArea2D.vm");

		writeData(data, response);
	}

	@RequestMapping(value = "stBar2D")
	public void stBar2D(Map<String, Object> model, HttpServletResponse response) {
		String data = velocityUtil.generateChartData("StBar2D.vm");

		writeData(data, response);
	}

	@RequestMapping(value = "stCol2D")
	public void stCol2D(Map<String, Object> model, HttpServletResponse response) {
		String data = velocityUtil.generateChartData("StCol2D.vm");

		writeData(data, response);
	}

	@RequestMapping(value = "stCol3D")
	public void stCol3D(Map<String, Object> model, HttpServletResponse response) {
		String data = velocityUtil.generateChartData("StCol3D.vm");

		writeData(data, response);
	}

}
