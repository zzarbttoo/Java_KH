package com.boot.jdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boot.jdbc.model.biz.MyBiz;
import com.boot.jdbc.model.dto.MyDto;

@Controller
@RequestMapping("/myboard")
public class MyController {
	
	@Autowired
	private MyBiz biz;
	
	@GetMapping("/list")
	public String selectList(Model model) {
		
		model.addAttribute("list", biz.selectList());
		
		return "mylist";
	}
	
	@GetMapping("/detail")
	public String detail(Model model, int myno) {
		
		model.addAttribute("dto", biz.selectOne(myno));
		
		return "mydetail";
		
		
	}
	
	@GetMapping("/insertform")
	public String insertform() {
		
		return "myinsert";
	}
	
	@PostMapping("/insertres")
	public String insertres(MyDto dto) {
		
		int res = biz.insert(dto);
		
		if(res > 0) {
			
			return "redirect:list";
		}
		
		return "redirect:insertform";
	}
	
	@GetMapping("updateform")
	public String updateform(Model model, int myno) {
		
		model.addAttribute("dto", biz.selectOne(myno));
		
		return "myupdate";
	}
	
	@PostMapping("updateres")
	public String updateres(MyDto dto) {
		
		int res = biz.update(dto);
		
		if(res > 0) {
			
			return "redirect:detail?myno=" + dto.getMyno();
		}
		return "redirect:updateform?myno=" + dto.getMyno();
		
	}
	
	@GetMapping("delete")
	public String delete(int myno) {
		
		int res = biz.delete(myno);
		
		if(res > 0) {
			
			return "redirect:list";
			
		}
			
			return "redirect:detail?myno=" + myno; 
	}

}
