package com.rainy.billing.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.rainy.billing.model.report.ChannelReport;
import com.rainy.billing.model.report.ReportData;


public class VelocityUtil {

	private static final String ENCODING = "UTF-8";
	private static final String ROOT_PATH = "velocity/";
	
    private VelocityEngine velocityEngine;
    
    public void setVelocityEngine(VelocityEngine velocityEngine) {
		this.velocityEngine = velocityEngine;
	}

    public String generateChartData(String template){
    	return VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, ROOT_PATH + template, ENCODING, null);
    }
    
	public String generateChartData(String template, List<ChannelReport> param){
    	Map<String, Object> model = new HashMap<String, Object>();
    	model.put("data", param);
    	return VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, ROOT_PATH + template, ENCODING, model);
    }
	
	public String generateChartData(String template, ReportData data){
    	Map<String, Object> model = new HashMap<String, Object>();
    	model.put("data", data);
    	return VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, ROOT_PATH + template, ENCODING, model);
    }

}
