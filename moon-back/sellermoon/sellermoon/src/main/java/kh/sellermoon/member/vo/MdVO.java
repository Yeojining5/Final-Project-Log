package kh.sellermoon.member.vo;

import lombok.Data;

@Data
public class MdVO {

	private int mdNo;
	private String mdContent;
	private int mdPrice;       
	private String mdCategory;
	private String mdImage;      
	private String mdDetailImage;
	private int    mdDiscount;    
	private int    mdCost;       
	private String mdBrand;       
	private String mdName;
	private String mdImageUrl;
	private String mdDetailImageUrl;
	private int stAmout;
	
	public int getMdNo() {
		return mdNo;
	}
	public void setMdNo(int mdNo) {
		this.mdNo = mdNo;
	}
	public String getMdContent() {
		return mdContent;
	}
	public void setMdContent(String mdContent) {
		this.mdContent = mdContent;
	}
	public int getMdPrice() {
		return mdPrice;
	}
	public void setMdPrice(int mdPrice) {
		this.mdPrice = mdPrice;
	}
	public String getMdCategory() {
		return mdCategory;
	}
	public void setMdCategory(String mdCategory) {
		this.mdCategory = mdCategory;
	}
	public String getMdImage() {
		return mdImage;
	}
	public void setMdImage(String mdImage) {
		this.mdImage = mdImage;
	}
	
	public int getMdDiscount() {
		return mdDiscount;
	}
	public void setMdDiscount(int mdDiscount) {
		this.mdDiscount = mdDiscount;
	}
	public int getMdCost() {
		return mdCost;
	}
	public void setMdCost(int mdCost) {
		this.mdCost = mdCost;
	}
	public String getMdBrand() {
		return mdBrand;
	}
	public void setMdBrand(String mdBrand) {
		this.mdBrand = mdBrand;
	}
	public String getMdName() {
		return mdName;
	}
	public void setMdName(String mdName) {
		this.mdName = mdName;
	}
	public String getMdDetailImage() {
		return mdDetailImage;
	}
	public void setMdDetailImage(String mdDetailImage) {
		this.mdDetailImage = mdDetailImage;
	}
	public String getMdImageUrl() {
		return mdImageUrl;
	}
	public void setMdImageUrl(String mdImageUrl) {
		this.mdImageUrl = mdImageUrl;
	}
	public String getMdDetailImageUrl() {
		return mdDetailImageUrl;
	}
	public void setMdDetailImageUrl(String mdDetailImageUrl) {
		this.mdDetailImageUrl = mdDetailImageUrl;
	}
	public int getStAmout() {
		return stAmout;
	}
	public void setStAmout(int stAmout) {
		this.stAmout = stAmout;
	}
	@Override
	public String toString() {
		return "MdVO [mdNo=" + mdNo + ", mdContent=" + mdContent + ", mdPrice=" + mdPrice + ", mdCategory=" + mdCategory
				+ ", mdImage=" + mdImage + ", mdDetailImage=" + mdDetailImage + ", mdDiscount=" + mdDiscount
				+ ", mdCost=" + mdCost + ", mdBrand=" + mdBrand + ", mdName=" + mdName + ", mdImageUrl=" + mdImageUrl
				+ ", mdDetailImageUrl=" + mdDetailImageUrl + ", stAmout=" + stAmout + "]";
	}
	
	
}
