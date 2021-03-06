package com.firstWeb.test;


import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CostUtil {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
//		Person person = new Person("2011","张彤","男",22,190,80);
//		String sqlInsert = "INSERT  INTO Person (Pno,Pname,Psex,Page,Pheight,Pweight) VALUES('";
//		sqlInsert += person.getPno()+"','";
//		sqlInsert += person.getName()+"','";
//		sqlInsert += person.getSex()+"',";
//		sqlInsert += person.getAge()+",";
//		sqlInsert += person.getHeight()+",";
//		sqlInsert += person.getWeight()+")";
//
//		System.out.println(add(sqlInsert));
        String sqlquery = "select * from Cost";
        String[] params = {"Cno","Pno","Costtype","Costtime","Costmoney","Pname"};
        System.out.println("订单"+"\t"+ "客户"+"\t"+ "类型"+"\t"+ "时间"+"\t"+ "价格"+"\t"+ "名字");
        List<Map<String,String>> listmap = new ArrayList<>();
        listmap = show(sqlquery, params);
        for(int i =0 ; i<listmap.size();i++) {

            for(int j=0 ; j<listmap.get(i).size();j++) {
                System.out.print(listmap.get(i).get(params[j])+"\t");
            }
            System.out.println();
        }


    }


    public static int add(String sql) {
        int message = 0;

        DBConnection db = new DBConnection();
        try {
            PreparedStatement preStmt = (PreparedStatement) db.conn.prepareStatement(sql);
            preStmt.executeUpdate();
            //Statement statement = (Statement) db.conn.createStatement();
            //statement.executeUpdate(sql);

            preStmt.close();
            db.close();//关闭连接
            message = 1;
        } catch (Exception e) {

            e.printStackTrace();
        }
        return message;//返回影响的行数，1为执行成功
    }

    //查找操作
    public static List< Map<String,String> > show(String sql, String[] params){
        // String sql ="select * from employee";

        List< Map<String,String> > listmap = new ArrayList<>();

        DBConnection db = new DBConnection();
        ResultSet rs = null;

        try {
            Statement stmt = (Statement) db.conn.createStatement();
            rs = (ResultSet) stmt.executeQuery(sql);
            while(rs.next()){

                Map<String,String> map = new HashMap<>();
                for(int i = 0; i < params.length; i++) {

                    map.put(params[i], rs.getString(params[i]));
                }
                listmap.add(map);
            }
            rs.close();
            db.close();//关闭连接
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listmap;


    }

    public static int del(String sql) {
        int i=0;
        //  String sql="delete from employee where name=?";
        DBConnection db = new DBConnection();
        try {
            PreparedStatement preStmt = (PreparedStatement) db.conn.prepareStatement(sql);

            preStmt.executeUpdate();

            preStmt.close();
            db.close();//关闭连接

            i = 1;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return i;//返回影响的行数，1为执行成功
    }

    public static int update( String sql ) {
        int i =0;
        // String sql="update employee set email=?,pwd=? where name=?";
        DBConnection db = new DBConnection();

        try {
            PreparedStatement preStmt = (PreparedStatement) db.conn.prepareStatement(sql);
//            preStmt.setString(1, uemail);
//            preStmt.setString(2, upwd);
//            preStmt.setString(3, uname);
            preStmt.executeUpdate();

            preStmt.close();
            db.close();//关闭连接
            i = 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;//返回影响的行数，1为执行成功
    }

}
