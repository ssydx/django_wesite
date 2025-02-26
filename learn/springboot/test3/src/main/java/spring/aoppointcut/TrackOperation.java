package spring.aoppointcut;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
@Aspect
public class TrackOperation{
	// @Pointcut("execution(* *.*(..))")
	// public void all1() {};
	// @Before("all1()")
	// public void allmethod1() {
	// 	System.out.println("当前包的所有方法前都执行");
	// }
	// @Pointcut("execution(* com.ssydx.springdemo6.Operation*.*(..))")
	// public void all2() {};
	// @Before("all2()")
	// public void allmethod2() {
	// 	System.out.println("当前包的所有Operation开头的方法前都执行");
	// }
	// @Pointcut("execution(* Operation1.*(..))")
	// public void all3() {};
	// @Before("all3()")
	// public void allmethod3() {
	// 	System.out.println("Operation1的所有方法前都执行");
	// }
	// @Pointcut("execution(int Operation1.*(..))")
	// public void all4() {};
	// @Before("all4()")
	// public void allmethod4() {
	// 	System.out.println("Operation1的所有返回值为int的方法前都执行");
	// }
	// @Pointcut("execution(* Operation1.*(*))")
	// public void all5() {};
	// @Before("all5()")
	// public void allmethod5() {
	// 	System.out.println("Operation1的所有单个参数的方法前都执行");
	// }
	// @Pointcut("execution(* Operation1.*(int))")
	// public void all6() {};
	// @Before("all6()")
	// public void allmethod6() {
	// 	System.out.println("Operation1的所有单个int参数的方法前都执行");
	// }
	// @Pointcut("execution(* Operation1.*(*,*))")
	// public void all7() {};
	// @Before("all7()")
	// public void allmethod7() {
	// 	System.out.println("Operation1的所有两个参数的方法前都执行");
	// }
	// @Pointcut("execution(* Operation1.*(int,*))")
	// public void all8() {};
	// @Before("all8()")
	// public void allmethod8() {
	// 	System.out.println("Operation1的所有两个参数且第一个int的方法前都执行");
	// }


	// // 符合该条件的方法定义为point1
	// // 返回值 [包名.]类名.方法名(参数列表)
	// @Pointcut("execution(* Operation.before*(..))")
	// public void point1(){}
	// // 在point1前执行该方法
	// @Before("point1()")
	// public void before(JoinPoint jp) {
	// 	System.out.println("方法执行之前");
	// }

	// @Pointcut("execution(* Operation.after*(..))")
	// public void point2(){}
	
	// @After("point2()")
	// public void after(JoinPoint jp) {
	// 	System.out.println("方法执行之前");
	// }

	// @Pointcut("execution(* Operation.around*(..))")
	// public void point3(){}
	
	// @Around("point3()")
	// public void around(JoinPoint jp) {
	// 	System.out.println("方法执行前后");
	// }
	

}