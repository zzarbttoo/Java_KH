package com.test02;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;

/*
 * MessageSourceAware는 번들이 지정된 properties 파일을 setMessageSource() 로 전달한다
 * -> 메시지 국제화를 위해 사용한다
 * properties로 바뀌어야 하는 부분으로 미리 만들어놓고 이렇게 사용
 * 
 * ResourceBundleMessageSource의 setBaseName() 을 통해 전달받은 파일을
 * setMessageSource() 를 자동으로 호출해서 매핑하는 역할을 한다.
 * 
 * ResourceBundleMessageSource와 MessageSourceAware은 쌍으로 사용한다
 */

public class MemberInfo implements MessageSourceAware {

	// properties 파일(속성값으로 받은 파일을 열어서 'k= v' 형태를 읽어서 파싱하여 사용
	private MessageSource message;
	
	
	@Override
	public void setMessageSource(MessageSource messageSource) {
		
		System.out.println("컨테이너가 메세지 설정을 수행중...");
		this.message = messageSource;
	}
	
	public void display(Locale locale) {
		
		String name = message.getMessage("member.name", null ,locale);
		String birthplace = message.getMessage("member.birthplace", null , locale);
		String hobby = message.getMessage("member.hobby", null, locale);
		String age = message.getMessage("member.age", new Object[] {"15"} , locale);
		
		System.out.println(locale);
		System.out.println(name);
		System.out.println(birthplace);
		System.out.println(hobby);
		System.out.println(age);
		
		
		
	}

}
