package io.github.hkusu.android_mvc_sample.model;

import android.os.AsyncTask;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;
import io.github.hkusu.android_mvc_sample.api.QiitaApiService;
import io.github.hkusu.android_mvc_sample.common.Const;
import io.github.hkusu.android_mvc_sample.event.QiitaItemLoadedEvent;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

public class QiitaItemModel {

    private final List<QiitaItemEntity> mQiitaItemList = new ArrayList<>();
    private int mItemCount = 0;
    private boolean busy = false;

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
        if (busy) {
            return;
        }
        // 非同期で API を発行
        ApiAsyncTask apiAsyncTask = new ApiAsyncTask();
        apiAsyncTask.execute();
    }

    private class ApiAsyncTask extends AsyncTask<String, Integer, List<QiitaItemEntity>> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // ビジー状態へ
            busy = true;
        }

        @Override
        protected List<QiitaItemEntity> doInBackground(String... strings) {
            // Gsonの設定(ただ今回はこれが無くても動きはした)
            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
            // Retrofitのアダプタ作成
            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint(Const.QIITA_API_ENDPOINT)
                    .setConverter(new GsonConverter(gson))
                    .build();
            // アダプタをサービスに紐付け
            QiitaApiService service = restAdapter
                    .create(QiitaApiService.class);
            return service.getItems(); // APIを発行
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
            busy = false;
            // EvnetBus へ完了通知を送る
            EventBus.getDefault().post(new QiitaItemLoadedEvent(true));
        }
    }
}
