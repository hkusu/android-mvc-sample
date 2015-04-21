package io.github.hkusu.android_mvc_sample.model;

import com.google.gson.annotations.SerializedName;

public class QiitaItemUserEntity {

    @SerializedName("id")
    public int id;

    @SerializedName("url_name")
    public String urlName;

    @SerializedName("profile_image_url")
    public String profileImageUrl;
}
