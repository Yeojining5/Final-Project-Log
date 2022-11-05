package kh.sellermoon.member.vo;

import lombok.Data;


public class CartVO {

	private String cartNo;
	private int memberNo;       
	private int    mdNo;    
	private int    cartQuantity;       
	private String orderType;
	public String getCartNo() {
		return cartNo;
	}
	public void setCartNo(String cartNo) {
		this.cartNo = cartNo;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public int getMdNo() {
		return mdNo;
	}
	public void setMdNo(int mdNo) {
		this.mdNo = mdNo;
	}
	public int getCartQuantity() {
		return cartQuantity;
	}
	public void setCartQuantity(int cartQuantity) {
		this.cartQuantity = cartQuantity;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	@Override
	public String toString() {
		return "CartVO [cartNo=" + cartNo + ", memberNo=" + memberNo + ", mdNo=" + mdNo + ", cartQuantity="
				+ cartQuantity + ", orderType=" + orderType + "]";
	}       
}
