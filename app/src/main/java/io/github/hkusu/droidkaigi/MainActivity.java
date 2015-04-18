package io.github.hkusu.droidkaigi;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import io.github.hkusu.droidkaigi.common.FragmentManager;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            (new FragmentManager(this, R.id.container)).replace(FragmentManager.Tag.LIST, null, FragmentManager.Animation.SLIDE_IN_RIGHT, false);
        }
    }
}

//TODO

//ActiveAndroid
//Model、Entity(ActiveAndroidの)

//api
//  Retrofit、Picasso、OkHttp、Jackson

//Utility
//Const

//controller、(view)