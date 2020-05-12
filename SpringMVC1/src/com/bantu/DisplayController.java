package com.bantu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DisplayController {
	@RequestMapping("/msg")
	
	public ModelAndView display()
	{
		String msg="hello i am from kl hyderabad";		
		return new ModelAndView("display","val","msg");

}
}
