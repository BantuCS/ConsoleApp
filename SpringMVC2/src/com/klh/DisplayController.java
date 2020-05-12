package com.klh;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DisplayController {
	
	@RequestMapping("/bye")
	public ModelAndView display()
	{
		String msg="hello i am from KLH";
		
		return new ModelAndView("dispaly","hey",msg);
	}

}
