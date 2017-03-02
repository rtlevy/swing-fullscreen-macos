//Copyright (C) 2017 Raphael Levy
package com.raphaellevy.fullscreen;

public class FullScreenException extends Exception {

	private static final long serialVersionUID = 1L;
	public static final int CLASS_DOES_NOT_EXIST = 0;
	public static final int REFLECTION_ERROR = 1;
	
	FullScreenException(int reason) {
		super(intToMethod(reason));
	}
	private static String intToMethod(int reason) {
		switch (reason) {
		case CLASS_DOES_NOT_EXIST:
			return "Full Screen not Available on this computer; are you running macOS?";
		case REFLECTION_ERROR:
			return "Error Opening Full Screen";
		}
		return "";
	}
}
