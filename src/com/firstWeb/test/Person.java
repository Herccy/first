package com.firstWeb.test;

public class Person {
    private String pno;
    private String name;
    private String sex;
    private int age;
    private int phone;
    private double vip;



    public Person(String pno, String name, String sex, int age, int phone, double vip) {
        super();
        this.pno = pno;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.phone = phone;
        this.vip = vip;
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
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public double getPhone() {
        return phone;
    }
    public void setPhone(int phone) {
        this.phone = phone;
    }
    public double getVip() {
        return vip;
    }
    public void setVip(double vip) {
        this.vip = vip;
    }
    @Override
    public String toString() {
        return "Person [pno=" + pno + ", name=" + name + ", sex=" + sex + ", age=" + age + ", phone=" + phone
                + ", vip=" + vip + "]";
    }


}