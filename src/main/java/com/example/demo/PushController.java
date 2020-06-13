package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PushController {

	@GetMapping("/push")
	public String getHello() {
		return "push";
	}

	@PostMapping("/push")
	public String postPush(@RequestParam("text1")String str, Model model) {

		System.out.println(str);

		return "redirect:/push";
	}

}
