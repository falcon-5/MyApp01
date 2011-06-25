package com.example.async;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpStatus;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.TextView;

import com.example.adapter.ASearchListAdapter;
import com.example.data.AResponse;
import com.example.data.AResponseFactory;
import com.example.onepiecegoodsmania.R;
import com.example.web.SignedRequestsHelper;


public class AmazonTask extends AsyncTask<String, Void, Integer>
{
	private static final String P_SERVICE		 = "AWSECommerceService";
	private static final String P_VERSION		 = "2010-09-01";
	private static final String P_ACCESS_KEY	 = "AKIAIWZSOLGRZK3H5J5Q";
	private static final String P_OPERATION		 = "ItemSearch";
	private static final String P_RES_GROUP		 = "ItemAttributes,Images";
	private static final String P_SEARCH_IDX	 = "All";
	private static final String P_ASSOCIATE		 = "falcon50a-22";
	private static final String P_PAGE			 = "1";

	private Context mContext;
	private ProgressDialog mDialog = null;
	private ListView mList;
	private TextView mText;
	private AResponse mRes;

	public AmazonTask(Context context, ListView list, TextView txt)
	{
		mContext = context;
		mList = list;
		mText = txt;
	}

	@Override
	protected void onPreExecute()
	{
		super.onPreExecute();

		mDialog = new ProgressDialog(mContext);
		mDialog.setMessage(mContext.getString(R.string.dialog_receiving));
		mDialog.setIndeterminate(true);
		mDialog.show();
	}

	@Override
	protected Integer doInBackground(String... arg0)
	{
		//AmazonSignature処理
		Map<String, String> params = new HashMap<String, String>();
		params.put("Service", P_SERVICE);
		params.put("Version", P_VERSION);
		params.put("AWSAccessKeyId", P_ACCESS_KEY);
		params.put("Keywords", arg0[0]);
		params.put("Operation", P_OPERATION);
		params.put("ResponseGroup", P_RES_GROUP);
		params.put("SearchIndex", P_SEARCH_IDX);
		params.put("AssociateTag", P_ASSOCIATE);
		params.put("ItemPage", P_PAGE);
//		SignedRequestsHelper srh = new SignedRequestsHelper();
		SignedRequestsHelper srh = null;
		try{ srh = new SignedRequestsHelper(); }catch(Exception e){};
		String url = srh.sign(params);
//		String content = getContent(new URL(url));
		String content = null;
		try{ content = getContent(new URL(url)); }catch(Exception e){};

		int iRet = 0;
//		if(iRet == HttpStatus.SC_OK)
		if(content != null)
		{
			AResponseFactory factory = new AResponseFactory();
			mRes = (AResponse)factory.create(content);
			iRet = HttpStatus.SC_OK;
		}

		return new Integer(iRet);
	}

	@Override
	protected void onPostExecute(Integer result)
	{
		super.onPostExecute(result);

		if(result == HttpStatus.SC_OK)
		{
			//成功したのでデータを表示
			if(mRes != null)
			{
				ASearchListAdapter adapter = new ASearchListAdapter(mContext, mRes.getItem());
				mList.setAdapter(adapter);
				mText.setText(String.format("%d / %d" + mContext.getString(R.string.page_unit), mRes.getItemPage(), mRes.getTotalPages()));
			}
		}

		mDialog.dismiss();
	}

	// URLからコンテンツ(HTML/XMLページの文字列)を取得
	private static String getContent(URL url) throws Exception
	{
		HttpURLConnection con = (HttpURLConnection)url.openConnection();
		con.setRequestMethod("GET");
		InputStream is = con.getInputStream();
		InputStreamReader isr = new InputStreamReader(is, "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		StringBuffer buf = new StringBuffer();
		String s;
		while ((s = br.readLine()) != null)
		{
			buf.append(s);
			buf.append("\r\n");
		}

		br.close();
		con.disconnect();

		return buf.toString();
	}
}
