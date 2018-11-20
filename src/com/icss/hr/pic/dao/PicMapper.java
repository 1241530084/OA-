package com.icss.hr.pic.dao;

import java.sql.SQLException;
import java.util.List;

import com.icss.hr.common.Pager;
import com.icss.hr.pic.pojo.Pic;

public interface PicMapper {
	/**
	 * 
	 * 插入数据
	 */
	void insert(Pic pic);
	/**
	 * 
	 * 删除数据
	 */
	void delete(Integer picId);
	/**
	 * 
	 *  分页查询
	 */
	List<Pic> queryByPage(Pager pager);
	
	/**
	 * 
	 * 总记录数
	 * 
	 */
	int getCount();
	
	/**
	 * 通过id返回数据
	 * 
	 */
	 Pic queryById(Integer picId);
	
}
