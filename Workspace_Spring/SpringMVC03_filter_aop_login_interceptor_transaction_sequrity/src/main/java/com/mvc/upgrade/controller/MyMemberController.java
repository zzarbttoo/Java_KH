package com.mvc.upgrade.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@RequestMapping("/loginform.do")
	public String loginForm() {
		return "mylogin";
	}
	
	@RequestMapping(value="/ajaxlogin.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Boolean> ajaxLogin(@RequestBody MyMemberDto dto, HttpSession session){
		/*
		 * @RequestBody : request 객체를 통해 넘어온 데이터를 java 객체에 binding
		 * @ResponseBody : java 객체를 response 객체의 데이터로 binding
		 */
		
		MyMemberDto res = biz.login(dto);
		
		boolean check = false;
		if (res != null) {
			
			//matches(내가 보내준 pw, db에 저장된 암호화된 pw)
			//두개의 pw 가 같은 값인지 확인해줌
			if(passwordEncoder.matches(dto.getMemberpw(), res.getMemberpw())) {
				session.setAttribute("login", res);
				check = true;
			}
			
			session.setAttribute("login", res);
			check = true;
		}
		
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("check", check);
		
		return map;
	}
	
	@RequestMapping("/registerform.do")
	public String register() {
		
		return "myregister";
	}
	
	@RequestMapping("/register.do")
	public String registerRes(MyMemberDto dto) {
		
		System.out.println("암호화 전:" + dto.getMemberpw());
		dto.setMemberpw(passwordEncoder.encode(dto.getMemberpw()));
		System.out.println("암호화 후:" + dto.getMemberpw());
		
		if(biz.register(dto) > 0) {
			
			return "redirect:loginform.do";
		}
		
		return "redirect:registerform.do";
	}
}












