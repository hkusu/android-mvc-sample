package io.github.hkusu.droidkaigi_demo.api;

import java.util.List;

import io.github.hkusu.droidkaigi_demo.model.QiitaItemEntity;
import io.github.hkusu.droidkaigi_demo.common.Const;
import retrofit.http.GET;

// Retrofit 経由の API をここに定義する

public interface QiitaApiService {

    @GET(Const.QIITA_API_ITMES)
    public List<QiitaItemEntity> getItems();

    //@GET("/api/v1/tags")
    //public List<QiitaTagApiEntity> getTags();
}