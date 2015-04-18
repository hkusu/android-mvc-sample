package io.github.hkusu.droidkaigi.common;

import java.util.HashMap;

public class ModelManager {

    public static enum Tag {
        QIITA_NEW_POST
    }

    private static ModelManager sModelManager = new ModelManager();

    private HashMap<Tag, IModel> showcase = new HashMap<>();

    public static ModelManager getInstance() {
        return sModelManager;
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
