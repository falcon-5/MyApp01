package com.example.onepiecegoodsmania;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.async.RakutenTask;
import com.example.data.RItem;
import com.example.image.ImageCache;

public class RSearchActivity extends ListActivity
{
	private RakutenTask mRakutenTask = null;
	private String mKeyword;

	private boolean atfirst = true;		//初回かどうか

	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.result_list);

		Bundle extras = getIntent().getExtras();
		if(extras != null)
		{
			if(extras.containsKey("keyword"))
			{
				mKeyword = extras.getString("keyword");
			}
		}
	}

	@Override
	protected void onResume()
	{
		super.onResume();

		ListView list = (ListView)findViewById(android.R.id.list);
		TextView txt = (TextView)findViewById(R.id.txtCount);
		if(this.atfirst)
		{
			mRakutenTask = new RakutenTask(this, list, txt);
			mRakutenTask.execute(Uri.encode(mKeyword, "1"));
		}
	}

	@Override
	protected void onPause()
	{
		super.onPause();

		if(mRakutenTask != null && !mRakutenTask.isCancelled())
		{
			mRakutenTask.cancel(true);
		}
	}

	@Override
	protected void onDestroy()
	{
		//TODO: 自動生成されたメソッド・スタブ
		super.onDestroy();
		//キャッシュ画像の解放
		ImageCache.clear();
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id)
	{
		super.onListItemClick(l, v, position, id);

		RItem item = (RItem)l.getItemAtPosition(position);
		if(item != null)
		{
			this.atfirst = false;

			String url = item.getAffiliateUrl();
			if(url.trim().length() > 0)
			{
				Intent intent = new Intent(Intent.ACTION_VIEW);
				intent.setData(Uri.parse(url));
				startActivity(intent);
			}
		}
	}

}
