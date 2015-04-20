package io.github.hkusu.droidkaigi_demo.model;

import android.util.Log;

import com.activeandroid.query.Select;

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

        if (0 != new Select().from(QiitaItemEntity.class).count()) {

            Log.i("qiita", "DBから取得");

            mQiitaItemEntityList.clear();
            List<QiitaItemEntity> list =
                    new Select()
                            .from(QiitaItemEntity.class)
                            .orderBy("id DESC")
                            .execute();
            mQiitaItemEntityList.addAll(list);

            mEventBus.post(new QiitaItemLoadedEvent(true));
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

                Log.i("qiita", "APIから取得");

                for (QiitaItemEntity qiitItemEntity : result) {
                    qiitItemEntity.userId = qiitItemEntity.user.id;
                    qiitItemEntity.userUrlName = qiitItemEntity.user.urlName;
                    qiitItemEntity.userProfileImageUrl = qiitItemEntity.user.profileImageUrl;
                    qiitItemEntity.save();
                }

                int i = new Select().from(QiitaItemEntity.class).count();
                Log.i("qiita:count", "count="+i);

                mIsBusy = false;
                load();
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
