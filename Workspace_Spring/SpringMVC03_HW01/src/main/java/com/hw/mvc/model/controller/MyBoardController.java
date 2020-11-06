package com.hw.mvc.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hw.mvc.model.biz.MyBoardBiz;
import com.hw.mvc.model.dto.MyBoardDto;

@Controller
public class MyBoardController {

	@Autowired
	MyBoardBiz biz;
	
	@RequestMapping("list.do")
	public String selectList(Model model) {
		
		model.addAttribute("list", biz.selectList());
		
		return "mylist";
	}
	
	@RequestMapping("detail.do")
	public String selectOne(Model model, int myno) {
		
		model.addAttribute("dto", biz.selectOne(myno));
		
		return "mydetail";
		
	}
	
	@RequestMapping("delete.do")
	public String delete(int myno) {
		
		int res = biz.delete(myno);
		
		if(res > 0) {
			
		return "redirect:list.do";
		}
		return "redirect:detail.do?myno=" + myno;
	} 	
	
	@RequestMapping("insertform.do")
	public String insertform() {
		
		return "myinsert";
	}
	
	@RequestMapping("insertres.do")
	public String insertres(MyBoardDto dto) {
		
		int res = biz.insert(dto);
		
		if(res > 0) {
			
		return "redirect:list.do";
		}
		
		return "redirect:detail.do?" + dto.getMyno();
	}
	
	@RequestMapping("updateform.do")
	public String updateform(Model model, int myno) {
		
		model.addAttribute("dto", biz.selectOne(myno));
		
		return "myupdate";
	}
	
	@RequestMapping("updateres.do")
	public String updateres(MyBoardDto dto) {
		
		int res = biz.update(dto);
		
		if(res > 0) {
			
			return "redirect:detail.do?myno=" + dto.getMyno();
		}
		
		return "redirect:updateform.do?myno" + dto.getMyno();
		
	}
	

	@RequestMapping("/test.do")
	public String test() {
		
		biz.test();
		return "redirect:list.do";
	}
	

}
