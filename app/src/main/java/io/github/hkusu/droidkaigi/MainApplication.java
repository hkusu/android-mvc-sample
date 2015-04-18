package io.github.hkusu.droidkaigi;

import android.app.Application;

import de.greenrobot.event.EventBus;
import io.github.hkusu.droidkaigi.common.ModelManager;
import io.github.hkusu.droidkaigi.common.ObjectManager;
import io.github.hkusu.droidkaigi.model.QiitaNewPostModel;

public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ModelManager modelManager = ModelManager.getInstance();
        modelManager.register(ModelManager.Tag.QIITA_NEW_POST, new QiitaNewPostModel(EventBus.getDefault()));

        ObjectManager objectManager = ObjectManager.getInstance();
        objectManager.register("hoge", "あああ");
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
