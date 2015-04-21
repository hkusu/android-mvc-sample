package io.github.hkusu.droidkaigi_demo.common;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import java.util.HashMap;
import java.util.Map;

import io.github.hkusu.droidkaigi_demo.MainActivity;
import io.github.hkusu.droidkaigi_demo.R;

// Fragment の切り替えを行うクラス

public class FragmentManager {

    public static enum Tag {
        LIST,
        DETAIL,
    }

    private static final int ANIM_RES_SLIDE_IN_RIGHT = R.anim.slide_in_right;
    private static final int ANIM_RES_SLIDE_OUT_RIGHT = R.anim.slide_out_right;
    private static final int ANIM_RES_SLIDE_IN_BOTTOM = R.anim.slide_in_bottom;
    private static final int ANIM_RES_SLIDE_OUT_BOTTOM = R.anim.slide_out_bottom;
    private static final int ANIM_RES_FADE_IN = R.anim.fade_in;
    private static final int ANIM_RES_FADE_OUT = R.anim.fade_out;

    public static enum Animation {
        NON,
        SLIDE_IN_RIGHT,
        SLIDE_IN_BOTTOM,
        FADE_IN,
    }

    private static Map<Tag, Class> showcase = new HashMap<>();

    MainActivity mMainActivity;
    int mContainer;

    public FragmentManager(Context context, @IdRes int container) {
        mMainActivity = (MainActivity)context;
        mContainer = container;
    }

    public static void register(Tag tag, Class c) {
        showcase.put(tag, c);
    }

    public static Class get(Tag tag) {
        return showcase.get(tag);
    }

    public void replace(Tag tag, Bundle args, Animation animation) {
        replace(tag, args, animation, true);
    }

    public void replace(Tag tag, Bundle args, Animation animation, boolean addToBackStack) {

        Fragment fragment = mMainActivity.getSupportFragmentManager().findFragmentByTag(String.valueOf(tag));
        if (fragment == null) {
            try {
                Class c = get(tag);
                fragment = (Fragment)c.newInstance();
                fragment.setArguments(args);
            } catch (Exception e) {
                return;
            }
        }

        int enterAnim;
        int exitAnim;
        int popEnterAnim;
        int popExitAnim;
        switch (animation) {
            case SLIDE_IN_RIGHT:
                enterAnim = ANIM_RES_SLIDE_IN_RIGHT;
                exitAnim = ANIM_RES_FADE_OUT;
                popEnterAnim = ANIM_RES_FADE_IN;
                popExitAnim = ANIM_RES_SLIDE_OUT_RIGHT;
                break;
            case SLIDE_IN_BOTTOM:
                enterAnim = ANIM_RES_SLIDE_IN_BOTTOM;
                exitAnim = ANIM_RES_FADE_OUT;
                popEnterAnim = ANIM_RES_FADE_IN;
                popExitAnim = ANIM_RES_SLIDE_OUT_BOTTOM;
                break;
            case FADE_IN:
            case NON:
                enterAnim = ANIM_RES_FADE_IN;
                exitAnim = ANIM_RES_FADE_OUT;
                popEnterAnim = ANIM_RES_FADE_IN;
                popExitAnim = ANIM_RES_FADE_OUT;
                break;
            default:
                return;
        }

        FragmentTransaction fragmentTransaction = mMainActivity.getSupportFragmentManager().beginTransaction();
        if (animation != Animation.NON) { fragmentTransaction.setCustomAnimations(enterAnim, exitAnim, popEnterAnim, popExitAnim); }
        fragmentTransaction.replace(mContainer, fragment, String.valueOf(tag));
        if (addToBackStack) { fragmentTransaction.addToBackStack(null); }
        fragmentTransaction.commit();
    }
}
