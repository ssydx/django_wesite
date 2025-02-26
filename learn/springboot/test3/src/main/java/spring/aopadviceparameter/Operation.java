package spring.aopadviceparameter;

public class Operation {
    public int before1(){
        System.out.println("before1执行");
        return 1;
    }    
    public void after1(){
        System.out.println("after1执行");
    }    
    public void after2() throws Exception {
        System.out.println("after2执行");
        throw new Exception("人为错误");
    }
    public int around1(){
        System.out.println("around1执行");
        return 3;
    }
}
