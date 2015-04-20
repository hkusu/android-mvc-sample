package io.github.hkusu.droidkaigi_demo.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import de.greenrobot.event.EventBus;
import io.github.hkusu.droidkaigi_demo.R;
import io.github.hkusu.droidkaigi_demo.common.ModelList;
import io.github.hkusu.droidkaigi_demo.entity.QiitaItemEntity;
import io.github.hkusu.droidkaigi_demo.common.ModelManager;
import io.github.hkusu.droidkaigi_demo.event.QiitaItemLoadedEvent;
import io.github.hkusu.droidkaigi_demo.model.QiitaItemModel;

public class ListFragment extends Fragment {

    @InjectView(R.id.button)
    Button mButton;

    public ListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            //引数があれば受け取り
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.f_main, container, false);
        ButterKnife.inject(this, view); // ButterKnife
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        //((QiitaItemModel)ModelManager.getInstance().get(ModelManager.Tag.QIITA_ITEM)).load();
        ((QiitaItemModel)ModelManager.get(ModelList.QIITA_ITEM)).load();

        updateView();
        //String string = (String) ObjectManager.getInstance().get("hoge");
        //Toast.makeText(getActivity(), string, Toast.LENGTH_SHORT).show();
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

    // ボタンクリック
    @SuppressWarnings("unused")
    @OnClick(R.id.button)
    public void onClickButton(View view) {
    }

    // EventBus からの通知
    @SuppressWarnings("unused")
    public void onEventMainThread(QiitaItemLoadedEvent event) {
        if (event.isSuccess()) {
            updateView();
        }
    }

    private void updateView() {

        //List<QiitaItemEntity> list = ((QiitaItemModel)ModelManager.getInstance().get(ModelManager.Tag.QIITA_ITEM)).get();
        List<QiitaItemEntity> list = ((QiitaItemModel)ModelManager.get(ModelList.QIITA_ITEM)).get();

        for (QiitaItemEntity qiitaItemEntity : list) {
            Log.i("qiita", "id=" + qiitaItemEntity.id
                            + " uuid=" + qiitaItemEntity.uuid
                            + " title=" + qiitaItemEntity.title
                            + " url=" + qiitaItemEntity.url
                            + " userId=" + qiitaItemEntity.userId
                            + " usrUrlName=" + qiitaItemEntity.userUrlName
                            + " userProfileImageUrl=" + qiitaItemEntity.userProfileImageUrl
            );
        }

        //TODO TextVeiwとadapterの更新
        //mFloorListAdapter.notifyDataSetChanged();
    }
}

//TODO Adapter(別ファイル)、独自リスナクラス
