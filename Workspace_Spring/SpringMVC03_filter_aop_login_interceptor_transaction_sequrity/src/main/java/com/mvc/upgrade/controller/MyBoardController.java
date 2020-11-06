package com.mvc.upgrade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.upgrade.model.biz.MyBoardBiz;
import com.mvc.upgrade.model.dto.MyBoardDto;

@Controller
public class MyBoardController {

	@Autowired
	private MyBoardBiz biz;
	
	@RequestMapping("/list.do")
	public String selectList(Model model) {
		System.out.println("list.do");
		
		model.addAttribute("list", biz.selectList());
		
		return "mylist";
	}
	
	@RequestMapping("/insertform.do")
	public String insertForm() {
		System.out.println("insertform.do");
		
		return "myinsert";
	}
	
	@RequestMapping("/insertres.do")
	public String insertRes(@ModelAttribute MyBoardDto dto) {
		System.out.println("insertres.do");
		
		int res = biz.insert(dto);
		
		if (res > 0) {
			return "redirect:list.do";
		}
		
		return "redirect:insertform.do";
	}
	
	@RequestMapping("/detail.do")
	public String detail(Model model, int myno) {
		System.out.println("detail.do");
		
		model.addAttribute("dto", biz.selectOne(myno));
		
		return "mydetail";
	}
	
	@RequestMapping("/updateform.do")
	public String updateForm(Model model, int myno) {
		System.out.println("updateform.do");
		
		model.addAttribute("dto", biz.selectOne(myno));
		
		return "myupdate";
	}
	
	@RequestMapping("/updateres.do")
	public String updateRes(MyBoardDto dto) {
		System.out.println("updateres.do");
		
		int res = biz.update(dto);
		if (res > 0) {
			return "redirect:detail.do?myno=" + dto.getMyno();
		}
		
		return "redirect:updateform.do?myno=" + dto.getMyno();
	}
	
	@RequestMapping("/delete.do")
	public String delete(int myno) {
		System.out.println("delete.do");
		
		int res = biz.delete(myno);
		if (res > 0) {
			return "redirect:list.do";
		}
		
		return "redirect:delete.do?myno=" + myno;
	}
	
	@RequestMapping("/test.do")
	public String test() {
		System.out.println("/test.do");
		biz.test();
		return "redirect:list.do";
	}
	
}





















