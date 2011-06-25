package com.example.async;

import org.apache.http.HttpStatus;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.TextView;

import com.example.adapter.YSearchListAdapter;
import com.example.data.YResponse;
import com.example.data.YResponseFactory;
import com.example.onepiecegoodsmania.R;
import com.example.web.HttpServerIF;


public class YahooTask extends AsyncTask<String, Void, Integer>
{
	private static final String YAHOO_URL = "http://webservice.valuecommerce.ne.jp/productdb/search?";
	private static final String PARAMS = "token=1-1ec9c02d2f8866fb86bf313125f95307&results_per_page=50&sort_by=price&sort_order=asc&page=1&adult=n&format=RSS&";
//	private static final String TOKEN = "1-1ec9c02d2f8866fb86bf313125f95307";

	private Context mContext;
	private ProgressDialog mDialog = null;
	private ListView mList;
	private TextView mText;
	private YResponse mRes;

	public YahooTask(Context context, ListView list, TextView txt)
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
		int iRet = svr.requestText(YAHOO_URL + PARAMS + "&keyword=" + arg0[0]);

		if(iRet == HttpStatus.SC_OK)
		{
			YResponseFactory factory = new YResponseFactory();
			mRes = (YResponse)factory.create(svr.getResText());
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
				YSearchListAdapter adapter = new YSearchListAdapter(mContext, mRes.getItem());
				mList.setAdapter(adapter);
				mText.setText(String.format("%d / %d" + mContext.getString(R.string.page_unit), mRes.getResultPerPage(), mRes.getResultcount()));
			}
		}

		mDialog.dismiss();
	}

}
