package com.ssydx.springdemo4;

public class App {
    public static void main(String[] args) {
        proxyUser pu1 = new proxyUser();
        pu1.setName("ssydx");
        String name1 = pu1.getName();
        pu1.print();

        proxyUser pu2 = new proxyUser("ss");
        String name2 = pu2.getName();
        pu1.print();
    }
}
