package com.example.data;


public class AItem extends BaseData
{
	private String ASIN;			//固有コード？
	private String DetailPageUrl;
	private ASmallImage ASmallImage;
	private AMediumImage AMediumImage;
	private int Amount;
	private String Manufacturer;
	private String Title;
	private String ReleaseDate;

	public String getASIN() {
		return ASIN;
	}
	public void setASIN(String aSIN) {
		ASIN = aSIN;
	}
	public String getDetailPageUrl() {
		return DetailPageUrl;
	}
	public void setDetailPageUrl(String detailPageUrl) {
		DetailPageUrl = detailPageUrl;
	}
	public ASmallImage getASmallImage() {
		return ASmallImage;
	}
	public void setASmallImage(ASmallImage aSmallImage) {
		ASmallImage = aSmallImage;
	}
	public AMediumImage getAMediumImage() {
		return AMediumImage;
	}
	public void setAMediumImage(AMediumImage aMediumImage) {
		AMediumImage = aMediumImage;
	}
	public int getAmount() {
		return Amount;
	}
	public void setAmount(int amount) {
		Amount = amount;
	}
	public String getManufacturer() {
		return Manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		Manufacturer = manufacturer;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getReleaseDate() {
		return ReleaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		ReleaseDate = releaseDate;
	}
}
