package com.examples.core.java;

public enum TensNamesEnum {

	ZERO(""), TEN(" ten"), TWENTY(" twenty"), THIRTY(" thirty"), FOURTY(" forty"), FIFTY(" fifty"), SIXTY(" sixty"),
	SEVENTY(" seventy"), EIGHTY(" eighty"), NINETY(" ninety");

	private final String tensName;

	private TensNamesEnum(String tensName) {
		this.tensName = tensName;
	}

	public String getTensName() {
		return tensName;
	}
}
