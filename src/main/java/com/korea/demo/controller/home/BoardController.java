package com.korea.demo.controller.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {
	
	@RequestMapping("/insert.do")
	private String insert() {
		// TODO Auto-generated method stub
		return "/views/insert";
	}
	@RequestMapping("/view.do")
	private String view() {
		// TODO Auto-generated method stub
		return "/views/view.jsp";
	}

}
