package eCommerce.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class UserController 
{
	@RequestMapping(value="/login_success")
	public String loginCheck(Model m, HttpSession session)
	{
		String page="";
		return page;
		
	}

}
