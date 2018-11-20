package com.icss.hr.emp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.icss.hr.common.Pager;
import com.icss.hr.emp.pojo.Emp;

/**
 * 
 * 	员工dao
 * @author Administrator
 *
 */
public interface EmpMapper {
	
	void insert(Emp emp);
	
	void delete(Integer empId);
	
	List<Emp> queryByPage(Pager page);
	
	void update(Emp emp);
	
	Emp queryById(Integer empId);
	
	int getCount();
	/**
	 * 根据登录名emp_login_name查询返回对应的员工数据（密码）
	 * @param empLoginName
	 * @return
	 */
	Emp queryByName(String empLoginName);
	/**
	 * 
	 * 通过登录名修改密码
	 * @param empLoginName
	 * @param empPwd
	 */
	void updateEmpPwd(@Param("empLoginName")String empLoginName,@Param("empPwd")String empPwd);

	/**
	 * 通过登录名更新头像
	 */
	void updateEmpPic(@Param("empLoginName") String empLoginName,@Param("empPic") String empPic);
	/**
	 * 通过登录名查询头像数据，如果用户名不存在，返回null
	 * @param empLoginName
	 * @return
	 */
	String queryEmpPic(String empLoginName);
	/**
	 * 
	 * 通过部门、职务、姓名检索员工
	 * 
	 */
	List<Emp> queryEmpByCondition(@Param("deptId") Integer deptId,@Param("jobId") Integer jobId,@Param("empName") String empName,@Param("pager") Pager pager);
	/**
	 * 
	 * 满足查询条件的总记录数
	 */
	int getEmpCountByCondition(@Param("deptId") Integer deptId,@Param("jobId") Integer jobId,@Param("empName") String empName);
	
	/**
	 * 获得最后一次插入行的自动编号
	 */
	int getLastInsertId();
	/**
	 * 
	 * 查询符合员工入职纪念日的员工列表
	 */
	List<Emp> queryByHiredate();
	
	/**
	 * 
	 * 根据登录名返回员工信息
	 */
	Emp queryByLoginName(@Param("empLoginName") String empLoginName);
}
