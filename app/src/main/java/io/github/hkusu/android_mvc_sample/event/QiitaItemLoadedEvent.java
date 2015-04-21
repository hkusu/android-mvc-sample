package io.github.hkusu.android_mvc_sample.event;

// イベントに値を詰め込んで投げることが出来る(今回は成功/失敗フラグのみ)

public class QiitaItemLoadedEvent {

    private boolean isSuccess;

    public QiitaItemLoadedEvent(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public boolean isSuccess() {
        return isSuccess;
    }
}
