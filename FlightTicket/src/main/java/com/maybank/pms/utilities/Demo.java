package com.maybank.pms.utilities;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Demo {
	@Before(value ="execution(* com.maybank.pms.service.ProductServiceImpl.*(..))")
	public void sayHi() {
		System.out.println("HI YOU ARE IN BEFORE METHOD!");
	}
	@After(value ="execution(* com.maybank.pms.service.ProductServiceImpl.*(..))")
	public void sayBye() {
		System.out.println("AFTER SAYS BYE BYE TO YOU!");
	}
	@Before(value ="execution(* com.maybank.pms.service.ProductServiceImpl.addProduct(..))")
	public void sayHiForAdding() {
		System.out.println("ADDING IT UP IN BEFORE!");
	}
}
