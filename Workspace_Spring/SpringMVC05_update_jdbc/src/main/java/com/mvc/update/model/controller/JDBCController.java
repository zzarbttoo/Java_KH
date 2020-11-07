package com.mvc.update.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.update.model.biz.JDBCBiz;

@Controller
public class JDBCController {

	@Autowired
	private JDBCBiz biz;
	
	@RequestMapping("/list.do")
	public String list(Model model) {
		
		model.addAttribute("list", biz.selectList());
		return "jdbclist";
		
	}
	
}
