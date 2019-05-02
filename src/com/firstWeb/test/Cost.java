package com.firstWeb.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Cost
 */
@WebServlet("/Cost")
public class Cost extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cost() {
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

        String cno = request.getParameter("cno");
        String pno = request.getParameter("pno");
        String costtype = request.getParameter("costtype");
        String costtime = request.getParameter("costtime");
        String costmoney = request.getParameter("costmoney");
        String name = request.getParameter("name");

        String sqlInsert = "INSERT  INTO Cost (Cno,Pno,Costtype,Costtime,Costmoney,Pname) VALUES('";
        sqlInsert += cno +"','";
        sqlInsert += pno +"','";
        sqlInsert += costtype +"',";
        sqlInsert += costtime +",";
        sqlInsert += costmoney +",";
        sqlInsert += name +")";

        int message = CostUtil.add(sqlInsert);
        String rep = "";
        if(message == 1) {
            rep = "{\"code\":200,\"message\":\"成功插入数据库\"}";
        }else {
            rep = "{\"code\":\"999\",\"message\":\"插入失败了\"}";
        }
        response.getWriter().write(rep);


    }

}
