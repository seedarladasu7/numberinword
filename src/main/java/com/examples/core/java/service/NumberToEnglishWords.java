package com.examples.core.java.service;

import java.text.DecimalFormat;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class NumberToEnglishWords {

	private static final String[] tensNames = { "", " ten", " twenty", " thirty", " forty", " fifty", " sixty",
			" seventy", " eighty", " ninety" };

	private static final String[] numNames = { "", " one", " two", " three", " four", " five", " six", " seven",
			" eight", " nine", " ten", " eleven", " twelve", " thirteen", " fourteen", " fifteen", " sixteen",
			" seventeen", " eighteen", " nineteen" };

	private NumberToEnglishWords() {
		
	}

	public String convert(long number) {
		// 0 to 999 999 999
		if (number == 0) {
			return "zero";
		}

		String snumber = Long.toString(number);

		String mask = "000000000";
		DecimalFormat df = new DecimalFormat(mask);
		snumber = df.format(number);

		int millions = Integer.parseInt(snumber.substring(0, 3));
		int hundredThousands = Integer.parseInt(snumber.substring(3, 6));
		int thousands = Integer.parseInt(snumber.substring(6, 9));

		String numMillions;

		switch (millions) {
		case 0:
			numMillions = "";
			break;
		case 1:
			numMillions = convertLessThanOneThousand(millions) + " million ";
			break;
		default:
			numMillions = convertLessThanOneThousand(millions) + " million ";
		}

		String result = numMillions;

		String numHundredAndThousands;

		switch (hundredThousands) {
		case 0:
			numHundredAndThousands = "";
			break;
		case 1:
			numHundredAndThousands = "one thousand ";
			break;
		default:
			numHundredAndThousands = convertLessThanOneThousand(hundredThousands) + " thousand ";
		}

		result = result + numHundredAndThousands;

		String tradThousand;
		tradThousand = convertLessThanOneThousand(thousands);
		result = result + tradThousand;

		// remove extra spaces!
		return result.replaceAll("^\\s+", "").replaceAll("\\b\\s{2,}\\b", " ");
	}
	
	//public modifier in order to access it from test cases
	public String convertLessThanOneThousand(int number) {
		String tillNow;

		if (number % 100 < 20) {
			tillNow = numNames[number % 100];
			number /= 100;
		} else {
			tillNow = numNames[number % 10];
			number /= 10;

			tillNow = tensNames[number % 10] + tillNow;
			number /= 10;
		}
		
		if (number != 0 && !StringUtils.isEmpty(tillNow)) {
			tillNow = " and " + tillNow;
		}
		
		if (number == 0) {
			return tillNow;
		}

		return numNames[number] + " hundred " + tillNow;
	}

}