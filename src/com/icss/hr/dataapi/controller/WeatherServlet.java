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
 * 天气查询
 */
@WebServlet("/WeatherServlet")
public class WeatherServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//响应输出流
		PrintWriter out = response.getWriter();
		
		//请求参数
		String cityName = request.getParameter("cityName");
		
		//创建默认的httpClient实例
		CloseableHttpClient httpClient = HttpClients.createDefault();
		//创建httppost，阿凡达平台现在必须发送https请求
		String url = "https://api.avatardata.cn/Weather/Query";
		HttpPost httpPost = new HttpPost(url);
		
		//创建参数队列
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("key", "ad065f5284ff4647b48093feeb51cff3"));
		params.add(new BasicNameValuePair("cityName", cityName));
		
		
		try {
			//设置请求内容
			UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(params,"utf-8");
			httpPost.setEntity(uefEntity);
			
			//打印请求地址
			System.out.println("请求地址" + httpPost.getURI());
			
			//发送post请求
			CloseableHttpResponse resp = httpClient.execute(httpPost);
			
			//打印响应状态
			System.out.println("状态码" + resp.getStatusLine().getStatusCode());
			
			//响应实体
			HttpEntity entity = resp.getEntity();
			
			if(entity != null){
				out.write(EntityUtils.toString(entity,"utf-8"));
			}
			
			//关闭，释放连接
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
