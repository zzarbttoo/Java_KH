package com.test03;

import java.util.HashSet;
import java.util.Set;

public class MTest01 {

	public static void main(String[] args) {
		Set <String> set = new HashSet<String>();
		set.add("1");
		set.add("5");
		set.add("2");
		set.add("4");
		set.add("3");
		set.add("6");
		set.add("7");
		set.add("1");
		
		//null 넣기만 한다면 nullPointException이 나지는 않는다
		set.add(null); //값으로 저장은 되지만, 사용 시 NullPointerException 발생
		
		for(String s: set) {
			System.out.println(s);
			
		}
//		
		//findeset 했을 때 null 이 있다면 nullpointException이 뜬다
		//아무것도 없는데 무슨 짓을 하려고 하면 nullpointException이 뜬다 
		findset(set, "1");
//		deleteSet(set, "3");
//		System.out.println(set);
			
	}
	
	public static void deleteSet(Set<String> set, String delete) {
		
		

		//for-each문을 이용해 객체에 접근할 수 있다
		for(String s:set) {
			if(s.equals(delete)) {
				set.remove(s);
				//break 를 이용해 remove이후에 객체 접근을 막았다
				break;
			}
		}
		
		
//		그냥 remove 해도 없앨 수 있다
//		set.remove(delete);
		
	}
	//set에 들어가서 우리가 찾고자하는 값을 찾아주는 것
	public static void findset(Set<String> set, String find) {
		
		//get, set 함수가 없기 때문에 for:each 함수를 써서 객체를 직접 들고와야한다
		for(String i: set) {
			
			if(i.equals(find)) {
				System.out.println(find + " 찾았다");
			}
			
		}
	}
}
