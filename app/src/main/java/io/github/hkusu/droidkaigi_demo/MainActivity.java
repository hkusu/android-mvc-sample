package io.github.hkusu.droidkaigi_demo;

import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;

import io.github.hkusu.droidkaigi_demo.common.FragmentManager;
import io.github.hkusu.droidkaigi_demo.viewController.DetailFragment;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            (new FragmentManager(this, R.id.container)).replace(FragmentManager.Tag.LIST, null, FragmentManager.Animation.SLIDE_IN_RIGHT, false);
        }
    }

    // 端末のバックキーが押下された際、WebView もブラウザバックさせる
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(FragmentManager.Tag.DETAIL.toString());
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
