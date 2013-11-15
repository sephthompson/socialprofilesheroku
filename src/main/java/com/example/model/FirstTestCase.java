package com.example.model;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Test;

public class FirstTestCase extends TestCase {
	
	PalindromeChecker testObject;

	public void setUp() {
		testObject = new PalindromeChecker();
	}
	
	@Test
	public void test1CreatePalindromeTestObject() {
		assertNotNull(testObject);
	}
	
	@Test
	public void test2SimplePalindromeMethod_YesPalindrome1() throws Exception {
		assertTrue(testObject.isAPalindrome("MOM"));
	}
	
	@Test
	public void test3SimplePalindromeMethod_NotAPalindrome1() throws Exception {
		assertFalse(testObject.isAPalindrome("Blah"));
	}
	
	@Test
	public void test4SimplePalindromeMethod_NotAPalindrome2() throws Exception {
		assertFalse(testObject.isAPalindrome("kjhsdfhjksadhjaksfdjlh"));
	}
	
	@Test
	public void testComplexPalindromeOnMethod() throws Exception {
		assertTrue(testObject.isAPalindrome("killinillik"));
	}

}
