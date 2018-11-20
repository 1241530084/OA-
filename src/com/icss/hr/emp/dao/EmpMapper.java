package com.icss.hr.emp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.icss.hr.common.Pager;
import com.icss.hr.emp.pojo.Emp;

/**
 * 
 * 	Ա��dao
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
	 * ���ݵ�¼��emp_login_name��ѯ���ض�Ӧ��Ա�����ݣ����룩
	 * @param empLoginName
	 * @return
	 */
	Emp queryByName(String empLoginName);
	/**
	 * 
	 * ͨ����¼���޸�����
	 * @param empLoginName
	 * @param empPwd
	 */
	void updateEmpPwd(@Param("empLoginName")String empLoginName,@Param("empPwd")String empPwd);

	/**
	 * ͨ����¼������ͷ��
	 */
	void updateEmpPic(@Param("empLoginName") String empLoginName,@Param("empPic") String empPic);
	/**
	 * ͨ����¼����ѯͷ�����ݣ�����û��������ڣ�����null
	 * @param empLoginName
	 * @return
	 */
	String queryEmpPic(String empLoginName);
	/**
	 * 
	 * ͨ�����š�ְ����������Ա��
	 * 
	 */
	List<Emp> queryEmpByCondition(@Param("deptId") Integer deptId,@Param("jobId") Integer jobId,@Param("empName") String empName,@Param("pager") Pager pager);
	/**
	 * 
	 * �����ѯ�������ܼ�¼��
	 */
	int getEmpCountByCondition(@Param("deptId") Integer deptId,@Param("jobId") Integer jobId,@Param("empName") String empName);
	
	/**
	 * ������һ�β����е��Զ����
	 */
	int getLastInsertId();
	/**
	 * 
	 * ��ѯ����Ա����ְ�����յ�Ա���б�
	 */
	List<Emp> queryByHiredate();
	
	/**
	 * 
	 * ���ݵ�¼������Ա����Ϣ
	 */
	Emp queryByLoginName(@Param("empLoginName") String empLoginName);
}
