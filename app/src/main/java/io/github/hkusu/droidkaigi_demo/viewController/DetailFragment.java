package io.github.hkusu.droidkaigi_demo.viewController;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.InjectView;
import io.github.hkusu.droidkaigi_demo.R;
import io.github.hkusu.droidkaigi_demo.common.Const;

public class DetailFragment extends Fragment {

    @InjectView(R.id.webView)
    WebView mWebView;

    private String mUrl;

    public DetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mUrl = getArguments().getString(Const.BundleKey.URL.toString());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        ButterKnife.inject(this, view); // ButterKnife
        return view;
    }

    @Override
    @SuppressLint("SetJavaScriptEnabled")
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // JavaScript を有効化
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.setWebViewClient(new WebViewClient() {
            // エラーが発生した場合
            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(getActivity(), "エラーが発生しました。", Toast.LENGTH_SHORT).show();
            }
        });
        mWebView.loadUrl(mUrl);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    // 外部へ WebView インスタンスへの参照を渡すメソッド
    public WebView getWebView() {
        return mWebView;
    }
}
