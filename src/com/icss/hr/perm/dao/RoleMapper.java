package com.icss.hr.perm.dao;

import java.util.List;
import java.util.Map;

import com.icss.hr.perm.pojo.Role;

public interface RoleMapper {
    /**
     * 
     * 根据登录名查询返回对应的角色名称
     */
	List<Map<String, Object>> queryRole(String empLoginName);
}