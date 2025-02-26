package spring.aopxml;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;


public class TrackOperation{


	public void before(JoinPoint jp) {
		System.out.println("方法执行之前");
	}


	public void after() {
		System.out.println("方法执行之后");
	}


	public void afterReturning(JoinPoint jp, Object o) {
		System.out.println("方法正常结束之后");
	}


	public void afterThrowing(JoinPoint jp, Throwable t) {
		System.out.println("方法报错之后");
	}


	public Object around(ProceedingJoinPoint jpj) {
		return 0;
	}
	

}