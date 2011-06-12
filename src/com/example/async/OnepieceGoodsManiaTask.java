package com.example.async;

import org.apache.http.HttpStatus;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.TextView;

import com.example.adapter.SearchListAdapter;
import com.example.data.Response;
import com.example.data.ResponseFactory;
import com.example.onepiecegoodsmania.R;
import com.example.web.HttpServerIF;


public class OnepieceGoodsManiaTask extends AsyncTask<String, Void, Integer>
{
	private static final String RAKUTEN_URL = "http://api.rakuten.co.jp/rws/3.0/rest?";
	private static final String PARAMS = "developerId=23fbc6f126f1ff79ada3c02e4c2caa1e&affiliateId=0cb7b7d1.560a6e44.0cb7b7d2.99967fa5&operation=ItemSearch&version=2010-08-05&hits=30&page=1&availability=0&sort=%2BitemPrice&NGKeyword=showtime";
//	private static final String DEV_ID = "23fbc6f126f1ff79ada3c02e4c2caa1e";
//	private static final String AFF_ID = "0cb7b7d1.560a6e44.0cb7b7d2.99967fa5";

	private Context mContext;
	private ProgressDialog mDialog = null;
	private ListView mList;
	private TextView mText;
	private Response mRes;

	public OnepieceGoodsManiaTask(Context context, ListView list, TextView txt)
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
		HttpServerIF svr = new HttpServerIF();
		int iRet = svr.requestText(RAKUTEN_URL + PARAMS + arg0[1] + "&keyword=" + arg0[0]);

		if(iRet == HttpStatus.SC_OK)
		{
			ResponseFactory factory = new ResponseFactory();
			mRes = (Response)factory.create(svr.getResText());
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
				SearchListAdapter adapter = new SearchListAdapter(mContext, mRes.getItem());
				mList.setAdapter(adapter);
				mText.setText(String.format("%d / %d" + mContext.getString(R.string.page_unit), mRes.getHits(), mRes.getCount()));
			}
		}

		mDialog.dismiss();
	}

}
