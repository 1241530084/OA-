package com.icss.test;
/**
 * 
 * ����ͨ�ù���
 * @author Administrator
 *
 */

import org.junit.Test;

import com.icss.hr.common.MailUtil;

public class TestCommon {
	
	@Test
	public void testSendMail(){
		
		MailUtil.sendMail("tom@163.com", "tom@163.com", "123456", 
				"jack@163.com", "gagagga", "heheheh");
		
	}
	
}
