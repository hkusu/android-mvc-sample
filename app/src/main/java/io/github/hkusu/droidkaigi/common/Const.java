package io.github.hkusu.droidkaigi.common;

import java.util.ArrayList;
import java.util.List;

public class Const {

    public static final String HOGE = "hoge";

    public static enum Fuga {
        AAA,
        BBB,
        CCC,
    }

    public static List<String> getPiyoList() {
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        return list;
    }
}
