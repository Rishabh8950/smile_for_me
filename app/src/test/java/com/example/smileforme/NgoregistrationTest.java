package com.example.smileforme;

import org.junit.Test;

import com.example.smileforme.Ngoregistration;

import static org.junit.Assert.*;

public class NgoregistrationTest {

Ngoregistration object = new Ngoregistration();
	
	@Test
	public void emailValidator_CorrectEmailSimple_ReturnsTrue() {
	    assertEquals(true, object.validateMail("name@email.com"));
	}
	
	@Test
	public void emailValidator_InvalidEmailNoTld_ReturnsFalse() {
		assertEquals(false, object.validateMail("name@email"));
	}
	
	@Test
	public void emailValidator_InvalidEmailDoubleDot_ReturnsFalse() {
		assertEquals(false, object.validateMail("name@email..com"));
	}
	
	@Test
	public void emailValidator_InvalidEmailNoUsername_ReturnsFalse() {
		assertEquals(false, object.validateMail("@email.com"));
	}
	
	@Test
	public void emailValidator_EmptyString_ReturnsFalse() {
		assertEquals(false, object.validateMail(""));
	}
	
	@Test
	public void MobileValidator_CorrectMobile_ReturnsTrue() {
	    assertEquals(true, object.validateMobile("9876543210"));
	}
	
	@Test
	public void MobileValidator_InCorrectMobileWrongStart_ReturnsFalse() {
	    assertEquals(false, object.validateMobile("5476543210"));
	}
	
	@Test
	public void MobileValidator_IncorrectMobileLessDigit_ReturnsFalse() {
	    assertEquals(false, object.validateMobile("98210"));
	}
	
	@Test
	public void MobileValidator_IncorrectMobileMoreDigit_ReturnsFalse() {
	    assertEquals(false, object.validateMobile("9876543210000"));
	}
	
	@Test
	public void MobileValidator_IncorrectMobileAlphabet_ReturnsFalse() {
	    assertEquals(false, object.validateMobile("abcde210000"));
	}
	
	@Test
	public void NameValidator_CorrectName_ReturnsTrue() {
	    assertEquals(true, object.validateName("Ramya Shree"));
	}
	
	@Test
	public void NameValidator_MissingLastName_ReturnsFalse() {
	    assertEquals(false, object.validateName("Ramya "));
	}
	
	@Test
	public void NameValidator_MissingFirstName_ReturnsFalse() {
	    assertEquals(false, object.validateName(" Shree"));
	}
	
	@Test
	public void NameValidator_NoName_ReturnsFalse() {
	    assertEquals(false, object.validateName(""));
	}
	
	@Test
	public void NameValidator_SpecialCharName_ReturnsFalse() {
	    assertEquals(false, object.validateName("R@mya Shree"));
	}
	
	@Test
	public void PassValidator_CorrectPass_ReturnsTrue() {
	    assertEquals(true, object.validatePwd("Pass123"));
	}
	
	@Test
	public void PassValidator_InCorrectPass_ReturnsFalse() {
	    assertEquals(false, object.validatePwd("Pass@123"));
	}
	
	@Test
	public void PassValidator_NoPass_ReturnsFalse() {
	    assertEquals(false, object.validatePwd(""));
	}
	
	@Test
	public void IdValidator_CorrectID_ReturnsTrue() {
	    assertEquals(true, object.validateNgoId("9876543210"));
	}
	
	@Test
	public void IdValidator_IncorrectIDLessDigit_ReturnsFalse() {
	    assertEquals(false, object.validateNgoId("98210"));
	}
	
	@Test
	public void IdValidator_IncorrectIDMoreDigit_ReturnsFalse() {
	    assertEquals(false, object.validateNgoId("9876543210000"));
	}
	
	@Test
	public void IdValidator_IncorrectIDAlphabet_ReturnsFalse() {
	    assertEquals(false, object.validateNgoId("abcde210000"));
	}
}
