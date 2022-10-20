package com.iu.home.aop.test;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@Aspect //언제 실행할지
public class Card {
						//패키지 안 get으로 시작하는 모든 메서드
	@After("execution(* com.iu.home.aop.test.Transport.get*())")
	public void cardCheck() {
		log.info("---- 💳 ----");
	}
	
	//before+after
	@Around("execution(* com.iu.home.aop.test.Transport.take*())")
	public Object cardCheck(ProceedingJoinPoint joinPoint) throws Throwable{
		log.info("---- 💳 🕶️ ----");
		Object object = joinPoint.proceed();
		log.info("---- 💳 ☠️ ----");
		return object;
	}
}
