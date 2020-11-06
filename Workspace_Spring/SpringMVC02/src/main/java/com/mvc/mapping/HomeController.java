package com.mvc.mapping;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mvc.mapping.model.dto.AddressDto;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
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
	
	@RequestMapping(value = "/command.do", method = RequestMethod.GET)
	public String getCommand(Model model, String name, @RequestParam("addr") String address, String phone) {
		
		System.out.println("name :" + name);
		System.out.println("address : " + address);
		System.out.println("phone :" + phone );
		
		
		model.addAttribute("dto", new AddressDto(name, address, phone));
	
		
		return "get";
		
	}
	
	//get방식으로 요청을 하면 위의 것이, post 방식으로 요청하면 아래것이 된다
	// /command.do 의 /는 없어도 된다
	@RequestMapping(value = "command.do", method = RequestMethod.POST)
	public String postCommand(Model model, @ModelAttribute AddressDto dto) {
		
		model.addAttribute("dto", dto);
		
		return "post";
	}
	
	@RequestMapping("/void.do")
	public void voidPage(Model model) {
		model.addAttribute("msg", "void page");
		
	}
}
