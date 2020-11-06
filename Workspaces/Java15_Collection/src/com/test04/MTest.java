package com.test04;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MTest {

	
	public static void main(String[] args) {
		// Map<K, V> k: key, v: value
		Map<Integer, String> map = new HashMap<Integer, String>();
		
		
		//순서가 없다
		for(int i = 111; i < 116 ; i++) {
			map.put(i, i+"abc");
		}
		
		//key는 중복이 안되나, value는 중복이 안된다 
		System.out.println(map);
		map.put(112, "abc112");
		System.out.println(map);
		map.put(112, "113abc");
		System.out.println(map);
	
		//key를 통해 value를 가지고 올 수 있다
		System.out.println(map.get(114));
		
		printMap(map);
	}
	
	
	
	public static void printMap(Map<Integer, String> map) {
		
		
		Collection<String> strValues = map.values();
		System.out.println(strValues);
		
		//Set 대신 Collection을 써도 됨(Set은 Collection을 상속받았기 때문)
		Set<Integer> intKeys=map.keySet();
		System.out.println(intKeys);
		
		//Entry : key 따로 value 따로 
		//Map.Entry라는 객체를 set에다 넣어서 관리하겠다
		//Map.Entry : K 와 V를 관리하는 클래스
		//Map : K -> V / Entry : K|V(key와 value를 짤라서 관리할 것이다)
		Set<Map.Entry<Integer, String>> entrySet = map.entrySet();
		
		for(Entry <Integer, String> entry : entrySet) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
		
		
		Iterator<Map.Entry<Integer, String>> ir = entrySet.iterator();
		// value가 115abc인 key 값을 찾아서, 해당 key값을 출력하자.
		
		while(ir.hasNext()) {
			
			//ir 안에 있는 Entry 값을 가져와서
			//Entry 안에 있는 value를 가져와서 115abc와 비교해서
			//해당 key 값을 출력
			Map.Entry<Integer, String> temp = ir.next();
			
			if(temp.getValue().equals("115abc")) {
				System.out.println(temp.getKey());
			}
		}
	}
	
	
}
