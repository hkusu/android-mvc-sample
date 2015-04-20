package io.github.hkusu.droidkaigi_demo.entity;

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
