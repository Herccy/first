package com.firstWeb.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.firstWeb.test.MysqlUtil;

/**
 * Servlet implementation class HelloUpdate
 */
@WebServlet("/HelloUpdate")
public class HelloUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloUpdate() {
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
		
		String sqlupdate = "update Person set ";
//		sqlupdate += "Pno='"+ pno +"',";
		sqlupdate += "Pname='"+ name +"',";
		sqlupdate += "Psex='"+ sex +"',";
		sqlupdate += "Page="+ age +",";
		sqlupdate += "Pphone="+ phone +",";
		sqlupdate += "Pvip="+ vip;
		sqlupdate += " where Pno='"+pno+"'";
		System.out.println(sqlupdate);
		int message = MysqlUtil.update(sqlupdate);
		String rep = "";
		if(message == 1) {
			rep = "{\"code\":\"200\",\"message\":\"成功插入数据库\"}";
		}else {
			rep = "{\"code\":\"999\",\"message\":\"更新失败了\"}";
		}
		response.getWriter().write(rep);
		
	}

}
