/*==============================
   CalculatorAspect.java
   - 보조 업무 수행 클래스.
   - 보조 업무 적용, 주 업무 호출
==============================*/

package com.test.spr;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StopWatch;

// ※ Spring AOP Proxy 클래스를 만들기 위해서
//   MethodIntercepter 인터페이스를 구현하는 클래스로 설계한다.
//   MethodIntercepter 는 스프링에서 제공하는 것.
//   → 클라이언트가 정미에게 뛰어가는 것을 중간에서 가영이가 가로챔.

public class CalculatorAspect implements MethodInterceptor
{
	// 보조 업무 적용 및 주 업무 호출 과정 추가
	@Override
	public Object invoke(MethodInvocation method) throws Throwable
	{
		// 보조 업무(cross-cutting concern) 설정
		//-- 시간 측정(Around Advice)
		Log log = LogFactory.getLog(this.getClass());
		StopWatch sw = new StopWatch();
		sw.start();
		log.info("처리 시간 측정 시작----------------");
		
		// 주 업무(core concern) 호출 부분
		Object result = method.proceed();
		
		sw.stop();
		log.info("처리 시간 측정 완료----------------");
		log.info(String.format("경과 시간 : %s/1000초", sw.getTotalTimeMillis()));
		
		return result;
	}
	
}
