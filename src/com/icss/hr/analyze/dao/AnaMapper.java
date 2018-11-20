package com.icss.hr.analyze.dao;
/**
 * 
 * ���ݷ���dao
 * @author Administrator
 *
 */

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.icss.hr.analyze.dto.DeptEmpCount;

public interface AnaMapper {
	/**
	 * ��ѯ���ŵ�����,����DTO�ļ�����
	 * @throws SQLException 
	 */
	List<DeptEmpCount> queryEmpCount();
	/**
	 * ְ���ƽ�����ʣ�����list��mapǶ�׽ṹ�洢��ѯ���
	 * @throws SQLException 
	 * 
	 */
	List<HashMap<String, Object>> queryAvgSal();
	/**
	 * ���������߹��ʲ�ѯ
	 * @throws SQLException 
	 * 
	 */
	List<HashMap<String, Object>> queryMinMaxSal();
	/**
	 * ��ѯ�����ۺ���Ϣ
	 * 
	 */
	List<HashMap<String, Object>> queryDeptInfo();
}
