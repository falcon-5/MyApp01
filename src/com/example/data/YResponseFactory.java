package com.example.data;

import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;

public class YResponseFactory extends BaseResponseFactory
{
	private YResponse mRes = null;
	private ArrayList<YItem> mItems = new ArrayList<YItem>();
	private YItem mItem = null;
	private ArrayList<YImage> mImages = null;
	private YImage mImage = null;
	private boolean mImageFlag = false;

	@Override
	protected void onStartTag(XmlPullParser parser) throws Exception
	{
		String strName = parser.getName();
//		int iDepth = parser.getDepth();

		if(strName.equals("channel"))
		{
			mRes = new YResponse();
		}
		else if(strName.equals("item"))
		{
			mItem = new YItem();
			mImages = new ArrayList<YImage>();
		}
		else if(strName.equals("image") && !getAttribute(parser, "class").equals("free"))
		{
			mImage = new YImage();
			mImage.setSize(getAttribute(parser, "class"));
			mImage.setUrl(getAttribute(parser, "url"));
			mImage.setHeight(convertInt(getAttribute(parser, "height")));
			mImage.setWidth(convertInt(getAttribute(parser, "width")));
			mImageFlag = true;
		}
	}

	@Override
	protected void onEndTag(XmlPullParser parser)
	{
		String strName = parser.getName();
		int iDepth = parser.getDepth();

		if(strName.equals("channel"))
		{
			mRes.setItem(mItems);
		}
		else if(strName.equals("resultPerPage"))
		{
			mRes.setResultPerPage(convertInt(mText));
		}
		else if(strName.equals("sortBy"))
		{
			mRes.setSortBy(mText);
		}
		else if(strName.equals("sortOrder"))
		{
			mRes.setSortOrder(mText);
		}
		else if(strName.equals("page"))
		{
			mRes.setPage(convertInt(mText));
		}
		else if(strName.equals("resultcount"))
		{
			mRes.setResultcount(convertInt(mText));
		}
		else if(strName.equals("pagecount"))
		{
			mRes.setPagecount(convertInt(mText));
		}
		else if(strName.equals("item"))
		{
			mItem.setImage(mImages);
			mImages = null;
			mItems.add(mItem);
			mItem = null;
		}
		else if(strName.equals("title") && iDepth == 4)
		{
			mItem.setTitle(mText);
		}
		else if(strName.equals("link") && iDepth == 4)
		{
			mItem.setLink(mText);
		}
		else if(strName.equals("description") && iDepth == 4)
		{
			mItem.setDescription(mText);
		}
		else if(strName.equals("subStoreName"))
		{
			mItem.setSubStoreName(mText);
		}
		else if(strName.equals("startdate"))
		{
			mItem.setStartdate(convertInt(mText));
		}
		else if(strName.equals("category"))
		{
			mItem.setCategory(mText);
		}
		else if(strName.equals("image") && mImageFlag == true)
		{
			mImages.add(mImage);
			mImage = null;
			mImageFlag = false;
		}
		else if(strName.equals("price"))
		{
			mItem.setPrice(mText + "円");
		}
		//画像に紐付ける固有IDを生成（subStoreId + janCode）
		else if(strName.equals("subStoreId"))
		{
			mItem.setItem_id(mText + mItem.getItem_id());
		}
		else if(strName.equals("janCode"))
		{
			mItem.setItem_id(mText);
		}
	}

	@Override
	protected BaseData getResponse()
	{
		return mRes;
	}
}
