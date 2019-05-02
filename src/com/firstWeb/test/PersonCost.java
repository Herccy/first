package com.firstWeb.test;

public class PersonCost {
    private String cno;
    private String pno;
    private String costtype;
    private int costtime;
    private double costmoney;
    private String name;



    public PersonCost(String cno, String pno, String costtype, int costtime, double costmoney, String name) {
        super();
        this.pno = pno;
        this.name = name;
        this.cno = cno;
        this.costmoney = costmoney;
        this.costtime = costtime;
        this.costtype = costtype;
    }


    public String getPno() {
        return pno;
    }
    public void setPno(String pno) {
        this.pno = pno;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCno() {
        return cno;
    }
    public void setCno(String cno) {
        this.cno = cno;
    }
    public String getCosttype() {
        return costtype;
    }
    public void setCosttype(String costtype) {
        this.costtype = costtype;
    }
    public int getCosttime() {
        return costtime;
    }
    public void setCosttime(int costtime) {
        this.costtime = costtime;
    }
    public double getCostmoney() {
        return costmoney;
    }
    public void setCostmoney(double vip) {
        this.costmoney = costmoney;
    }
    @Override
    public String toString() {
        return "Person [cno=" + cno + ", pno=" + pno + ", costtype=" + costtype + ", costtime=" + costtime + ", costmoney=" + costmoney
                + ", name=" + name + "]";
    }


}