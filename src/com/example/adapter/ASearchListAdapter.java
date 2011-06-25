package com.example.adapter;

import java.util.List;

import android.content.Context;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.async.ThumbnailTask;
import com.example.data.AItem;
import com.example.image.ImageCache;
import com.example.onepiecegoodsmania.R;

public class ASearchListAdapter extends ArrayAdapter<AItem>
{
	private LayoutInflater mInflater;

	public ASearchListAdapter(Context context, List<AItem> objects)
	{
		this(context, 0, objects);
	}

	public ASearchListAdapter(Context context, int textViewResourceId, List<AItem> objects)
	{
		super(context, textViewResourceId, objects);
		mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		ViewHolder holder = new ViewHolder();

		AItem item = this.getItem(position);
		if(convertView == null)
		{
			convertView = mInflater.inflate(R.layout.result_list_layout, null);

			holder.image = (ImageView)convertView.findViewById(R.id.imgThumbnail);
			holder.txt_title = (TextView)convertView.findViewById(R.id.txt_Title);
			holder.txt_price = (TextView)convertView.findViewById(R.id.txt_price);
			holder.txt_shop = (TextView)convertView.findViewById(R.id.txt_shop);

			convertView.setTag(holder);
		}
		else
		{
			holder = (ViewHolder)convertView.getTag();
		}

		if(item != null)
		{
			holder.txt_title.setText(item.getTitle());
			holder.txt_price.setText(item.getAmount() + "円");
			holder.txt_shop.setText(item.getManufacturer());
			if(ImageCache.getImage(item.getASIN()) == null)
			{
				if(item.getASmallImage().getUrl() != null)
				{
					if(item.getASmallImage().getUrl().length() > 0 && holder.task == null)
					{
						holder.task = new ThumbnailTask(holder.image);
						holder.task.execute(item.getASmallImage().getUrl(), item.getASIN());
					}
					else
					{
						holder.image.setImageBitmap(null);

						//受信処理は完了しているが、受信が失敗した場合
						if(holder.task.getStatus() == AsyncTask.Status.FINISHED)
						{
							//再度リクエストする
							holder.task = new ThumbnailTask(holder.image);
							holder.task.execute(item.getASmallImage().getUrl(), item.getASIN());
						}
					}
				}
			}
			else
			{
				holder.image.setImageBitmap(ImageCache.getImage(item.getASIN()));
			}
		}
		return convertView;
	}

	class ViewHolder
	{
		ImageView image;
		TextView txt_title;
		TextView txt_price;
		TextView txt_shop;
		ThumbnailTask task;
	}
}
