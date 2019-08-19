package com.examples.core.java;

public enum NumNames {
	ZERO(""), ONE(" one"), TWO(" two"), THREE(" three"), FOUR(" four"), FIVE(" five"), SIX(" six"), SEVEN(" seven"),
	EIGHT(" eight"), NINE(" nine"), TEN(" ten"), ELEVEN(" eleven"), TWELVE(" twelve"), THIRTEEN(" thirteen"),
	FOURTEEN(" fourteen"), FIFTEEN(" fifteen"), SIXTEEN(" sixteen"), SEVENTEEN(" seventeen"), EIGHTEEN(" eighteen"),
	NINETEEN(" nineteen");

	private final String dayName;

	private NumNames(String dayName) {
		this.dayName = dayName;
	}

	public String getDayName() {
		return dayName;
	}

}
