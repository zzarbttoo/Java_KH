package com.hello.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hello.mvc.model.HelloBiz;

//해당 클래스가 컨트롤러다
@Controller
public class HelloController {

	// TODO : 05. Biz(@Service) 호출
	@Autowired
	private HelloBiz biz;

	//그냥 model 객체만 만들어주고 어디에 보낼건지만 알려주면 된다
	// TODO : 04. handler mapping(/hello.do) 를 통해 controller의 메서드를 찾아옴
	@RequestMapping("/hello.do")
	public String getHello(Model model) {

		// TODO : 09. return 받은 값을 model 객체에 담아서 전달(ModelAndView)
		model.addAttribute("message", biz.getHello());

		return "/WEB-INF/views/hello.jsp";
	}
	
	//request.getParmaeter 할 필요 없이 name이라는 파라미터를 쓰면 자동으로 받아준다
	//httpRequest로 해도 되지만 굳이 안해도 된다
	//위에꺼가 최신, 밑에꺼가 옛날꺼
	@RequestMapping("/bye.do")
	public ModelAndView getBye(String name) {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("/WEB-INF/views/bye.jsp");
		mav.addObject("message", "Bye, " +name);
		
		return mav;
	}
}

/*

@RequestMapping()
-url을 class 또는 method에 mapping

@RequestParam
-key=value 형태로 넘어오는 queryString(parameter)을,
mapping 된 method의 parameter와 연결

@ModelAttribute
-form tag를 통해서 넘어온 model을 mapping된 method의 parameter와 연결

@SessionAttribute
-session에서 model의 정보를 유지하고 싶을 때 사용



 */

