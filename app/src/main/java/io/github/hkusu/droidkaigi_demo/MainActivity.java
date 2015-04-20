package io.github.hkusu.droidkaigi_demo;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import io.github.hkusu.droidkaigi_demo.common.FragmentList;
import io.github.hkusu.droidkaigi_demo.common.FragmentManager;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            (new FragmentManager(this, R.id.container)).replace(FragmentList.LIST, null, FragmentManager.Animation.SLIDE_IN_RIGHT, false);
        }
    }
}

//TODO 残

//AsyncTaskLoaderにする

//ListFragment
//DetailFragment

//期間みて？APIに再アクセス＆apiに失敗したらDBのデータ見せる

//api
//  Picasso

//Utility に何か
//controller、(view) に分割