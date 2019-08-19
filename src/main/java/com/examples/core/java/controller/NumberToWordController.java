package com.examples.core.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examples.core.java.service.NumberToWordService;

@RestController
@RequestMapping("/services")
public class NumberToWordController {

	@Autowired
	NumberToWordService service;

	@GetMapping("/numberInWord/{strNum}")
	public String getNumberInWord(@PathVariable String strNum) {
		return service.getNumberInWord(strNum);
	}

}
