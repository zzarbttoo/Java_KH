package com.mvc.upgrade.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mvc.upgrade.model.biz.MyMemberBiz;
import com.mvc.upgrade.model.dto.MyMemberDto;

@Controller
public class MyMemberController {

	@Autowired
	private MyMemberBiz biz;
	
	@RequestMapping("/loginform.do")
	public String toLogin() {
		
		return "mylogin";
		
	}
	
	@RequestMapping(value = "/ajaxlogin.do" , method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Boolean> ajaxLogin(@RequestBody MyMemberDto dto, HttpSession session){
		
		/*
		 * @RequestBody : request 객체를 통해 넘어온 데이터를 java 객체에 binding
		 * @ResponseBody : java 객체를 response 객체의 데이터로 binding
		 * 
		 */
		
		MyMemberDto res = biz.login(dto);
		
		boolean check = false;
		

		if(res != null) {
			System.out.println("왜안뜸");
			System.out.println(res.getMemberid());
			System.out.println(res.getMemberpw());
			session.setAttribute("login", res);
			check = true;
			
		}
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("check", check);
		
		return map;
	}
	
	
	@RequestMapping("/registform.do")
	public String registform() {
		
		return "myregist";
	}
	
	@RequestMapping("/registres.do")
	public String registres(MyMemberDto dto) {
		
		int res = biz.register(dto);
		
		if(res > 0) {
			
		return "redirect:loginform.do";
		}
		return "redirect:registform.do";
	}
	
}
