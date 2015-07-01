package io.github.hkusu.android_mvc_sample.model;

import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;
import io.github.hkusu.android_mvc_sample.api.ApiManager;
import io.github.hkusu.android_mvc_sample.event.QiitaItemLoadedEvent;

public class QiitaItemModel {

    private final List<QiitaItemEntity> mQiitaItemList = new ArrayList<>();
    private int mItemCount = 0;
    private boolean mIsBusy = false;

    public QiitaItemModel() {
    }

    public List<QiitaItemEntity> getItemList() {
        return mQiitaItemList;
    }

    public int getItemCount() {
        return mItemCount;
    }

    public void load() {
        // ビジー状態なら何もしない
        if (mIsBusy) {
            return;
        }
        // 非同期で API を発行
        new AsyncTask<Void, Void, List<QiitaItemEntity>>() {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                // ビジー状態へ
                mIsBusy = true;
            }

            @Override
            protected List<QiitaItemEntity> doInBackground(Void... voids) {
                return ApiManager.getQiitaItem();
            }

            @Override
            protected void onPostExecute(List<QiitaItemEntity> result) {
                super.onPostExecute(result);
                // 取得結果でリストを更新(参照は維持)
                mQiitaItemList.clear();
                mQiitaItemList.addAll(result);
                // 件数を更新
                mItemCount = result.size();
                // ビジー状態を解除
                mIsBusy = false;
                // EventBus で完了通知を送る
                EventBus.getDefault().post(new QiitaItemLoadedEvent(true));
            }
        }.execute();
    }
}
