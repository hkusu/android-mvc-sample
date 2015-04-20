package io.github.hkusu.droidkaigi_demo.entity;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.google.gson.annotations.SerializedName;

@Table(name = "Items", id = "_id")
public class QiitaItemEntity extends Model {

    @Column(name = "id", unique = true, onUniqueConflict = Column.ConflictAction.REPLACE)
    @SerializedName("id")
    public int id;

    @Column(name = "uuid")
    @SerializedName("uuid")
    public String uuid;

    @Column(name = "title")
    @SerializedName("title")
    public String title;

    @Column(name = "url")
    @SerializedName("url")
    public String url;

    // User とのリレーションは、Active Android については自力で id で連結することとする
    @SerializedName("user")
    public QiitaItemUserEntity user;

    @Column(name = "userId")
    public int userId;

    @Column(name = "userUrlName")
    public String userUrlName;

    @Column(name = "userProfileImageUrl")
    public String userProfileImageUrl;
}
