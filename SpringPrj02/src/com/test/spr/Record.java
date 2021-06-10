/*===================
   Record.java
   - 인터페이스
===================*/
//선언된 변수, 정의된 메소드 없이 메소드 선언만 해둠.
//인터페이스는 인스턴스 생성 불가
//추상 클래스도 인스턴스 생성 불가, 인터페이스는 추상클래스보다 추상화 정도가 더 심한 것이기 때문

package com.test.spr;

public interface Record
{
	public void setKor(int kor);
	public int getKor();
	
	public void setEng(int eng);
	public int getEng();
	
	public void setMat(int mat);
	public int getMat();
	
	public int getTotal();
	
	public double getAvg();
}

