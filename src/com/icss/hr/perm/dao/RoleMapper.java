package com.icss.hr.perm.dao;

import java.util.List;
import java.util.Map;

import com.icss.hr.perm.pojo.Role;

public interface RoleMapper {
    /**
     * 
     * ���ݵ�¼����ѯ���ض�Ӧ�Ľ�ɫ����
     */
	List<Map<String, Object>> queryRole(String empLoginName);
}