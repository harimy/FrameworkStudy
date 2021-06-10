/*=====================
   RecordView.java
   - 인터페이스
=====================*/
// RecordView 인터페이스는 Record 라는 타입을 필요로하게끔 구성함

package com.test.spr;

public interface RecordView
{
	// setter() 메소드 선언
	public void setRecord(Record record);
	
	// 입력 액션 전용 메소드 선언
	public void input();
	
	// 출력 액션 전용 메소드 선언
	public void output();

}
