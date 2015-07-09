package io.github.hkusu.android_mvc_sample.common;

import java.util.HashMap;
import java.util.Map;

// 任意のインスタンスの参照を保持できるクラス

public class ObjectLocator {

    private static Map<String, Object> showcase = new HashMap<>();

    private ObjectLocator() {
    }

    public static void register(String string, Object object) {
        showcase.put(string, object);
    }

    public static Object get(String string) {
        return showcase.get(string);
    }
}
