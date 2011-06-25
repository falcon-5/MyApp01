package com.example.data;

import java.util.ArrayList;

public class RResponse extends BaseData
{
	private int count;
	private int page;
	private int first;
	private int last;
	private int hits;
	private int carrier;
	private int pageCount;
	private ArrayList<RItem> item;

	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getFirst() {
		return first;
	}
	public void setFirst(int first) {
		this.first = first;
	}
	public int getLast() {
		return last;
	}
	public void setLast(int last) {
		this.last = last;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public int getCarrier() {
		return carrier;
	}
	public void setCarrier(int carrier) {
		this.carrier = carrier;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public ArrayList<RItem> getItem() {
		return item;
	}
	public void setItem(ArrayList<RItem> item) {
		this.item = item;
	}
}
