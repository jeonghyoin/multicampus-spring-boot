package com.rubypaper.tv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SamsungTV implements TV {
	// 3. Type Injection
	// Speaker 타입의 객체가 반드시 메모리에 존재해야하며 유일해야함
	@Autowired
	private Speaker speaker;

	public SamsungTV() {
		System.out.println("===> SamsungTV(1) 생성");
	}
	
//	 1. 생성자 injection
//	public SamsungTV(Speaker speaker) {
//		// super();
//		System.out.println("===> SamsungTV(2) 생성");
//		this.speaker = speaker;
//	}
//
//	public void setSpeaker(Speaker speaker) {
//		this.speaker = speaker;
//	}

	public void powerOn() {
		System.out.println("SamsungTV---전원 켠다.");
	}
	public void powerOff() {
		System.out.println("SamsungTV---전원 끈다.");
	}
	public void volumeUp() {
		speaker.volumeUp();
//		System.out.println("SamsungTV---소리 올린다.");
	}
	public void volumeDown() {
		speaker.volumeDown();
//		System.out.println("SamsungTV---소리 내린다.");
	}
}
