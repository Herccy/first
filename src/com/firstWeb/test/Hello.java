package com.firstWeb.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.firstWeb.test.MysqlUtil;
/**
 * Servlet implementation class Hello
 */
@WebServlet("/Hello")
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Hello() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		
		String pno = request.getParameter("pno");
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String age = request.getParameter("age");
		String phone = request.getParameter("phone");
		String vip = request.getParameter("vip");
		
		String sqlInsert = "INSERT  INTO Person (Pno,Pname,Psex,Page,Pphone,Pvip) VALUES('";
		sqlInsert += pno +"','";
		sqlInsert += name +"','";
		sqlInsert += sex +"',";
		sqlInsert += age +",";
		sqlInsert += phone +",";
		sqlInsert += vip +")";
		
		int message = MysqlUtil.add(sqlInsert);
		String rep = "";
		if(message == 1) {
			rep = "{\"code\":200,\"message\":\"�ɹ��������ݿ�\"}";
		}else {
			rep = "{\"code\":\"999\",\"message\":\"����ʧ����\"}";
		}
		response.getWriter().write(rep);
		
		
	}

}
