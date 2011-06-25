package com.example.data;

import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;

public class AResponseFactory extends BaseResponseFactory
{
	private AResponse mRes = null;
	private ArrayList<AItem> mAItems = new ArrayList<AItem>();
	private AItem mAItem = null;
	private ASmallImage mSmallImage = null;
	private AMediumImage mMediumImage = null;
	private boolean isSmallImage = false;
	private boolean isMediumImage = false;

	@Override
	protected void onStartTag(XmlPullParser parser) throws Exception
	{
		String strName = parser.getName();
		int iDepth = parser.getDepth();

		if(strName.equals("ItemSearchResponse"))
		{
			mRes = new AResponse();
		}
		//UAの取得 <Header Name="UserAgent" Value="UA"/>
		else if(strName.equals("Header") && getAttribute(parser, "Name").equals("UserAgent"))
		{
			mRes.setHeader(getAttribute(parser, "Value"));
		}
		else if(strName.equals("Item"))
		{
			mAItem = new AItem();
		}
		else if(strName.equals("SmallImage") && iDepth == 4)
		{
			mSmallImage = new ASmallImage();
			isSmallImage = true;
		}
		else if(strName.equals("MediumImage") && iDepth == 4)
		{
			mMediumImage = new AMediumImage();
			isMediumImage = true;
		}
	}

	@Override
	protected void onEndTag(XmlPullParser parser)
	{
		String strName = parser.getName();
		int iDepth = parser.getDepth();

		if(strName.equals("ItemSearchResponse"))
		{
			mRes.setItem(mAItems);
		}
		else if(strName.equals("Condition"))
		{
			mRes.setCondition(mText);
		}
		else if(strName.equals("DeliveryMethod"))
		{
			mRes.setDeliveryMethod(mText);
		}
		else if(strName.equals("ItemPage"))
		{
			mRes.setItemPage(convertInt(mText));
		}
		else if(strName.equals("ReviewSort"))
		{
			mRes.setReviewSort(mText);
		}
		else if(strName.equals("SearchIndex"))
		{
			mRes.setSearchIndex(mText);
		}
		else if(strName.equals("TotalResults"))
		{
			mRes.setItemPage(convertInt(mText));
		}
		else if(strName.equals("TotalPages"))
		{
			mRes.setItemPage(convertInt(mText));
		}
		else if(strName.equals("Item"))
		{
			mAItem.setASmallImage(mSmallImage);
			mAItem.setAMediumImage(mMediumImage);
			mAItems.add(mAItem);
			mAItem = null;
		}
		else if(strName.equals("ASIN"))
		{
			mAItem.setASIN(mText);
		}
		else if(strName.equals("DetailPageURL"))
		{
			mAItem.setDetailPageUrl(mText);
		}
		else if(strName.equals("SmallImage") && iDepth == 4)
		{
			isSmallImage = false;
		}
		else if(strName.equals("MediumImage") && iDepth == 4)
		{
			isMediumImage = false;
		}
		else if(strName.equals("URL") && iDepth == 5)
		{
			if(isSmallImage)
			{
				mSmallImage.setUrl(mText);
			}
			else if(isMediumImage)
			{
				mMediumImage.setUrl(mText);
			}
		}
		else if(strName.equals("Height") && iDepth == 5)
		{
			if(isSmallImage)
			{
				mSmallImage.setHeight(convertInt(mText));
			}
			else if(isMediumImage)
			{
				mMediumImage.setHeight(convertInt(mText));
			}
		}
		else if(strName.equals("Width") && iDepth == 5)
		{
			if(isSmallImage)
			{
				mSmallImage.setWidth(convertInt(mText));
			}
			else if(isMediumImage)
			{
				mMediumImage.setWidth(convertInt(mText));
			}
		}
		else if(strName.equals("Amount"))
		{
			mAItem.setAmount(convertInt(mText));
		}
		else if(strName.equals("Manufacturer"))
		{
			mAItem.setManufacturer(mText);
		}
		else if(strName.equals("Title"))
		{
			mAItem.setTitle(mText);
		}
		else if(strName.equals("ReleaseDate"))
		{
			mAItem.setReleaseDate(mText);
		}
	}

	@Override
	protected BaseData getResponse()
	{
		return mRes;
	}
}
