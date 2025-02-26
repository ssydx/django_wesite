package spring.aopadvice;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
@Aspect
public class TrackOperation{

	@Pointcut("execution(* Operation.before*(..))")
	public void point1(){}
	@Before("point1()")
	public void before() {
		System.out.println("方法执行之前");
	}

	@Pointcut("execution(* Operation.after*(..))")
	public void point2(){}
	@After("point2()")
	public void after() {
		System.out.println("方法执行之后");
	}

	@Pointcut("execution(* Operation.after*(..))")
	public void point3(){}
	@AfterReturning("point3()")
	public void afterReturning() {
		System.out.println("方法正常结束之后");
	}

	@Pointcut("execution(* Operation.after*(..))")
	public void point4(){}
	@AfterThrowing("point4()")
	public void afterThrowing() {
		System.out.println("方法报错之后");
	}

	@Pointcut("execution(* Operation.around*(..))")
	public void point5(){}
	@Around("point5()")
	public Object around() {
		return 0;
	}
	

}