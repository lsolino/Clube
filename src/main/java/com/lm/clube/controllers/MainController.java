package com.lm.clube.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class MainController {
	
	@RequestMapping("")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("Index");
		return (mv);
	}
	
	@RequestMapping(value = "/grupo")
	public ModelAndView grupo() {
		ModelAndView mv = new ModelAndView("Grupo");
		return (mv);
	}
	
	@RequestMapping(value = "/sobre")
	public ModelAndView sobre() {
		ModelAndView mv = new ModelAndView("Sobre");
		return (mv);
	}

}
