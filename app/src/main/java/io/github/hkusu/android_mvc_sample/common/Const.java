package io.github.hkusu.android_mvc_sample.common;

import java.util.ArrayList;
import java.util.List;

public class Const {

    // 固定値を定義する。メソッドを定義する場合は static で

    public static final String QIITA_API_ENDPOINT = "http://qiita.com";
    public static final String QIITA_API_ITMES = "/api/v1/items";

    public static enum BundleKey {
        URL,
    }

    // インスタンス化は禁止
    private Const() {
    }

    public static List<String> getHogeList() {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++ ) {
            list.add("データ" + i);
        }
        return list;
    }
}
