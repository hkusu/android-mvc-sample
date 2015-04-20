package io.github.hkusu.droidkaigi_demo.common;

import java.util.HashMap;
import java.util.Map;

public class ModelManager {

    private static Map<ModelList, Object> showcase = new HashMap<>();

    private ModelManager() {
    }

    public static void register(ModelList tag, Object object) {
        showcase.put(tag, object);
    }

    public static Object get(ModelList tag) {
        return showcase.get(tag);
    }
}
