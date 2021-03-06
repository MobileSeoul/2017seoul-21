package com.seoulapp.findhiddenseoul.ListViewAdapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.seoulapp.findhiddenseoul.ListViewItem.ListViewItem;
import com.seoulapp.findhiddenseoul.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BANGYURA on 2017-10-25.
 */

public class ListViewAdapter1  extends BaseAdapter {
    Context context;
    private List<ListViewItem> list = null;
    private ArrayList<ListViewItem> listViewItemList = new ArrayList<ListViewItem>() ;

    @Override
    public int getCount() {
        return listViewItemList.size() ;
    }

    @Override
    public Object getItem(int position) {
        return listViewItemList.get(position) ;
    }

    @Override
    public long getItemId(int position) {
        return position ;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //final int pos = position;
        final Context context = parent.getContext();

        // "listview_item" Layout을 inflate하여 convertView 참조 획득.
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item1, parent, false);
        }

        // 화면에 표시될 View로부터 위젯에 대한 참조 획득
        ImageView mainImageView = (ImageView) convertView.findViewById(R.id.list_item1_iv_mainImg);

        TextView nameTextView = (TextView) convertView.findViewById(R.id.list_item1_tv_heritage_name);
        nameTextView.setTypeface(Typeface.createFromAsset(convertView.getContext().getAssets(), "fonts/NotoSansKR-Regular.mp3"));
        nameTextView.setIncludeFontPadding(false);
        nameTextView.setTextSize(25);

        TextView likesTextView = (TextView) convertView.findViewById(R.id.list_item1_tv_likes);
        likesTextView.setTypeface(Typeface.createFromAsset(convertView.getContext().getAssets(), "fonts/NotoSansKR-Medium.mp3"));
        likesTextView.setIncludeFontPadding(false);
        likesTextView.setTextSize(12);

        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        ListViewItem listViewItem = (ListViewItem) getItem(position);

        // 아이템 내 각 위젯에 데이터 반영
        Glide.with(context).load(listViewItem.getHeritage_mainImg()).bitmapTransform(new CenterCrop(context)).into(mainImageView);
        nameTextView.setText(listViewItem.getHeritage_name());
        likesTextView.setText(listViewItem.getLikes());

        return convertView;
    }

    public void addItem(String img, String name, String likes, String index) {
        ListViewItem item = new ListViewItem();

        item.setHeritage_mainImg(img);
        item.setHeritage_name(name);
        item.setLikes(likes);
        item.setHeritage_index(index);

        listViewItemList.add(item);

        //notifyDataSetChanged();
    }
}
