package com.mvc.update.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.update.model.biz.JDBCBiz;
import com.mvc.update.model.dto.JDBCDto;

@Controller
public class JDBCController {

	@Autowired
	private JDBCBiz biz;
	
	@RequestMapping("/list.do")
	public String list(Model model) {
		
		model.addAttribute("list", biz.selectList());
		return "jdbclist";
		
	}
	
	@RequestMapping("/detail.do")
	public String detail(Model model, int seq) {
		
		model.addAttribute("dto", biz.selectOne(seq));
		
		return "jdbcdetail";
	}
	
	@RequestMapping("insertform.do")
	public String insertform() {
		
		return "jdbcinsert";
	}
	
	@RequestMapping("insertres.do")
	public String insertres(JDBCDto dto) {
		
		int res = biz.insert(dto);
		
		if(res > 0) {
			
			return "redirect:list.do";
		}
		return "redirect:insertform.do";
	}
	
	@RequestMapping("delete.do")
	public String delete(int seq) {
		
		int res = biz.delete(seq);
		
		if(res > 0) {
			return "redirect:list.do";
		}
		return "redirect:detail.do?seq=" + seq;
	}
	
	@RequestMapping("/updateform.do")
	public String updateForm(Model model, int seq) {
		model.addAttribute("dto", biz.selectOne(seq));
		
		return "jdbcupdate";
	}
	
	@RequestMapping("/updateres.do")
	public String updateRes(JDBCDto dto) {
		
		if(biz.update(dto) > 0) {
			return "redirect:detail.do?seq=" + dto.getSeq();
		}
		
		return "redirect:updateform.do?seq=" + dto.getSeq();
	}
}
