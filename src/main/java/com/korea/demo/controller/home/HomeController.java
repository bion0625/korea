package com.korea.demo.controller.home;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.korea.demo.service.yedana.YedanaService;
import com.korea.demo.vo.yedana.YedanaVO;

@Controller
public class HomeController {
	
	@Autowired
	private YedanaService service;
	
	@RequestMapping(value = {"/", "/home.do"})
	public String home(Model model) {
		System.out.println("서비스 호출전");
		List<YedanaVO> list = service.yedanaList();
		System.out.println("서비스 호출후");
		model.addAttribute("list", list);
		return "/views/home";
	}
}
