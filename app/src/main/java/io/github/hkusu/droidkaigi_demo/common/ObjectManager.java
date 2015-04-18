package io.github.hkusu.droidkaigi_demo.common;

import java.util.HashMap;

public class ObjectManager {

    private static ObjectManager sObjectManager = new ObjectManager();

    private HashMap<String, Object> showcase = new HashMap<>();

    public static ObjectManager getInstance() {
        return sObjectManager;
    }

    private ObjectManager() {
    }

    public void register(String string, Object object) {
        showcase.put(string, object);
    }

    public Object get(String string) {
        return showcase.get(string);
    }
}
