package com.test01.anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


//MyNickNamePrn myNickNamePrn = new MyNickNamePrn();
//<bean id = "myNickNamePrn" class = "MyNickNamePrn"/>
@Component
public class MyNickNamePrn {

		//field 주입
		@Autowired 
		private Nickname nickName;
		

		public Nickname getNickName() {
			return nickName;
		}

		public void setNickName(Nickname nickName) {
			this.nickName = nickName;
		}

		@Override
		public String toString() {
			return  "나의 별명은" + nickName + "입니다. ";
		}
		
	
		
	
}
