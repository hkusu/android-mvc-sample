package io.github.hkusu.droidkaigi_demo.common;

import java.util.ArrayList;
import java.util.List;

public class Const {

    public static final String QIITA_API_ENDPOINT = "http://qiita.com";
    public static final String QIITA_API_ITMES = "/api/v1/items";

    public static enum Fuga {
        AAA,
        BBB,
        CCC,
    }

    // インスタンス化は禁止
    private Const() {
    }

    public static List<String> getPiyoList() {
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        return list;
    }
}
