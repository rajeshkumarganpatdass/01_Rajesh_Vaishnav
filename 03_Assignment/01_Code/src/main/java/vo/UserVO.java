package main.java.vo;

public class UserVO {

	private String strUserId;
	
	private String strFirstName;
	
	private String strLastName;
	
	private boolean blnIsEmployee;
	
	private boolean blnIsAffiliate;
	
	private String strUserStartDate;
	
	private CartVO cartVO;

	public String getStrUserId() {
		return strUserId;
	}

	public void setStrUserId(String strUserId) {
		this.strUserId = strUserId;
	}

	public String getStrFirstName() {
		return strFirstName;
	}

	public void setStrFirstName(String strFirstName) {
		this.strFirstName = strFirstName;
	}

	public String getStrLastName() {
		return strLastName;
	}

	public void setStrLastName(String strLastName) {
		this.strLastName = strLastName;
	}

	public boolean isBlnIsEmployee() {
		return blnIsEmployee;
	}

	public void setBlnIsEmployee(boolean blnIsEmployee) {
		this.blnIsEmployee = blnIsEmployee;
	}

	public boolean isBlnIsAffiliate() {
		return blnIsAffiliate;
	}

	public void setBlnIsAffiliate(boolean blnIsAffiliate) {
		this.blnIsAffiliate = blnIsAffiliate;
	}

	public String getStrUserStartDate() {
		return strUserStartDate;
	}

	public void setStrUserStartDate(String strUserStartDate) {
		this.strUserStartDate = strUserStartDate;
	}

	public CartVO getCartVO() {
		return cartVO;
	}

	public void setCartVO(CartVO cartVO) {
		this.cartVO = cartVO;
	}

	
}
