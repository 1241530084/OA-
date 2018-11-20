package com.icss.test;
/**
 * 
 * 测试通用功能
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
