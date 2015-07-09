package io.github.hkusu.android_mvc_sample.viewController;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnItemClick;
import de.greenrobot.event.EventBus;
import io.github.hkusu.android_mvc_sample.R;
import io.github.hkusu.android_mvc_sample.common.Const;
import io.github.hkusu.android_mvc_sample.common.FragmentRouter;
import io.github.hkusu.android_mvc_sample.common.ModeLocator;
import io.github.hkusu.android_mvc_sample.model.QiitaItemEntity;
import io.github.hkusu.android_mvc_sample.model.QiitaItemModel;

public class ListFragment extends Fragment {

    @InjectView(R.id.itemCountTextView)
    TextView mItemCountTextView;
    @InjectView(R.id.qiitaItemListView)
    ListView mQiitaItemListView;

    private final List<QiitaItemEntity> mQiitaItemList = new ArrayList<>();
    private QiitaItemListAdapter mQiitaItemListAdapter;

    public ListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //if (getArguments() != null) {
        //    //引数があれば受け取り
        //}
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        ButterKnife.inject(this, view); // ButterKnife
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mQiitaItemListAdapter = new QiitaItemListAdapter(
                getActivity(),
                R.layout.adapter_qiita_item_list,
                mQiitaItemList
        );
        mQiitaItemListView.setAdapter(mQiitaItemListAdapter);
    }

    @Override
    public void onStart() {
        super.onStart();
        ((QiitaItemModel) ModeLocator.get(ModeLocator.Tag.QIITA_ITEM)).load();
        updateView();
    }

    @Override
    public void onResume() {
        super.onResume();
        EventBus.getDefault().register(this); // EventBus
    }

    @Override
    public void onPause() {
        super.onPause();
        EventBus.getDefault().unregister(this); // EventBus
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this); // ButterKnife
    }

    // ListView 中の項目選択
    @SuppressWarnings("unused")
    @OnItemClick(R.id.qiitaItemListView)
    public void onItemClickQiitaItemListView(int position) {
        Bundle args = new Bundle();
        args.putString(Const.BundleKey.URL.toString(), mQiitaItemList.get(position).url);
        FragmentRouter.replace(getActivity(), R.id.container, FragmentRouter.Tag.DETAIL, args, FragmentRouter.Animation.SLIDE_IN_BOTTOM);
    }

    // EventBus からの通知
    @SuppressWarnings("unused")
    public void onEventMainThread(QiitaItemModel.QiitaItemLoadedEvent event) {
        if (event.isSuccess()) {
            updateView();
        }
    }

    // Viewの表示を更新するプライベートメソッド
    private void updateView() {
        // ここでは通信が伴うような時間がかかる処理はしない。Model上の変数をアクセスするに留める
        mItemCountTextView.setText(((QiitaItemModel) ModeLocator.get(ModeLocator.Tag.QIITA_ITEM)).getItemCount() + " 件");
        mQiitaItemList.clear();
        mQiitaItemList.addAll(((QiitaItemModel) ModeLocator.get(ModeLocator.Tag.QIITA_ITEM)).getItemList());
        mQiitaItemListAdapter.notifyDataSetChanged();
    }
}
