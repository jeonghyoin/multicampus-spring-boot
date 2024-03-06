package com.rubypaper.tv;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		TV tv = new SamsungTV();
//		tv.powerOn();
//		tv.powerOff();
//		tv.volumeDown();
//		tv.volumeUp();
		
		// Spring 컨테이너 생성 (xml 설정파일에 등록)
		// No bean named 'tv' available => 객체에 id가 설정되어있지 않음(xml에 id 설정)
		// GenericXmlApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext("com.rubypaper.tv");
		
		// Spring 컨테이너로부터 사용할 객체
//		TV tv = (TV) container.getBean("tv");
//		tv.powerOn();
//		tv.powerOff();
//		tv.volumeDown();
//		tv.volumeUp();
		
		// Spring 컨테이너 종료
//		container.close();
	}

}
