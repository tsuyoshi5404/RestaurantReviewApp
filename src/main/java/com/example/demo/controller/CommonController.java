package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonController {
	

	/*完了後のリダイレクト先*/
	@GetMapping("/complete")
	private String complete() {		
		return "complete";
	}

}
