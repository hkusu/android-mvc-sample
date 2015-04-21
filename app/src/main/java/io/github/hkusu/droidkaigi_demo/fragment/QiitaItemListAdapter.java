package io.github.hkusu.droidkaigi_demo.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import io.github.hkusu.droidkaigi_demo.R;
import io.github.hkusu.droidkaigi_demo.model.QiitaItemEntity;

public class QiitaItemListAdapter extends ArrayAdapter<QiitaItemEntity> {

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private int mResource;

    // コンストラクタ
    public QiitaItemListAdapter(Context context, int resource, List<QiitaItemEntity> objects) {
        super(context, resource, objects);
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        mResource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView != null) {
            viewHolder = (ViewHolder) convertView.getTag();
        } else {
            convertView = mLayoutInflater.inflate(mResource, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }

        QiitaItemEntity qiitaItemEntity = getItem(position);

        Picasso.with(mContext)
                .load(qiitaItemEntity.user.profileImageUrl)
                .resize(100, 100)
                .centerCrop()
                .into(viewHolder.mProfileImageView);
        viewHolder.mTitleTextView.setText(qiitaItemEntity.title);

        return convertView;
    }

    static class ViewHolder {
        @InjectView(R.id.profileImageView)
        ImageView mProfileImageView;
        @InjectView(R.id.titleTextView)
        TextView mTitleTextView;

        ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}

