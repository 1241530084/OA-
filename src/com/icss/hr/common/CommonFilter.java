package com.icss.hr.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * ����������
 */
public class CommonFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		// ͳһ����������Ӧ����
		request.setCharacterEncoding("utf-8");

		response.setContentType("text/html;charset=utf-8");
		// ���������������������
		response.setHeader("Access-Control-Allow-Origin", "*");

		/**
		 * 
		 * ��¼����
		 */
		// ����uri
		String uri = request.getRequestURI();
		System.out.println("�����uri" + uri);

		// webӦ������
		String App = request.getContextPath();
		// �ж��Ƿ��ǲ���Ҫ��¼��֤��uri
		if (!uri.equals(App + "/") && !uri.equals(App + "/Login.html") && !uri.equals(App + "/logout.jsp")
				&& !uri.equals(App + "/emp/login") && !uri.startsWith(App + "/css") && !uri.startsWith(App + "/js")
				&& !uri.startsWith(App + "/images")) {
			// ��¼�ж�
			HttpSession session = request.getSession();

			String empLoginName = (String) session.getAttribute("empLoginName");

			if (empLoginName == null) {

				// �ж��Ƿ���ajax����
				String xhr = request.getHeader("x-requested-with");

				if (xhr != null && xhr.equals("XMLHttpRequest")) {
					// ��Ӧǰ��һ���Զ��屨ͷ
					response.setHeader("sessionStatus", "timeout");

					return;
				}

			}

		}

		// ��������ִ��
		chain.doFilter(arg0, arg1);
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
