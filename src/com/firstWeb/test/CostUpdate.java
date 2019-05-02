package com.firstWeb.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class CostUpdate
 */
@WebServlet("/CostUpdate")
public class CostUpdate extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CostUpdate() {
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

        String sqlupdate = "update Cost set ";
		sqlupdate += "Pno='"+ pno +"',";
        sqlupdate += "Costtype='"+ costtype +"',";
        sqlupdate += "Costtime='"+ costtime +"',";
        sqlupdate += "Costmoney='"+ costmoney +"',";
        sqlupdate += "Pname='"+ name +"',";
        sqlupdate += " where Cno='"+cno+"'";
        System.out.println(sqlupdate);
        int message = CostUtil.update(sqlupdate);
        String rep = "";
        if(message == 1) {
            rep = "{\"code\":\"200\",\"message\":\"成功插入数据库\"}";
        }else {
            rep = "{\"code\":\"999\",\"message\":\"更新失败了\"}";
        }
        response.getWriter().write(rep);

    }

}
