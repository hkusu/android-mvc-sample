package io.github.hkusu.droidkaigi_demo.model;

import de.greenrobot.event.EventBus;
import io.github.hkusu.droidkaigi_demo.common.IModel;

public class QiitaNewPostModel implements IModel {

    private final EventBus mEventBus;

    public QiitaNewPostModel(EventBus eventBus) {
        mEventBus = eventBus;
    }

    //public List<Hoge> get() {
    //}

    //public Hoge get(int hogeId) {
    //}

    //public boolean post(Hoge hoge) {
    //    //mEventBus.post(new QiitaNewPostModelChangedEvent(true));
    //}

    //public boolean put(Hoge hoge) {
    //}

    //public boolean delete(Hoge hoge) {
    //}
}
