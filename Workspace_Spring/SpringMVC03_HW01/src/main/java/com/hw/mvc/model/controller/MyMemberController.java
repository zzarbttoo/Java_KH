package com.hw.mvc.model.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hw.mvc.model.biz.MyMemberBiz;
import com.hw.mvc.model.dto.MyMemberDto;

@Controller
public class MyMemberController {

	@Autowired
	public MyMemberBiz biz;
	
	@RequestMapping("loginform.do")
	public String loginform() {
		
		return "mylogin";
	}
	
	@RequestMapping("ajaxlogin.do")
	@ResponseBody
	public Map<String, Boolean> ajaxLogin(@RequestBody MyMemberDto memberdto, HttpSession session ){
		
		MyMemberDto res = biz.login(memberdto);
		
		boolean check = false;
		
		if(res != null) {
			
			session.setAttribute("login", res);
			check = true;
		}
		
		Map<String, Boolean> map= new HashMap<String, Boolean>();
		map.put("check", check);
		
		return map;
		
	}
	
	@RequestMapping("registerform.do")
	public String registerform() {
		
		return "myregist";
		
	}
	
	@RequestMapping("/registres.do")
	public String registres(MyMemberDto dto) {
		
		int res = biz.register(dto);
		
		if (res > 0) {
			
			return "redirect:loginform.do";
		}
		return "redirect:registform.do";
	}
	
	
	
	
}
