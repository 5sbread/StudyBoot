package com.iu.home.aop.test;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.iu.home.board.qna.QnaVO;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class QnaAdvice {
	
	@Before("execution(* com.iu.home.board.qna.QnaService.get*(..))")
	public void beforeTest(JoinPoint joinPoint) {
		log.info("---- before ----");
		log.info("Args : {}", joinPoint.getArgs());
		log.info("Kind : {}", joinPoint.getKind());
	}
	
	@After("execution(* com.iu.home.board.qna.QnaService.get*(..))")
	public void AfterTest(JoinPoint joinPoint) {
		log.info("---- after ----");
		log.info("Args : {}", joinPoint.getArgs());
		log.info("Kind : {}", joinPoint.getKind());
	}
	
//=========================================================================================	

		//qna Service - set*
					// * : 접근지정자						  .. : 매개변수 0개 이상
	@Around("execution(* com.iu.home.board.qna.QnaService.set*(..))")
	public Object aroundTest (ProceedingJoinPoint joinPoint) throws Throwable{
		log.info("---- before ----");
		//point-cut의 클래스 객체
		log.info("Target : {}", joinPoint.getTarget());
		//point-cut의 클래스 객체
		log.info("This : {}", joinPoint.getThis());
		//point-cut로 전달되는 매개변수의 인자값
		log.info("Args : {}", joinPoint.getArgs());
		Object [] objects =joinPoint.getArgs();
					//다형성
		QnaVO qnaVO = (QnaVO) objects[0];
		
								//호출
		Object object = joinPoint.proceed();
		log.info("---- after ----");
		log.info("Obj {}", object);
		return object;
	}
	
}
