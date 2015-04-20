package io.github.hkusu.droidkaigi_demo;

import android.app.Application;

import io.github.hkusu.droidkaigi_demo.common.FragmentList;
import io.github.hkusu.droidkaigi_demo.common.FragmentManager;
import io.github.hkusu.droidkaigi_demo.common.ModelList;
import io.github.hkusu.droidkaigi_demo.common.ModelManager;
import io.github.hkusu.droidkaigi_demo.common.ObjectManager;
import io.github.hkusu.droidkaigi_demo.fragment.ListFragment;
import io.github.hkusu.droidkaigi_demo.model.QiitaItemModel;

public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ModelManager.register(ModelList.QIITA_ITEM, new QiitaItemModel());

        ObjectManager.register("hoge", "あああ");

        FragmentManager.register(FragmentList.LIST, ListFragment.class);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
