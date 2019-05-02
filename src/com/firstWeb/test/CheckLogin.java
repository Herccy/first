package com.firstWeb.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.io.PrintWriter;

@WebServlet("/CheckLogin")
public class CheckLogin extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response)  {
        this.doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)  {
        PrintWriter pw = null;
        int result=0;
        try {
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=utf-8");
            pw=response.getWriter();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String id="", password="";
        id = request.getParameter("u");
        password = request.getParameter("p");
        result = checkShopper(id, password); //单例
        if (result==0) {
            pw.print("用户不存在！");
        }
        else if (result==-1) {
            pw.print("密码错误！");
        }
        else {
            pw.print("登录成功！");
        }
    }

    public int checkShopper(String  id,String password) {
        // TODO Auto-generated method stub
        int result = 0;
        PreparedStatement ps=null;
        Shopper shopper=null;
        String sql="select * from shopper where id=?"; //表格名称为student
        DBConnection db = new DBConnection();
        ResultSet rst = null;
            try {
                Statement stmt = (Statement) db.conn.createStatement();
                rst = (ResultSet) stmt.executeQuery(sql);
                if (rst.next()) {
                    shopper = new Shopper();
                    shopper.setId(rst.getString(1));
                    shopper.setPassword(rst.getString(2));
                }
                rst.close();
                db.close();//关闭连接
                if (shopper == null) {
                    return 0;
                } else if (!shopper.getPassword().equals(password)) {
                    return -1;
                } else {
                    return 1;
                }
            }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }
}
