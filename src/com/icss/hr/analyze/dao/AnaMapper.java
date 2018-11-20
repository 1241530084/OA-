package com.icss.hr.analyze.dao;
/**
 * 
 * 数据分析dao
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
	 * 查询部门的人数,采用DTO文件传输
	 * @throws SQLException 
	 */
	List<DeptEmpCount> queryEmpCount();
	/**
	 * 职务的平均工资，采用list和map嵌套结构存储查询结果
	 * @throws SQLException 
	 * 
	 */
	List<HashMap<String, Object>> queryAvgSal();
	/**
	 * 部门最低最高工资查询
	 * @throws SQLException 
	 * 
	 */
	List<HashMap<String, Object>> queryMinMaxSal();
	/**
	 * 查询部门综合信息
	 * 
	 */
	List<HashMap<String, Object>> queryDeptInfo();
}
