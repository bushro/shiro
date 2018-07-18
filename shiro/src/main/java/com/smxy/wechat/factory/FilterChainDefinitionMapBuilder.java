package com.smxy.wechat.factory;

import java.util.LinkedHashMap;

/**
 * 
 * @Description :url权限配置
 * @author Bush罗
 * @date 2018年7月12日
 *
 */
public class FilterChainDefinitionMapBuilder {

	public LinkedHashMap<String, String> buildFilterChainDefinitionMap(){
		LinkedHashMap<String, String> map = new LinkedHashMap<>();
		
		map.put("/login.jsp", "anon");
		map.put("/shiro/test", "anon");
		map.put("/shiro/login", "anon");
		map.put("/shiro/logout", "logout");
		map.put("/user.jsp", "authc,roles[commonadmin]");
		map.put("/admin.jsp", "authc,roles[superadmin]");
		map.put("/list.jsp", "user");		
		map.put("/**", "authc");		
		return map;
	}
	
}
