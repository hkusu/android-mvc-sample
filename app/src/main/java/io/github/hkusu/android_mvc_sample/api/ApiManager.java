package io.github.hkusu.android_mvc_sample.api;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import io.github.hkusu.android_mvc_sample.common.Const;
import io.github.hkusu.android_mvc_sample.model.QiitaItemEntity;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;
import retrofit.http.GET;

public class ApiManager {

    private interface QiitaApiService {

        @GET(Const.QIITA_API_ITEMS)
        public List<QiitaItemEntity> getItem();

        //@GET("/api/v1/tags")
        //public List<QiitaTagApiEntity> getTags();
    }

    // Gsonの設定(ただ今回はこれが無くても動きはした)
    private static Gson qiitaJson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create();

    // Retrofitのアダプタ
    private static RestAdapter qiitaRestAdapter = new RestAdapter.Builder()
            .setEndpoint(Const.QIITA_API_ENDPOINT)
            .setConverter(new GsonConverter(qiitaJson))
            .build();

    public static List<QiitaItemEntity> getQiitaItem() {

        QiitaApiService qiitaApiService = qiitaRestAdapter
                .create(QiitaApiService.class);
        return qiitaApiService.getItem(); // APIを発行
    }
}
