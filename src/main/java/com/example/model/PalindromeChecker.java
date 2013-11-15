package com.example.model;

public class PalindromeChecker {

	public boolean isAPalindrome(String string) {
		StringBuffer reverseStringBuffer = getReversedString(string);
		
		if(string.equalsIgnoreCase(reverseStringBuffer.toString())) {
			return true;
		}
		return false;
	}

	private StringBuffer getReversedString(String string) {
		StringBuffer reverseStringBuffer = new StringBuffer(string);
		reverseStringBuffer.reverse();
		return reverseStringBuffer;
	}

}
