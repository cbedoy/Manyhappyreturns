package cbedoy.manyhappyreturns.fragments;

import android.annotation.SuppressLint;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cbedoy.manyhappyreturns.R;

/**
 * Created by Bedoy on 2/23/16.
 */
@SuppressLint("ValidFragment")
public class FragmentController extends Fragment
{
    private int mLayout;

    public FragmentController(int layout){
        mLayout = layout;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(mLayout, null);
    }
}
