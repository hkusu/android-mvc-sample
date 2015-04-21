package io.github.hkusu.android_mvc_sample;

import android.app.Application;

import io.github.hkusu.android_mvc_sample.common.FragmentManager;
import io.github.hkusu.android_mvc_sample.common.ModelManager;
import io.github.hkusu.android_mvc_sample.viewController.DetailFragment;
import io.github.hkusu.android_mvc_sample.viewController.ListFragment;
import io.github.hkusu.android_mvc_sample.model.QiitaItemModel;

public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // ModelManager に各モデルの参照を登録
        ModelManager.register(ModelManager.Tag.QIITA_ITEM, new QiitaItemModel());

        // FragmentManager に各Fragmentのクラス名を登録(ここではインスタンス化しない)
        FragmentManager.register(FragmentManager.Tag.LIST, ListFragment.class);
        FragmentManager.register(FragmentManager.Tag.DETAIL, DetailFragment.class);

        // ObjectManager を利用すると、任意のインスタンスの参照を保持できる。どこからでも利用可
        //ObjectManager.register("hoge", "あああ");
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
