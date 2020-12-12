package com.example.smileforme;

import org.junit.Test;
import static org.junit.Assert.*;


public class DonorSignupTest {
	DonorSignUp object =  new DonorSignUp();
	
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
	public void DOBValidator_CorrectDob_ReturnsTrue() {
	    assertEquals(true, object.validateDob("15-11-1996"));
	}
	
	@Test
	public void DOBValidator_InCorrectDobExtraDate_ReturnsFalse() {
	    assertEquals(false, object.validateDob("32-11-1996"));
	}
	
	@Test
	public void DOBValidator_InCorrectDobLessDate_ReturnsFalse() {
	    assertEquals(false, object.validateDob("00-11-1996"));
	}
	
	@Test
	public void DOBValidator_InCorrectDobExtraMonth_ReturnsFalse() {
	    assertEquals(false, object.validateDob("15-15-1996"));
	}
	
	@Test
	public void DOBValidator_InCorrectDobLessMonth_ReturnsFalse() {
	    assertEquals(false, object.validateDob("15-00-1996"));
	}
	
	@Test
	public void DOBValidator_InCorrectDobINcorrectSeparator_ReturnsFalse() {
	    assertEquals(false, object.validateDob("15@00@1996"));
	}
}
