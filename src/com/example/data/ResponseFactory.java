package com.example.data;

import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;

public class ResponseFactory extends BaseResponseFactory
{
	private Response mRes = null;
	private ArrayList<Item> mItems = new ArrayList<Item>();
	private Item mItem = null;

	@Override
	protected void onStartTag(XmlPullParser parser) throws Exception
	{
		String strName = parser.getName();
//		int iDepth = parser.getDepth();

		if(strName.equals("Response"))
		{
			mRes = new Response();
		}
		else if(strName.equals("Item"))
		{
			mItem = new Item();
		}
	}

	@Override
	protected void onEndTag(XmlPullParser parser)
	{
		String strName = parser.getName();
//		int iDepth = parser.getDepth();

		if(strName.equals("Response"))
		{
			mRes.setItem(mItems);
		}
		else if(strName.equals("count"))
		{
			mRes.setCount(convertInt(mText));
		}
		else if(strName.equals("page"))
		{
			mRes.setPage(convertInt(mText));
		}
		else if(strName.equals("first"))
		{
			mRes.setFirst(convertInt(mText));
		}
		else if(strName.equals("last"))
		{
			mRes.setLast(convertInt(mText));
		}
		else if(strName.equals("hits"))
		{
			mRes.setHits(convertInt(mText));
		}
		else if(strName.equals("carrier"))
		{
			mRes.setCarrier(convertInt(mText));
		}
		else if(strName.equals("Item"))
		{
			mItems.add(mItem);
			mItem = null;
		}
		else if(strName.equals("itemName"))
		{
			mItem.setItemName(mText);
		}
		else if(strName.equals("itemCode"))
		{
			mItem.setItemCode(mText);
		}
		else if(strName.equals("itemPrice"))
		{
			mItem.setItemPrice(mText + "円");
		}
		else if(strName.equals("itemCaption"))
		{
			mItem.setItemCaption(mText);
		}
		else if(strName.equals("affiliateUrl"))
		{
			mItem.setAffiliateUrl(mText);
		}
		else if(strName.equals("smallImageUrl"))
		{
			mItem.setSmallImageUrl(mText);
		}
		else if(strName.equals("mediumImageUrl"))
		{
			mItem.setMediumImageUrl(mText);
		}
		else if(strName.equals("availability"))
		{
			mItem.setAvailability(convertInt(mText));
			if(mItem.getAvailability() == 0)
			{
				mItem.setItemPrice("売り切れ");
			}
		}
		else if(strName.equals("taxFlag"))
		{
			mItem.setTaxFlag(convertInt(mText));
		}
		else if(strName.equals("postageFlag"))
		{
			mItem.setPostageFlag(convertInt(mText));
		}
		else if(strName.equals("creditCardFlag"))
		{
			mItem.setCreditCardFlag(convertInt(mText));
		}
		else if(strName.equals("startTime"))
		{
			mItem.setStartTime(mText);
		}
		else if(strName.equals("endTime"))
		{
			mItem.setEndTime(mText);
		}
		else if(strName.equals("reviewCount"))
		{
			mItem.setReviewCount(convertInt(mText));
		}
		else if(strName.equals("reviewAverage"))
		{
			mItem.setReviewAverage(convertDouble(mText));
		}
		else if(strName.equals("pointRate"))
		{
			mItem.setPointRate(convertInt(mText));
		}
		else if(strName.equals("shopName"))
		{
			mItem.setShopName(mText);
		}
	}

	@Override
	protected BaseData getResponse()
	{
		return mRes;
	}
}
