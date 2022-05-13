package main.java.bean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import main.java.util.ShoppingCartUtil;
import main.java.vo.CartVO;
import main.java.vo.UserVO;

public class PurchaseOrderBean {

	private double amountConsideredForDiscount;

	private double discountPercentage;

	private double maxPercantageDiscount;

	private double billableAmountAFterPercDiscount;

	private double netPayableAmount;

	private double finalDiscount;

	public double calculateNetPayableAmount(UserVO userVO)
	{
		initializeVariables();
		
		List<Double> lstDiscounts = new ArrayList<Double>();
		CartVO cartVO = userVO.getCartVO();
		
		if(userVO.isBlnIsEmployee())
		{
			amountConsideredForDiscount = cartVO.getCartTotalAmount() - cartVO.getGroceriesAmount();
			discountPercentage = ShoppingCartUtil.DiscountPercentageIfUserIsAnEmployee;
			lstDiscounts.add
					(calculateDiscount
							(amountConsideredForDiscount, discountPercentage));
			
		}
		else if(userVO.isBlnIsAffiliate())
		{
			amountConsideredForDiscount = cartVO.getCartTotalAmount() - cartVO.getGroceriesAmount();
			discountPercentage = ShoppingCartUtil.DiscountPercentageIfUserIsAnAffiliate;
			lstDiscounts.add
					(calculateDiscount
							(amountConsideredForDiscount, discountPercentage));
		}
		else if(ShoppingCartUtil.isCustomerAgeMoreThanTwoYears(userVO.getStrUserStartDate()))
		{
			amountConsideredForDiscount = cartVO.getCartTotalAmount() - cartVO.getGroceriesAmount();
			discountPercentage = ShoppingCartUtil.DiscountPercentageIfUserIsAnCustomerForOverTwoYears;
			lstDiscounts.add
					(calculateDiscount
							(amountConsideredForDiscount, discountPercentage));
		}
		
		if(!lstDiscounts.isEmpty())
			maxPercantageDiscount = Collections.max(lstDiscounts);
			
		billableAmountAFterPercDiscount = cartVO.getCartTotalAmount() - maxPercantageDiscount;
		
		if(billableAmountAFterPercDiscount > ShoppingCartUtil.HUNDRED)
		{
			int multiplesOfHundred = (int) (billableAmountAFterPercDiscount / 100);
			finalDiscount = (ShoppingCartUtil.DiscountPercentageIfBillGreaterThanHundred * multiplesOfHundred)
							+ maxPercantageDiscount;
		}
		
		netPayableAmount = cartVO.getCartTotalAmount() - finalDiscount;
		return netPayableAmount;
	}
	
	public double calculateDiscount(double amountConsideredForDiscount, double discountPercentage) 
	{
		return (discountPercentage * amountConsideredForDiscount / 100);
	}
	
	public void initializeVariables()
	{
		
		amountConsideredForDiscount = 0.0;
		
		discountPercentage = 0.0;
		
		maxPercantageDiscount = 0.0;
		
		billableAmountAFterPercDiscount = 0.0;
		
		finalDiscount = 0.0;
		
		netPayableAmount = 0.0;
	}
	
}
