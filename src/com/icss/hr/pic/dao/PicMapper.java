package com.icss.hr.pic.dao;

import java.sql.SQLException;
import java.util.List;

import com.icss.hr.common.Pager;
import com.icss.hr.pic.pojo.Pic;

public interface PicMapper {
	/**
	 * 
	 * ��������
	 */
	void insert(Pic pic);
	/**
	 * 
	 * ɾ������
	 */
	void delete(Integer picId);
	/**
	 * 
	 *  ��ҳ��ѯ
	 */
	List<Pic> queryByPage(Pager pager);
	
	/**
	 * 
	 * �ܼ�¼��
	 * 
	 */
	int getCount();
	
	/**
	 * ͨ��id��������
	 * 
	 */
	 Pic queryById(Integer picId);
	
}
