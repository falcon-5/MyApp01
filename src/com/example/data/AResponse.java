package com.example.data;

import java.util.ArrayList;

public class AResponse extends BaseData
{
	private String Header;

	private String Condition;
	private String DeliveryMethod;
	private int ItemPage;
	private String ReviewSort;
	private String SearchIndex;

	private int TotalResults;
	private int TotalPages;

	private ArrayList<AItem> item;

	public String getHeader() {
		return Header;
	}
	public void setHeader(String header) {
		Header = header;
	}
	public String getCondition() {
		return Condition;
	}
	public void setCondition(String condition) {
		Condition = condition;
	}
	public String getDeliveryMethod() {
		return DeliveryMethod;
	}
	public void setDeliveryMethod(String deliveryMethod) {
		DeliveryMethod = deliveryMethod;
	}
	public int getItemPage() {
		return ItemPage;
	}
	public void setItemPage(int itemPage) {
		ItemPage = itemPage;
	}
	public String getReviewSort() {
		return ReviewSort;
	}
	public void setReviewSort(String reviewSort) {
		ReviewSort = reviewSort;
	}
	public String getSearchIndex() {
		return SearchIndex;
	}
	public void setSearchIndex(String searchIndex) {
		SearchIndex = searchIndex;
	}
	public int getTotalResults() {
		return TotalResults;
	}
	public void setTotalResults(int totalResults) {
		TotalResults = totalResults;
	}
	public int getTotalPages() {
		return TotalPages;
	}
	public void setTotalPages(int totalPages) {
		TotalPages = totalPages;
	}
	public ArrayList<AItem> getItem() {
		return item;
	}
	public void setItem(ArrayList<AItem> item) {
		this.item = item;
	}
}
