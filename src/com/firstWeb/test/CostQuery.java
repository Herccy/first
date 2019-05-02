package com.firstWeb.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class CostQuery
 */
@WebServlet("/CostQuery")
public class CostQuery extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CostQuery() {
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
        String[] params = {"Cno","Pno","Costtype","Costtime","Costmoney","Pname"};
        String sql = "select * from Cost where cno ="+cno;
        String data = "{";

        String[] str = {"订单","客户","类型","时间","价格","名字"};
        List<Map<String,String>> listmap = new ArrayList<>();
        listmap = CostUtil.show(sql, params);
        for(int i =0 ; i<listmap.size();i++) {
            for(int j=0 ; j<listmap.get(i).size();j++) {
                data += "\""+str[j]+"\":"+"\""+listmap.get(i).get(params[j])+"\",";
            }
        }
        data = data.substring(0, data.length()-1);
        data += "}";


        System.out.println(data);
        response.getWriter().write(data);
    }



}
