package cn.com.liu.spring03.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * ����ʹ�� @Order ע��ָ����������ȼ�, ֵԽС���ȼ�Խ��
 */
@Order(2)
@Aspect
@Component
public class LoggingAspect {
	
	/**
	 * ����һ������, ���������������ʽ. һ���, �÷������ٲ���Ҫ���������Ĵ���. 
	 * ʹ�� @Pointcut �������������ʽ. 
	 * ���������ֱ֪ͨ��ʹ�÷����������õ�ǰ���������ʽ. 
	 */
	@Pointcut("execution(public int com.atguigu.spring.aop.ArithmeticCalculator.*(..))")
	public void declareJointPointExpression(){}
	
	/**
	 * �� com.atguigu.spring.aop.ArithmeticCalculator �ӿڵ�ÿһ��ʵ�����ÿһ��������ʼ֮ǰִ��һ�δ���
	 */
	@Before("declareJointPointExpression()")
	public void beforeMethod(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		Object [] args = joinPoint.getArgs();
		
		System.out.println("The method " + methodName + " begins with " + Arrays.asList(args));
	}
	
	/**
	 * �ڷ���ִ��֮��ִ�еĴ���. ���۸÷����Ƿ�����쳣
	 */
	@After("declareJointPointExpression()")
	public void afterMethod(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " ends");
	}
	
	/**
	 * �ڷ���������������ִ�еĴ���
	 * ����֪ͨ�ǿ��Է��ʵ������ķ���ֵ��!
	 */
	@AfterReturning(value="declareJointPointExpression()",
			returning="result")
	public void afterReturning(JoinPoint joinPoint, Object result){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " ends with " + result);
	}
	
	/**
	 * ��Ŀ�귽�������쳣ʱ��ִ�еĴ���.
	 * ���Է��ʵ��쳣����; �ҿ���ָ���ڳ����ض��쳣ʱ��ִ��֪ͨ����
	 */
	@AfterThrowing(value="declareJointPointExpression()",
			throwing="e")
	public void afterThrowing(JoinPoint joinPoint, Exception e){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " occurs excetion:" + e);
	}
	
	/**
	 * ����֪ͨ��ҪЯ�� ProceedingJoinPoint ���͵Ĳ���. 
	 * ����֪ͨ�����ڶ�̬�����ȫ����: ProceedingJoinPoint ���͵Ĳ������Ծ����Ƿ�ִ��Ŀ�귽��.
	 * �һ���֪ͨ�����з���ֵ, ����ֵ��ΪĿ�귽���ķ���ֵ
	 */
	/*
	@Around("execution(public int com.atguigu.spring.aop.ArithmeticCalculator.*(..))")
	public Object aroundMethod(ProceedingJoinPoint pjd){
		
		Object result = null;
		String methodName = pjd.getSignature().getName();
		
		try {
			//ǰ��֪ͨ
			System.out.println("The method " + methodName + " begins with " + Arrays.asList(pjd.getArgs()));
			//ִ��Ŀ�귽��
			result = pjd.proceed();
			//����֪ͨ
			System.out.println("The method " + methodName + " ends with " + result);
		} catch (Throwable e) {
			//�쳣֪ͨ
			System.out.println("The method " + methodName + " occurs exception:" + e);
			throw new RuntimeException(e);
		}
		//����֪ͨ
		System.out.println("The method " + methodName + " ends");
		
		return result;
	}
	*/
}
