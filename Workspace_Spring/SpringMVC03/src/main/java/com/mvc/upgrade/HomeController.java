package com.mvc.upgrade;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvc.upgrade.model.biz.MyBoardBiz;
import com.mvc.upgrade.model.dto.MyBoardDto;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private MyBoardBiz biz;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("/list.do")
	public String selectList(Model model) {
		model.addAttribute("list", biz.selectList());
		return "mylist";
	}
	
	//값을 담을 때만 Model을 이용하는 듯
	@RequestMapping("/detail.do")
	public String selectOne(Model model, int myno) {
		
		MyBoardDto dto = biz.selectOne(myno);
		model.addAttribute("dto", dto);
		return "mydetail";
		
	}
	
	@RequestMapping("/insertform.do")
	public String insert() {
		return "myinsert";
		
	}
	
	//자동으로 Dto라고 쓰면 들어가진다
	//커맨드 객체
	@RequestMapping("/insertres.do")
	public String insertRes(MyBoardDto dto) {
		int res = biz.insert(dto);
		
		if(res > 0) {
			
			//return "mylist"; 그냥 이렇게 보내면 안됨 
			//model.addAttribute("list", biz.selectList());
			return "redirect:list.do";
		}
		
		return "redirect:insertform.do";
		
	}
	
	
	@RequestMapping("/deleteres.do")
	public String deleteres(int myno) {
		
		int res = biz.delete(myno);
		
		if(res > 0) {
			
			return "redirect:list.do";
			
		}
		
		return "redirect:detail.do?myno=" + myno;
		
	}
	
	@RequestMapping("/updateform.do")
	public String update(Model model, int myno) {
		
		model.addAttribute("dto", biz.selectOne(myno));
		return "myupdate";
	}
	
	@RequestMapping("/updateres.do")
	public String updateres(MyBoardDto dto) {
		
		int res = biz.update(dto);
		
		if(res > 0) {
			return "redirect:detail.do?myno=" + dto.getMyno();
		}
		return "redirect:updateform.do?myno=" + dto.getMyno();
	}
	
}
