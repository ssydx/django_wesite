package spring.aoppointcut;

public class Operation1 {
    public void method1() {
        System.out.println("void Operation1 method1()");
    }
    public int method2() {
        System.out.println("int Operation1 method2()");
        return 1;
    }
    public void method3(String str) {
        System.out.println("void Operation1 method3(int n)");
    }
    public int method4(int n) {
        System.out.println("int Operation1 method4(int n)");
        return n;
    }
    public void method5(int n,String str) {
        System.out.println("void Operation1 method5(int n,String str)");
    }
    public int method6(String str,int n) {
        System.out.println("int Operation1 method6(int n,String str)");
        return n;
    }
}
