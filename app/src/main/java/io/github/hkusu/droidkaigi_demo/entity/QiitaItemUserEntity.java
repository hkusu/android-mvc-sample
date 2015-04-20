package io.github.hkusu.droidkaigi_demo.entity;

import com.google.gson.annotations.SerializedName;

//@Table(name = "ItemUsers", id = "_id")
//public class QiitaItemUserEntity extends Model {
public class QiitaItemUserEntity {

    //@Column(name = "id", unique = true, onUniqueConflict = Column.ConflictAction.REPLACE)
    @SerializedName("id")
    public int id;

    //@Column(name = "url_name")
    @SerializedName("url_name")
    public String urlName;

    //@Column(name = "profile_image_url")
    @SerializedName("profile_image_url")
    public String profileImageUrl;
}
