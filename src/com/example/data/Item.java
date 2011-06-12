package com.example.data;

public class Item extends BaseData
{
	private String itemName;
	private String itemCode;
	private String itemPrice;
	private String itemCaption;
	private String affiliateUrl;
	private String smallImageUrl;
	private String mediumImageUrl;
	private int availability;
	private int taxFlag;
	private int postageFlag;
	private int creditCardFlag;
	private String startTime;
	private String endTime;
	private int reviewCount;
	private double reviewAverage;
	private int pointRate;
	private String shopName;

	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}
	public String getItemCaption() {
		return itemCaption;
	}
	public void setItemCaption(String itemCaption) {
		this.itemCaption = itemCaption;
	}
	public String getAffiliateUrl() {
		return affiliateUrl;
	}
	public void setAffiliateUrl(String affiliateUrl) {
		this.affiliateUrl = affiliateUrl;
	}
	public String getSmallImageUrl() {
		return smallImageUrl;
	}
	public void setSmallImageUrl(String smallImageUrl) {
		this.smallImageUrl = smallImageUrl;
	}
	public String getMediumImageUrl() {
		return mediumImageUrl;
	}
	public void setMediumImageUrl(String mediumImageUrl) {
		this.mediumImageUrl = mediumImageUrl;
	}
	public int getAvailability() {
		return availability;
	}
	public void setAvailability(int availability) {
		this.availability = availability;
	}
	public int getTaxFlag() {
		return taxFlag;
	}
	public void setTaxFlag(int taxFlag) {
		this.taxFlag = taxFlag;
	}
	public int getPostageFlag() {
		return postageFlag;
	}
	public void setPostageFlag(int postageFlag) {
		this.postageFlag = postageFlag;
	}
	public int getCreditCardFlag() {
		return creditCardFlag;
	}
	public void setCreditCardFlag(int creditCardFlag) {
		this.creditCardFlag = creditCardFlag;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public int getReviewCount() {
		return reviewCount;
	}
	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
	}
	public double getReviewAverage() {
		return reviewAverage;
	}
	public void setReviewAverage(double reviewAverage) {
		this.reviewAverage = reviewAverage;
	}
	public int getPointRate() {
		return pointRate;
	}
	public void setPointRate(int pointRate) {
		this.pointRate = pointRate;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
}
