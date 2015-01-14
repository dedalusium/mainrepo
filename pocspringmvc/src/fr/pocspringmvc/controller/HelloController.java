package fr.pocspringmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/hello")
public class HelloController {

	@RequestMapping
	public String hello() {
		// simple methode returning view from a simple string
		return "hello";
	}

	@RequestMapping("/string")
	public String helloString() {
		// simple methode returning view from a simple string
		return "hello";
	}

	@RequestMapping("/message")
	public ModelAndView helloModelAndView() {
		// returning a message with the view name
		String msg = "With message!";
		return new ModelAndView("hello", "msg", msg);
	}

}