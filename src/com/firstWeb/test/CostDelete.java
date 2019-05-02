package com.firstWeb.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class CostDelete
 */
@WebServlet("/CostDelete")
public class CostDelete extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CostDelete() {
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


        String sqlDel = "delete from cost where cno="+cno;


        int message = CostUtil.del(sqlDel);
        String rep = "";
        if(message == 1) {
            rep = "{\"code\":\"200\",\"message\":\"³É¹¦É¾³ý\"}";
        }else {
            rep = "{\"code\":\"999\",\"message\":\"É¾³ýÊ§°Ü\"}";
        }
        response.getWriter().write(rep);
    }

}
