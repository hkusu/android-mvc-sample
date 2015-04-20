package io.github.hkusu.droidkaigi_demo.common;

import java.util.HashMap;
import java.util.Map;

public class ModelManager {

    public static enum Tag {
        QIITA_ITEM
    }

    private static ModelManager INSTANCE = new ModelManager();

    private Map<Tag, IModel> showcase = new HashMap<>();

    public static ModelManager getInstance() {
        return INSTANCE;
    }

    private ModelManager() {
    }

    public void register(Tag tag, IModel model) {
        showcase.put(tag, model);
    }

    public IModel get(Tag tag) {
        return showcase.get(tag);
    }
}
