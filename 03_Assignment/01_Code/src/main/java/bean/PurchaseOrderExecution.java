package main.java.bean;

import java.text.ParseException;

import main.java.vo.CartVO;
import main.java.vo.UserVO;



public class PurchaseOrderExecution {
	
	public static void main(String args[]) throws ParseException
	{
		
		PurchaseOrderBean objPurchaseOrderBean = new PurchaseOrderBean();
		
		UserVO userVO = loadUserData();
	    
		double netPayableAmount = objPurchaseOrderBean.calculateNetPayableAmount(userVO);
		
		System.out.println("Net Payable Amount After Discount: "+netPayableAmount);
	}

	public static UserVO loadUserData()
	{
		String strUserDate = "2004-12-12";
		
		UserVO userVO = new UserVO();
		userVO.setStrUserId("79545");
		userVO.setStrFirstName("Tom");
		userVO.setStrLastName("Harry");
		userVO.setBlnIsEmployee(false);
		userVO.setBlnIsAffiliate(true);
		userVO.setStrUserStartDate(strUserDate);
		userVO.setCartVO(loadCartData());
		return userVO;
	}
	
	public static CartVO loadCartData()
	{
		CartVO cartVO = new CartVO();
		cartVO.setGroceriesAmount(1000);
		cartVO.setCartTotalAmount(3000);
		return cartVO;
	}

}
