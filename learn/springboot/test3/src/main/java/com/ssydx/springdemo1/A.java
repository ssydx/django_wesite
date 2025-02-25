package com.ssydx.springdemo1;

public class A {
    B b;
    A() {
        System.out.println("a is created");
    }
    A(B b) {
        this.b = b;
        System.out.println("a is created with B");
    }
    public void setB(B b) {
        this.b = b;
    }
    void print() {
        System.out.println("hello a");
    }
    void display() {
        print();
        if (b != null) {
            b.print();
        }
    }
    public static A getA() {
        System.out.println("静态方法获得自身实例：");
        return new A();
    }
    public static B getB() {
        System.out.println("静态方法获得其他实例：");
        return new B();
    }
    public B getBinst() {
        System.out.println("实例方法获得其他实例：");
        return new B();
    }
    public static A getAwithPara(B b) {
        System.out.println("静态方法获得带参数的自身实例：");
        return new A(b);
    }
    public static B getBwithPara(int n) {
        System.out.println("静态方法获得带参数的其他实例：");
        return new B(n);
    }
    public B getBinstwithPara(int n) {
        System.out.println("实例方法获得带参数的其他实例：");
        return new B(n);
    }
}
