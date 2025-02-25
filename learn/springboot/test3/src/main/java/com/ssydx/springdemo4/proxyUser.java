package com.ssydx.springdemo4;

public class proxyUser {
    private realUser ru;
    public proxyUser() {
        doBefore();
        ru = new realUser();
    }
    public proxyUser(String name) {
        ru = new realUser(name);
        doAfter();
    }
    public void setName(String name) {
        doBefore();
        ru.setName(name);
        doAfter();
    }
    public String getName() {
        return ru.getName();
    }
    public void print() {
        ru.print();
    }
    private void doBefore() {
        System.out.println("执行原对象方法前");
    }
    private void doAfter() {
        System.out.println("执行原对象方法后");
    }
}
