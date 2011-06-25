package com.example.data;

import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;

public class RResponseFactory extends BaseResponseFactory
{
	private RResponse mRes = null;
	private ArrayList<RItem> mRItems = new ArrayList<RItem>();
	private RItem mRItem = null;

	@Override
	protected void onStartTag(XmlPullParser parser) throws Exception
	{
		String strName = parser.getName();
//		int iDepth = parser.getDepth();

		if(strName.equals("Response"))
		{
			mRes = new RResponse();
		}
		else if(strName.equals("Item"))
		{
			mRItem = new RItem();
		}
	}

	@Override
	protected void onEndTag(XmlPullParser parser)
	{
		String strName = parser.getName();
//		int iDepth = parser.getDepth();

		if(strName.equals("Response"))
		{
			mRes.setItem(mRItems);
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
			mRItems.add(mRItem);
			mRItem = null;
		}
		else if(strName.equals("itemName"))
		{
			mRItem.setItemName(mText);
		}
		else if(strName.equals("itemCode"))
		{
			mRItem.setItemCode(mText);
		}
		else if(strName.equals("itemPrice"))
		{
			mRItem.setItemPrice(mText + "円");
		}
		else if(strName.equals("itemCaption"))
		{
			mRItem.setItemCaption(mText);
		}
		else if(strName.equals("affiliateUrl"))
		{
			mRItem.setAffiliateUrl(mText);
		}
		else if(strName.equals("smallImageUrl"))
		{
			mRItem.setSmallImageUrl(mText);
		}
		else if(strName.equals("mediumImageUrl"))
		{
			mRItem.setMediumImageUrl(mText);
		}
		else if(strName.equals("availability"))
		{
			mRItem.setAvailability(convertInt(mText));
			if(mRItem.getAvailability() == 0)
			{
				mRItem.setItemPrice("売り切れ");
			}
		}
		else if(strName.equals("taxFlag"))
		{
			mRItem.setTaxFlag(convertInt(mText));
		}
		else if(strName.equals("postageFlag"))
		{
			mRItem.setPostageFlag(convertInt(mText));
		}
		else if(strName.equals("creditCardFlag"))
		{
			mRItem.setCreditCardFlag(convertInt(mText));
		}
		else if(strName.equals("startTime"))
		{
			mRItem.setStartTime(mText);
		}
		else if(strName.equals("endTime"))
		{
			mRItem.setEndTime(mText);
		}
		else if(strName.equals("reviewCount"))
		{
			mRItem.setReviewCount(convertInt(mText));
		}
		else if(strName.equals("reviewAverage"))
		{
			mRItem.setReviewAverage(convertDouble(mText));
		}
		else if(strName.equals("pointRate"))
		{
			mRItem.setPointRate(convertInt(mText));
		}
		else if(strName.equals("shopName"))
		{
			mRItem.setShopName(mText);
		}
	}

	@Override
	protected BaseData getResponse()
	{
		return mRes;
	}
}
