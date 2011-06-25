package com.example.onepiecegoodsmania;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import android.widget.TextView;

import com.example.async.AmazonTask;
import com.example.data.AItem;
import com.example.image.ImageCache;

public class ASearchActivity extends ListActivity
	implements OnScrollListener
{
	private AmazonTask mAmazonTask = null;
	private String mKeyword;

	/** ListViewのフッタ */
	private View mFooter;
	/** 追加読み込みの最大回数 */
	private final static int MAX_COUNT = 5;
	/** 追加読み込み回数 */
	private int mCount = 0;

//	private int _position = 0;			//ListViewスクロール位置
	/* 位置を記憶するより初回以外受信処理を行わせない方が良い感じ。。。 */
	private boolean atfirst = true;		//初回かどうか

	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.result_list);

		//Listを最下部までスクロールした時プログレッシブを表示
		ListView listView = getListView();
		listView.addFooterView(getFooter());
		listView.setAdapter(getListAdapter());
		listView.setOnScrollListener(this);

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
//		if(this._position == 0)
		if(this.atfirst)
		{
			mAmazonTask = new AmazonTask(this, list, txt);
			mAmazonTask.execute(mKeyword, "1");
		}
/*
		else
		{
			//記録したListViewの表示位置をセット
			list.setSelection(this._position);
		}
*/
	}

	@Override
	protected void onPause()
	{
		super.onPause();

		if(mAmazonTask != null && !mAmazonTask.isCancelled())
		{
			mAmazonTask.cancel(true);
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

		AItem item = (AItem)l.getItemAtPosition(position);
		if(item != null)
		{
			//ListViewの表示位置を記憶
//			this._position = l.getFirstVisiblePosition();
			this.atfirst = false;

			String url = item.getDetailPageUrl();
			if(url.trim().length() > 0)
			{
				Intent intent = new Intent(Intent.ACTION_VIEW);
				intent.setData(Uri.parse(url));
				startActivity(intent);
			}
		}
	}

	private View getFooter()
	{
		if(mFooter == null)
		{
			mFooter = getLayoutInflater().inflate(R.layout.result_list_footer, null);
		}
		return mFooter;
	}

	@Override
	//ListView最後尾までスクロールしたかの判定
	public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount)
	{
		if(totalItemCount == firstVisibleItem + visibleItemCount)
		{
			additionalReading();
		}
	}

	private void additionalReading()
	{
		//読み込み回数が最大値以上ならスキップ。フッタを消す
		if(mCount >= MAX_COUNT)
		{
			invisibleFooter();
			return;
		}
		// 既に読み込み中ならスキップ
		if (mAmazonTask != null && mAmazonTask.getStatus() == AmazonTask.Status.RUNNING)
		{
			return;
		}
		ListView list = (ListView)findViewById(android.R.id.list);
		TextView txt = (TextView)findViewById(R.id.txtCount);

		mAmazonTask = new AmazonTask(this, list, txt);
	}

	private void invisibleFooter()
	{
		getListView().removeFooterView(getFooter());
	}

	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState)
	{

	}
}
