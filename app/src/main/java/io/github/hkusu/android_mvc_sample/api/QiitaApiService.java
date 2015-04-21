package io.github.hkusu.android_mvc_sample.api;

import java.util.List;

import io.github.hkusu.android_mvc_sample.model.QiitaItemEntity;
import io.github.hkusu.android_mvc_sample.common.Const;
import retrofit.http.GET;

// Retrofit 経由の API をここに定義する

public interface QiitaApiService {

    @GET(Const.QIITA_API_ITEMS)
    public List<QiitaItemEntity> getItems();

    //@GET("/api/v1/tags")
    //public List<QiitaTagApiEntity> getTags();
}