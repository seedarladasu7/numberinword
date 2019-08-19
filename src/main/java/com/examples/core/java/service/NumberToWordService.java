package com.examples.core.java.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NumberToWordService {

	private static final Logger LOGGER = LoggerFactory.getLogger(NumberToWordService.class);
	
	@Autowired
	NumberToEnglishWords numberToEnglishWords;

	public String getNumberInWord(String strNum) {
		long number = 0l;
		try {
			number = Long.valueOf(strNum);
			return numberToEnglishWords.convert(number);
		} catch (NumberFormatException nfe) {
			LOGGER.error("Given String {} is not a number", strNum);
		} catch (ArithmeticException ae) {
			LOGGER.error("ArithmeticException while performing arithmetic operation(s) {}", ae.getMessage());
		} catch (Exception ex) {
			LOGGER.error("Exception cought {}", ex.getMessage());
		}
		return "Invalid input" + strNum;
	}
}
