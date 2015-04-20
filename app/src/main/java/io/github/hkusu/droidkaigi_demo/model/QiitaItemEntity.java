package io.github.hkusu.droidkaigi_demo.model;

import com.google.gson.annotations.SerializedName;

import io.github.hkusu.droidkaigi_demo.model.QiitaItemUserEntity;

public class QiitaItemEntity {

    @SerializedName("id")
    public int id;

    @SerializedName("uuid")
    public String uuid;

    @SerializedName("title")
    public String title;

    @SerializedName("url")
    public String url;

    @SerializedName("user")
    public QiitaItemUserEntity user;
}
