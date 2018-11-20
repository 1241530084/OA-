package com.icss.hr.dataapi.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;



/**
 * ������ѯ
 */
@WebServlet("/WeatherServlet")
public class WeatherServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���ñ���
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//��Ӧ�����
		PrintWriter out = response.getWriter();
		
		//�������
		String cityName = request.getParameter("cityName");
		
		//����Ĭ�ϵ�httpClientʵ��
		CloseableHttpClient httpClient = HttpClients.createDefault();
		//����httppost��������ƽ̨���ڱ��뷢��https����
		String url = "https://api.avatardata.cn/Weather/Query";
		HttpPost httpPost = new HttpPost(url);
		
		//������������
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("key", "ad065f5284ff4647b48093feeb51cff3"));
		params.add(new BasicNameValuePair("cityName", cityName));
		
		
		try {
			//������������
			UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(params,"utf-8");
			httpPost.setEntity(uefEntity);
			
			//��ӡ�����ַ
			System.out.println("�����ַ" + httpPost.getURI());
			
			//����post����
			CloseableHttpResponse resp = httpClient.execute(httpPost);
			
			//��ӡ��Ӧ״̬
			System.out.println("״̬��" + resp.getStatusLine().getStatusCode());
			
			//��Ӧʵ��
			HttpEntity entity = resp.getEntity();
			
			if(entity != null){
				out.write(EntityUtils.toString(entity,"utf-8"));
			}
			
			//�رգ��ͷ�����
			resp.close();
			httpClient.close();

		} catch (Exception e) {
			
			e.printStackTrace();
		}
		

		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
