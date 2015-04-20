package io.github.hkusu.droidkaigi_demo.event;

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
