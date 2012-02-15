package com.rainy.billing.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.rainy.billing.entity.Right;
import com.rainy.billing.model.Menu;

/**
 * Title: <br>
 * Description: <br>
 * Project:  billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.com Inc. All rights reserved.<br>
 *
 * @2011-11-17
 * @author rainy
 * @version 1.0
 */
public class MenuUtil {
	
	private static final Map<String, List<Menu>> MENU_LIST = new HashMap<String, List<Menu>>();
	
	private static final String MENU_SERVICE = "业务管理";
	private static final String MENU_SMS = "短信管理";
	private static final String MENU_STATISTICS = "统计分析";
	private static final String MENU_BASEINFO = "基础信息";
	
	private static void putMenu(String rightName, Menu menu) {
		List<Menu> menus = MENU_LIST.get(rightName);
		if(menus == null) {
			menus = new ArrayList<Menu>(3);
			MENU_LIST.put(rightName, menus);
		}
		menus.add(menu);
	}
	
	static {
		putMenu("ROLES_CUSTOMER", new Menu(MENU_SERVICE, 1, "客户管理", "/customer/index.do"));
		putMenu("ROLES_PROJECT", new Menu(MENU_SERVICE, 2, "项目管理", "/project/index.do"));
		putMenu("ROLES_CHANNEL_PROVIDER", new Menu(MENU_SERVICE, 3, "通道商管理", "/channelProvider/index.do"));
		putMenu("ROLES_SMS_CHANNEL", new Menu(MENU_SERVICE, 4, "短信通道管理", "/smsChannel/index.do"));
		putMenu("ROLES_IVR_CHANNEL", new Menu(MENU_SERVICE, 5, "IVR通道管理", "/ivrChannel/index.do"));
		putMenu("ROLES_GP_CHANNEL", new Menu(MENU_SERVICE, 6, "G+通道管理", "/gpChannel/index.do"));
		
		putMenu("ROLES_QUESTION", new Menu(MENU_SMS, 15, "智能答题管理", "/question/index.do"));
		putMenu("ROLES_BLACKLIST", new Menu(MENU_SMS, 16, "黑名单管理", "/blacklist/index.do"));
		putMenu("ROLES_CAT_NUMBER", new Menu(MENU_SMS, 17, "短信猫管理", "/catNumber/index.do"));
		
		putMenu("ROLES_REPORT", new Menu(MENU_STATISTICS, 28, "通道覆盖率统计", "/report/channel.do"));
		putMenu("ROLES_REPORT", new Menu(MENU_STATISTICS, 29, "注册用户统计", "/report/terminal.do"));
		putMenu("ROLES_REPORT", new Menu(MENU_STATISTICS, 30, "归属地统计", "/report/terminalByArea.do"));
		putMenu("ROLES_REPORT", new Menu(MENU_STATISTICS, 31, "访问统计", "/report/channelRequest.do"));
		putMenu("ROLES_CHANNEL_REQUEST", new Menu(MENU_STATISTICS, 32, "访问日志", "/channelRequest/index.do"));
		putMenu("ROLES_TERMINAL", new Menu(MENU_STATISTICS, 33, "注册用户查询", "/terminal/index.do"));
		
		putMenu("ROLES_AREA", new Menu(MENU_BASEINFO, 48, "区域管理", "/area/index.do"));
		putMenu("ROLES_USER", new Menu(MENU_BASEINFO, 49, "用户管理", "/user/index.do"));
	}
	
	public static Map<String, List<Menu>> getMenuFromRight(List<Right> rights) {
		if(rights == null || rights.size() == 0) return null;
		
		List<Menu> menus = new ArrayList<Menu>();
		for(Right right : rights) {
			List<Menu> tmp = MENU_LIST.get(right.getName());
			if(tmp != null) {
				menus.addAll(tmp);
			}
		}
		Collections.sort(menus);
		
		
		Map<String, List<Menu>> map = new LinkedHashMap<String, List<Menu>>();
		for(Menu menu : menus) {
			if(map.containsKey(menu.getCategory())) {
				List<Menu> tmpMenus = map.get(menu.getCategory());
				tmpMenus.add(menu);
			} else {
				List<Menu> tmpMenus = new ArrayList<Menu>();
				tmpMenus.add(menu);
				map.put(menu.getCategory(), tmpMenus);
			}
		}
		
		return map;
	}

}
