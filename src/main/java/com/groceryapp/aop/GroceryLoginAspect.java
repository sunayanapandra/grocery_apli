package com.groceryapp.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GroceryLoginAspect {
	

		
		private final Logger log = LoggerFactory.getLogger(this.getClass());
		
		@Before("execution(* com.groceryapp.service.UserService.login(..))")
		public void logBefore(JoinPoint joinPoint) {

			log.info("logBefore() started");
			log.info("Method Name:" + joinPoint.getSignature().getName());
			log.info("logBefore() completed!");
			log.info("******");
		}
	}


