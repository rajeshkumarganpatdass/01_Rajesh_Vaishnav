package main.java.util;

import java.time.LocalDate;
import java.time.Period;

public class ShoppingCartUtil {

	public static final double DiscountPercentageIfUserIsAnEmployee = 30.00;
	
	public static final double DiscountPercentageIfUserIsAnAffiliate = 10.00;
	
	public static final double DiscountPercentageIfUserIsAnCustomerForOverTwoYears = 5.00;
	
	public static final double DiscountPercentageIfBillGreaterThanHundred = 5.00;
	
	public static final int TWO = 2;
	
	public static final double HUNDRED = 100;
	
	public static boolean isCustomerAgeMoreThanTwoYears(String strDate)
	{
		boolean isCustomerAgeMoreThanTwoYears = false;
		LocalDate customerDate = LocalDate.parse(strDate);  
	    LocalDate today = LocalDate.now(); 
	    Period cusomterAge = Period.between(customerDate, today); 
	    if(cusomterAge.getYears() >= ShoppingCartUtil.TWO)
	    {
	    	isCustomerAgeMoreThanTwoYears = true;
	    	System.out.println("Yes");
	    }
	    return isCustomerAgeMoreThanTwoYears;
	}
}
