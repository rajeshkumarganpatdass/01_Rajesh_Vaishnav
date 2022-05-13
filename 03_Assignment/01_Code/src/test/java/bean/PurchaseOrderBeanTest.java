package test.java.bean;

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.bean.PurchaseOrderBean;
import main.java.vo.CartVO;
import main.java.vo.UserVO;

public class PurchaseOrderBeanTest {

	@Test
	public void calculateNetPayableAmountForEmployeeTest() {

		UserVO userVO = loadUser();
		
		PurchaseOrderBean objPurchaseOrderBean = new PurchaseOrderBean();
		
		//Case 1 - Employee 30% Discount and 5% on every $100 after discount
		//% Discount = 300, Balance 1700, 17*5=85, Net=1700-85=1615
		userVO.setBlnIsEmployee(true);
		userVO.getCartVO().setCartTotalAmount(2000);
		userVO.getCartVO().setGroceriesAmount(1000);
		
		double netPayableAmount = objPurchaseOrderBean.calculateNetPayableAmount(userVO);
		
		assertEquals(1615.0, netPayableAmount, 0.0);
		
	}
	
	@Test
	public void calculateNetPayableAmountForAffiliateTest() {

		UserVO userVO = loadUser();
		
		PurchaseOrderBean objPurchaseOrderBean = new PurchaseOrderBean();
		
		//Case 2 - Affiliate 10% Discount and 5% on every $100 after discount
		// % Discount = 100, Balance 1900, 19*5=95, Net=1900-95=1805
		userVO.setBlnIsAffiliate(true);
		userVO.setBlnIsEmployee(false);
		userVO.getCartVO().setCartTotalAmount(2000);
		userVO.getCartVO().setGroceriesAmount(1000);

		double netPayableAmount = objPurchaseOrderBean.calculateNetPayableAmount(userVO);

		assertEquals(1805.0, netPayableAmount, 0.0);
		
	}
	
	@Test
	public void calculateNetPayableAmountForCsutomersMoreThanTwoYearsTest() {

		UserVO userVO = loadUser();
		
		PurchaseOrderBean objPurchaseOrderBean = new PurchaseOrderBean();
		
		//Case 3 - Customer for over 2 years, 5% Discount and 5% on every $100 after discount
		// % Discount = 50, Balance 1950, 19*5=95, Net=1950-95=1855
		userVO.setBlnIsAffiliate(false);
		userVO.setBlnIsEmployee(false);
		userVO.setStrUserStartDate("2015-10-10");
		userVO.getCartVO().setCartTotalAmount(2000);
		userVO.getCartVO().setGroceriesAmount(1000);

		double netPayableAmount = objPurchaseOrderBean.calculateNetPayableAmount(userVO);

		assertEquals(1855.0, netPayableAmount, 0.0);
		
	}
	@Test
	public void calculateNetPayableAmountForMoreThanHundredTest() {

		UserVO userVO = loadUser();
		
		PurchaseOrderBean objPurchaseOrderBean = new PurchaseOrderBean();
		
		//Case 4 - User has no percentage discount,
		//Total Amount 2000, 20*5=100, Net=2000-100=1900
		userVO.setBlnIsAffiliate(false);
		userVO.setBlnIsEmployee(false);
		userVO.setStrUserStartDate("2021-10-10");
		userVO.getCartVO().setCartTotalAmount(2000);
		userVO.getCartVO().setGroceriesAmount(1000);

		double netPayableAmount = objPurchaseOrderBean.calculateNetPayableAmount(userVO);

		assertEquals(1900.0, netPayableAmount, 0.0);
		
	}

	private UserVO loadUser() {
		
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
		cartVO.setGroceriesAmount(2000);
		cartVO.setCartTotalAmount(1000);
		return cartVO;
	}
}
