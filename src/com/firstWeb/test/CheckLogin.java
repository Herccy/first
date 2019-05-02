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
        result = checkShopper(id, password); //����
        if (result==0) {
            pw.print("�û������ڣ�");
        }
        else if (result==-1) {
            pw.print("�������");
        }
        else {
            pw.print("��¼�ɹ���");
        }
    }

    public int checkShopper(String  id,String password) {
        // TODO Auto-generated method stub
        int result = 0;
        PreparedStatement ps=null;
        Shopper shopper=null;
        String sql="select * from shopper where id=?"; //�������Ϊstudent
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
                db.close();//�ر�����
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
