package com.example.data;

import java.util.ArrayList;

public class YResponse extends BaseData
{
	private int resultPerPage;
	private String sortBy;
	private String sortOrder;
	private int page;
	private int resultcount;
	private int pagecount;
	private ArrayList<YItem> item;

	public int getResultPerPage() {
		return resultPerPage;
	}
	public void setResultPerPage(int resultPerPage) {
		this.resultPerPage = resultPerPage;
	}
	public String getSortBy() {
		return sortBy;
	}
	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}
	public String getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getResultcount() {
		return resultcount;
	}
	public void setResultcount(int resultcount) {
		this.resultcount = resultcount;
	}
	public int getPagecount() {
		return pagecount;
	}
	public void setPagecount(int pagecount) {
		this.pagecount = pagecount;
	}
	public ArrayList<YItem> getItem() {
		return item;
	}
	public void setItem(ArrayList<YItem> item) {
		this.item = item;
	}
}
