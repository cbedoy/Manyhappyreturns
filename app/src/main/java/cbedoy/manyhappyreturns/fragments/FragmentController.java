package cbedoy.manyhappyreturns.fragments;

import android.annotation.SuppressLint;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.vstechlab.easyfonts.EasyFonts;

import cbedoy.manyhappyreturns.R;

/**
 * Created by Bedoy on 2/23/16.
 */
@SuppressLint("ValidFragment")
public class FragmentController extends Fragment
{
    private int mDescription;
    private int mImage;
    private View holderView;

    public FragmentController(int descriptionId, int imageId) {
        mDescription = descriptionId;
        mImage = imageId;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.card_fragment, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView descriptionView = (TextView) view.findViewById(R.id.card_fragment_description);

        ImageView imageView = (ImageView) view.findViewById(R.id.card_fragment_image);

        holderView = view.findViewById(R.id.card_fragment_holder);

        descriptionView.setText(mDescription);
        imageView.setImageResource(mImage);

        descriptionView.setTypeface(EasyFonts.robotoLight(getContext()));
    }

    public void setHolderColor(int holderColor)
    {
        holderView.setBackgroundColor(holderColor);
    }
}
