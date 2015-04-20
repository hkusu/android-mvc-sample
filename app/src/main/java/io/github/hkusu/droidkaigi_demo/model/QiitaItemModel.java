package io.github.hkusu.droidkaigi_demo.model;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;
import io.github.hkusu.droidkaigi_demo.api.HogeAsyncTask;
import io.github.hkusu.droidkaigi_demo.entity.QiitaItemEntity;
import io.github.hkusu.droidkaigi_demo.event.QiitaItemLoadedEvent;

public class QiitaItemModel {

    private final EventBus mEventBus;
    private List<QiitaItemEntity> mQiitaItemEntityList = new ArrayList<>();
    private boolean mIsBusy;

    public QiitaItemModel() {
        mEventBus = EventBus.getDefault();
        mIsBusy = false;
    }

    public List<QiitaItemEntity> get() {
        return mQiitaItemEntityList;
    }

    public void load() {

        if (mIsBusy) {
            return;
        }

        HogeAsyncTask asyncJsonLoader = new HogeAsyncTask(new HogeAsyncTask.AsyncCallback() {
            // 実行前
            public void preExecute() {
                mIsBusy = true;
            }
            // 実行後
            public void postExecute(List<QiitaItemEntity> result) {
                if (result == null) {
                    return;
                }

                mQiitaItemEntityList.clear();
                mQiitaItemEntityList.addAll(result);

                mIsBusy = false;
                EventBus.getDefault().post(new QiitaItemLoadedEvent(true));
            }
            // 実行中
            public void progressUpdate(int progress) {
            }
            // キャンセル
            public void cancel() {
            }
        });
        // 処理を実行
        asyncJsonLoader.execute("");
    }
}
