package spring.mvc.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {
	
	String message =  "Welcome to Spring MVC";
	
	@RequestMapping("/hello")
	public ModelAndView showMessage(@RequestParam(value="name", required= false,defaultValue="World") String name) {
		System.out.println("In Controller");
		ModelAndView mv = new ModelAndView("helloworld");
		mv.addObject("message", message);
		mv.addObject("name", name);
		
		Map<String, Integer> map =  new HashMap<String, Integer>();
		map.put("Z", 1);
		map.put("a", 2);		
		return mv;
	}
}
