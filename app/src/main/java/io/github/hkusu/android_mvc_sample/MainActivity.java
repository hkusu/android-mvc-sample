package io.github.hkusu.android_mvc_sample;

import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;

import io.github.hkusu.android_mvc_sample.common.FragmentRouter;
import io.github.hkusu.android_mvc_sample.viewController.DetailFragment;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            FragmentRouter.replace(getSupportFragmentManager(), R.id.container, FragmentRouter.Tag.LIST, null, FragmentRouter.Animation.NON, false);
        }
    }

    // 端末のバックキーが押下された際、WebView もブラウザバックさせる
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(FragmentRouter.Tag.DETAIL.toString());
        if (fragment != null) {
            WebView webView = ((DetailFragment)fragment).getWebView();
            if (webView != null) {
                if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
                    webView.goBack();
                    return true;
                }
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
