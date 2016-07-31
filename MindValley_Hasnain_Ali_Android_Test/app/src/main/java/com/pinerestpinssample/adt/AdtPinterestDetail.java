

package com.pinerestpinssample.adt;

import java.util.ArrayList;
import java.util.HashMap;
import android.content.Context;
import android.graphics.Color;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.pinerestpinssample.utils.MySingleton;
import com.pinerestpinssample.R;
import com.pinerestpinssample.utils.PinterestData;
import com.pinerestpinssample.utils.TeamUSANetworkImageView;

public class AdtPinterestDetail extends BaseAdapter {

	Context ctx;
	LayoutInflater lInflater = null;
	ArrayList<PinterestData> listPinterestPins;

	private ImageLoader imageLoader;


	public AdtPinterestDetail(Context context,
			ArrayList<PinterestData> listPin) {
		ctx = context;
		if (lInflater == null)
			lInflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		this.listPinterestPins = listPin;
	}

	@Override
	public int getCount() {
		return listPinterestPins.size();
	}

	private class ViewHolder {
		private TeamUSANetworkImageView nivItemPinUserImg;

		private TextView tvTitle;

	}

	@Override
	public Object getItem(int arg0) {
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		return 0;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {

		final ViewHolder viewHolder;
		View v = null;
		v = convertView;
		if (v == null)
			v = lInflater
					.inflate(R.layout.item_pinterest_detail, parent, false);
		if (imageLoader == null)
			imageLoader = MySingleton.getInstance(ctx).getImageLoader();
		viewHolder = new ViewHolder();

		viewHolder.nivItemPinUserImg = (TeamUSANetworkImageView) v
				.findViewById(R.id.nivItemPinUserImg);
		viewHolder.tvTitle = (TextView) v.findViewById(R.id.tvTitle);
		try {
			viewHolder.nivItemPinUserImg.SetLayoutParams(
					listPinterestPins.get(position).getWidth(),
					listPinterestPins.get(position).getHeight(
							));

		} catch (Exception e) {

		}

		try {
			viewHolder.nivItemPinUserImg.setBackgroundColor(listPinterestPins.get(position).getColor());
		} catch (Exception e) {
			e.printStackTrace();
		}

		viewHolder.nivItemPinUserImg.setImageUrl(listPinterestPins
				.get(position).getUrlsfull(), imageLoader);

		try {
			if (listPinterestPins.get(position).getname().length() > 2) {
			viewHolder.tvTitle.setText(Html.fromHtml(listPinterestPins.get(position).getname()));
			} else {
				viewHolder.tvTitle.setVisibility(View.GONE);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		v.setTag(viewHolder);
		return v;
	}

}