package io.github.hkusu.droidkaigi_demo.event;

public class QiitaItemLoadedEvent {

    private boolean isSuccess;

    public QiitaItemLoadedEvent(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public boolean isSuccess() {
        return isSuccess;
    }
}
