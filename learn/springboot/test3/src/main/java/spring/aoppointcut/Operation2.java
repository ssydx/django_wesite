package spring.aoppointcut;

public class Operation2 {
    public void method1() {
        System.out.println("void Operation2 method1()");
    }
    public int method2() {
        System.out.println("int Operation2 method2()");
        return 1;
    }
    public void method3(String str) {
        System.out.println("void Operation2 method3(int n)");
    }
    public int method4(int n) {
        System.out.println("int Operation2 method4(int n)");
        return n;
    }
    public void method5(int n,String str) {
        System.out.println("void Operation2 method5(int n,String str)");
    }
    public int method6(String str,int n) {
        System.out.println("int Operation2 method6(int n,String str)");
        return n;
    }
}
