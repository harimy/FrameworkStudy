/*====================================
   Main.java
   - main() 메소드가 포함된 테스트 클래스
====================================*/

package com.test.spr;

import java.lang.reflect.Proxy;

public class Main
{
	public static void main(String[] args)
	{
		// 주 업무 실행을 할 수 있는 객체 준비
		// 인터페이스 변수 = new 인터페이스구현클래스();
		Calculator cal = new CalculatorImpl();
		// List list = new ArrayList();
		
		/*
		// 주 업무 실행에 대한 테스트(AOP 기법을 적용하기 전 코드)
		int add = cal.add(10, 20);
		System.out.println(add);
		
		int sub = cal.sub(10, 20);
		System.out.println(sub);
		
		int multi = cal.multi(10, 20);
		System.out.println(multi);
		
		int div = cal.div(10, 20);
		System.out.println(div);
		*/
		
		// 주 업무 실행에 대한 테스트(AOP 기법 적용 후)
		//Proxy.newProxyInstance(loader, interfaces, h);
		// loader : 주 업무를 실행하는 클래스에 대한 정보 전달(제공) → 정미의 설계도
		// interfaces : 주 업무를 실행하는 클래스의 인터페이스에 대한 정보 전달. → 정미의 패밀리 정보
		// h : 보조 업무 실행 클래스에 대한 정보 전달.(가영이)
		Calculator proxy = (Calculator)Proxy.newProxyInstance(
							cal.getClass().getClassLoader()
							, cal.getClass().getInterfaces()
							, new CalculatorProxy(cal));		// 정미를 넘겨서 Proxy 를 생성
		// .getClassLoader() : 클래스가 실행하는 업무를 읽어들이게끔 만들어주는 메소드
		// .getInterfaces() : 클래스는 여러 interface 를 implement 하는 형태로 되어있을 것이고 
		//-- 정미가 implement 하고 있는 interface 다 넘겨줌(패밀리의 정보)
		// new CalculatorProxy(cal) : 정미(cal)를 따라한 가영이 객체
		
		// 여기서부터 proxy 는 정미역할을 수행하게 됨.
		// 하지만 proxy 는 사실 가영이다.
		int add = proxy.add(10, 20);
		System.out.println(add);
		
		int sub = proxy.sub(10, 20);
		System.out.println(sub);
		
		int multi = proxy.multi(10, 20);
		System.out.println(multi);
		
		int div = proxy.div(10, 20);
		System.out.println(div);
		
	}
}
