package com.icss.hr.perm.dao;

import java.util.List;
import java.util.Map;



public interface PermissionMapper {
   
	/***
	 * 通过登录名返回对应的所有权限名称
	 */
	List<Map<String, Object>> queryPerm(String empLoginName);
}