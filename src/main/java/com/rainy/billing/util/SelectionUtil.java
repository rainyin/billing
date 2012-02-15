package com.rainy.billing.util;

import java.util.ArrayList;
import java.util.List;

import com.rainy.billing.model.Selectable;

/**
 * Title: <br>
 * Description: <br>
 * Project:  billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.com Inc. All rights reserved.<br>
 *
 * @2011-11-1
 * @author rainy
 * @version 1.0
 */
public class SelectionUtil {
	
	/**
	 * 应用多选框，并且需要左右操作。
	 * @param all 所有需要生成 option 的元素
	 * @param selected 已经被关联的元素
	 * @return
	 */
	public static String createMultiselectOptions(List<? extends Selectable> all, List<? extends Selectable> selected) {
		if(all == null || all.size() == 0) {
			return "";
		}
		StringBuilder str = new StringBuilder();
		
		str.append("<select>");
		if(selected != null && selected.size() > 0) {
			List<Selectable> temp = new ArrayList<Selectable>();
			for(Selectable option : all){
				for(Selectable selOption : selected){
					if(option.getOptionValue().equals(selOption.getOptionValue())){
						temp.add(option);
						
						str.append("<option selected='selected' value='" + option.getOptionValue() + "' >");
						str.append(option.getOptionName() + "</option>");
					}
				}
			}
			all.removeAll(temp);
		}
		for(Selectable option : all){
			str.append("<option value='" + option.getOptionValue() + "' >");
			str.append(option.getOptionName() + "</option>");
		}
		str.append("</select>");
		
		return str.toString();
	}
	
	/**
	 * 只应于下拉框
	 * @param all 所有需要生成 option 的元素
	 * @return
	 */
	public static String createSelectOptions(List<? extends Selectable> all) {
		if(all == null || all.size() == 0) {
			return "";
		}
		
		StringBuilder str = new StringBuilder();
		str.append("<select>");
		str.append("<option value=''>请选择</option>");
		for(Selectable option : all){
			str.append("<option value='" + option.getOptionValue() + "' >");
			str.append(option.getOptionName() + "</option>");
		}
		str.append("</select>");

		return str.toString();
	}

}
