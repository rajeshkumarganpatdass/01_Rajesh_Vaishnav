package test.java.bean;

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.util.ShoppingCartUtil;

public class ShoppingCartUtilTest {

	@Test
	public void isCustomerAgeMoreThanTwoYearsTest() {
		//Case 1 - User is more than 2 years
		String strUserDate = "2004-12-12";
		boolean isUserMoreThanTwoYear = 
				ShoppingCartUtil.isCustomerAgeMoreThanTwoYears(strUserDate);
		
		assertTrue(isUserMoreThanTwoYear);
		
		//Case 2 - User is not more than 2 years
		strUserDate = "2021-12-12";
		isUserMoreThanTwoYear = ShoppingCartUtil.isCustomerAgeMoreThanTwoYears(strUserDate);

		assertFalse(isUserMoreThanTwoYear);
	}

}
