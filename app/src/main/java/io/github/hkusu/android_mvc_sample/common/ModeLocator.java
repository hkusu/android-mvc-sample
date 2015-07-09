package io.github.hkusu.android_mvc_sample.common;

import java.util.HashMap;
import java.util.Map;

// 各モデルの参照を保持するクラス

public class ModeLocator {

    public static enum Tag {
        QIITA_ITEM,
    }

    private static Map<Tag, Object> showcase = new HashMap<>();

    private ModeLocator() {
    }

    public static void register(Tag tag, Object object) {
        showcase.put(tag, object);
    }

    public static Object get(Tag tag) {
        return showcase.get(tag);
    }
}
