package cbedoy.manyhappyreturns.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cbedoy.manyhappyreturns.R;

/**
 * Created by Bedoy on 2/22/16.
 */
public class FragmentTwo extends Fragment
{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, null);

        return view;
    }
}
