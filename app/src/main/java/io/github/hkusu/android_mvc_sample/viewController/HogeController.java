package io.github.hkusu.android_mvc_sample.viewController;

// Fragment から切り出す Controller のサンプル。viewやアダプタ等のインスタンスの参照を受け取って処理する

public class HogeController {

    // Fragment の onCreate() で本 Controller を new する。依存があればコンストラクタで渡す
    public HogeController() {
    }

    // Fragment の onActivityCreated() で hogeController.onActivityCreated() という風に呼び出す
    public void onActivityCreated() {
    }

    // 以下、同様
    public void onStart() {
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void onDestroy() {
    }
}
