package spring.aopadviceparameter;
import java.util.Arrays;

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

	// @Pointcut("execution(* Operation.before*(..))")
	// public void point1(){}
	// @Before("point1()")
	// public void before(JoinPoint jp) {
	// 	System.out.println("方法执行之前");
	// 	System.out.println(jp);
	// 	System.out.println(jp.getTarget());
	// 	System.out.println(jp.getThis());
	// 	System.out.println(jp.getKind());
	// 	System.out.println(jp.getClass());
	// 	System.out.println(jp.getSourceLocation());
	// 	// 获取方法
	// 	System.out.println(jp.getSignature());
	// 	// 获取方法参数
	// 	System.out.println(Arrays.toString(jp.getArgs()));
	// 	System.out.println(jp.getStaticPart());
	// 	System.out.println(jp.toLongString());
	// 	System.out.println(jp.toShortString());
	// }

	// @Pointcut("execution(* Operation.after*(..))")
	// public void point2(){}
	// @After("point2()")
	// public void after() {
	// 	System.out.println("方法执行之后");
	// }

	// @AfterReturning(pointcut = "execution(* Operation.after*(..))", returning = "o")
	// public void afterReturning(JoinPoint jp, Object o) {
	// 	System.out.println("方法正常结束之后");
	// 	System.out.println(o);
	// }

	// @Pointcut("execution(* Operation.after*(..))")
	// public void point4(){}
	// @AfterThrowing(pointcut = "point4()", throwing = "t")
	// public void afterThrowing(JoinPoint jp, Throwable t) {
	// 	System.out.println("方法报错之后");
	// 	System.out.println(t.getMessage());
	// }

	@Pointcut("execution(* Operation.around*(..))")
	public void point5(){}
	@Around("point5()")
	public Object around(ProceedingJoinPoint pjp) throws Exception {
		System.out.println("之前");
		try {
			Object res = pjp.proceed();
			System.out.println("之后");
			return res;
		} catch (Throwable e) {
			throw new Exception("捕获");
		}
	}
	

}