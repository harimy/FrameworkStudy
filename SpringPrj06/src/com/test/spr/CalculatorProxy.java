/*===================================
   CalculatorProxy.java
   - 프록시 클래스.
   - 보조 업무 적용 및 주 업무 호출 과정.
===================================*/
// proxy server
// 서버와 클라이언트 사이에 중계기로서 대리로 통신을 수행
// **간접적 접속**을 할 수 있게 해주는 컴퓨터 시스템, 응용프로그램을 의미

package com.test.spr;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.logging.Logger;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StopWatch;

// ※ Proxy 클래스를 만드는 방법 중 비교적 쉽고 직관적인 방법은
//   InvocationHandler 인터페이스를 구현하는 클래스를 만드는 것이다.
//   InvocationHandler 는 자바에서 제공하는 것.

public class CalculatorProxy implements InvocationHandler
{
	private Object target;
	
	// 생성자 정의
	public CalculatorProxy(Object target)
	{
		this.target = target;
	}

	// 보조 업무 적용 및 주 업무 호출 과정 추가
	// invoke : 프록시 설계 메소드
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
	{
		// 보조 업무(cross-cutting concern) 설정
		//-- 시간 측정(Around Advice)
		Log log = LogFactory.getLog(this.getClass());
		StopWatch sw = new StopWatch();
		sw.start();
		log.info("처리 시간 측정 시작-----------------");
		
		// 주 업무(core concern) 실행 내용
		Object result = method.invoke(target, args);
		// target = 따라해야하는 대상.
		// args = 대상이 가지고 있는 주변 속성들
		
		sw.stop();
		log.info("처리 시간 측정 종료-----------------");
		log.info(String.format("경과 시간 : %s / 1000", sw.getTotalTimeMillis()));
		
		return result;
	}
	
}
