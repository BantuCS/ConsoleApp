

package com.bantu;

import org.springframework.web.servlet.mvc.Controller;
import org.apache.catalina.connector.Request;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RestController;

@Controller

public class Sample {
	
	@RequestMapping("/sum")
	public ModelAndView sum (HttpServletRequest req,HttpServletResponse res)
	{
		int i=Integer.parseInt(req.getparameter("t1"));
		int j=Interger.parseInt(req.getparameter("t2"));
		int k=i+j;
		
		//ModelAndView mv=new ModelAndView();
		//mv.setViewName("display.jsp");
		//mv.addObject("result",k);
		//return mv;
		
		return new ModelAndView("display","result","k");
	}}
