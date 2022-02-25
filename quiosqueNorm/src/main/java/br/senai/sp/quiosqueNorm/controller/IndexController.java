package br.senai.sp.quiosqueNorm.controller;

import java.sql.Connection;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping("/")
	public String index() {
		
		return "index";
	}

}