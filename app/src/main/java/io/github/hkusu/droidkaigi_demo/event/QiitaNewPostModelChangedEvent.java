package io.github.hkusu.droidkaigi_demo.event;

public class QiitaNewPostModelChangedEvent {

    private boolean isSuccess;

    public QiitaNewPostModelChangedEvent(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public boolean isSuccess() {
        return isSuccess;
    }
}
