package com.rubypaper.tv;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// applicatonContext.xml 설정을 대신함, 환경설정 클래스임을 명시
@Configuration
// 아래 Bean 코드를 대신함(어노테이션이 부여된 Class들을 자동으로 Scan하여 Bean으로 등록)
@ComponentScan(basePackages = {"com.rubypaper.tv", "com.test"})
public class TVConfiguration {

//	@Bean
//	TV tv() {
//		// 1. 생성자 injection
//		// return new SamsungTV(speaker());
//		
//		// 2. setter injection
//		// SamsungTV tv = new SamsungTV();
//		// tv.setSpeaker(speaker()); // 생성자, setter 결과 동일
//		// return tv;
//		
//		return new SamsungTV();
//	}
//	
//	@Bean
//	Speaker speaker() {
//		return new SonySpeaker();
//	}
}
