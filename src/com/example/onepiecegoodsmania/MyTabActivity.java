package com.example.onepiecegoodsmania;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class MyTabActivity extends TabActivity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //TabHostインスタンスを取得
        TabHost tabHost = getTabHost();

        //LayoutInflaterインスタンスを取得
        LayoutInflater inflater = getLayoutInflater();

        //tabHostを取得してresult_list.xmlレイアウト読み込み
        inflater.inflate(R.layout.result_list, tabHost.getTabContentView(), true);

        //キーワードを取得
        String strKeyword = "";
        Bundle extras = getIntent().getExtras();
		if(extras != null)
		{
			if(extras.containsKey("keyword"))
			{
				strKeyword = extras.getString("keyword");
			}
		}

        //1つめのタブを生成
        TabSpec tab1 = tabHost.newTabSpec("tab1");
        tab1.setIndicator("Amazon");

		//結果表示画面を起動
		Intent intent1 = new Intent(this, ASearchActivity.class);
		intent1.putExtra("keyword", strKeyword);
//		startActivity(intent);
        tab1.setContent(intent1);

        //2つめのタブを生成
        TabSpec tab2 = tabHost.newTabSpec("tab2");
        tab2.setIndicator("Rakuten");

		//結果表示画面を起動
		Intent intent2 = new Intent(this, RSearchActivity.class);
		intent2.putExtra("keyword", strKeyword);
//		startActivity(intent);
        tab2.setContent(intent2);

        //3つめのタブを生成
        TabSpec tab3 = tabHost.newTabSpec("tab3");
        tab3.setIndicator("Yahoo!");

		//結果表示画面を起動
		Intent intent3 = new Intent(this, YSearchActivity.class);
		intent3.putExtra("keyword", strKeyword);
//		startActivity(intent);
        tab3.setContent(intent3);

        //tabHostに生成したタブを追加
        tabHost.addTab(tab1);
        tabHost.addTab(tab2);
        tabHost.addTab(tab3);
    }
}