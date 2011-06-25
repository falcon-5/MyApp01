package com.example.data;

import java.util.ArrayList;

public class YItem extends BaseData
{
	private String title;
	private String link;
	private String description;
//	private String guid;			//商品URL
//	private String pvImg;
//	private String ecCode;
//	private int janCode;
//	private String subStoreId;
	private String subStoreName;
	private int startdate;			//YYYYMMDD
	private String category;		//a,b,c
	private ArrayList<YImage> image;
	private String price;
	private String item_id;			//画像に紐付ける固有IDを生成（subStoreId + janCode）

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSubStoreName() {
		return subStoreName;
	}
	public void setSubStoreName(String subStoreName) {
		this.subStoreName = subStoreName;
	}
	public int getStartdate() {
		return startdate;
	}
	public void setStartdate(int startdate) {
		this.startdate = startdate;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public ArrayList<YImage> getImage() {
		return image;
	}
	public void setImage(ArrayList<YImage> image) {
		this.image = image;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getItem_id() {
		return item_id;
	}
	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}
}
