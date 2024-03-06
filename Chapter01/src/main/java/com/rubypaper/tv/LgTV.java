package com.rubypaper.tv;

public class LgTV implements TV {
	public LgTV() {
		// TODO Auto-generated constructor stub
		System.out.println("===> LgTv 생성");
	}
	
	public void powerOn() {
		System.out.println("===> LgTv 전원 On");
	}
	public void powerOff() {
		System.out.println("===> LgTv 전원 Off");
	}
	public void volumeUp() {
		System.out.println("===> LgTv 사운드 Up");
	}
	public void volumeDown() {
		System.out.println("===> LgTv 사운드 Down");
	}
}
