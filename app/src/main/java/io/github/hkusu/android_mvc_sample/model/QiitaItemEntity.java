package io.github.hkusu.android_mvc_sample.model;

import com.google.gson.annotations.SerializedName;

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
