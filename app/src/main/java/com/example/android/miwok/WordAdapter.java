package com.example.android.miwok;

import android.app.Activity;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {
    private int colorResoursId;
    public WordAdapter(Activity context , ArrayList<Word> words,int colorResoursId ){
        super(context , 0 , words);
        this.colorResoursId=colorResoursId;
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MediaPlayer med;
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        /**
         * Get the {@link AndroidFlavor} object located at this position in the list
         */
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView miwok_text_view = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        miwok_text_view.setText(currentWord.getMiwokTranslations());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView default_text_view = (TextView) listItemView.findViewById(R.id.default_text_view);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        default_text_view.setText(currentWord.getDefaultTranslations());

        ImageView activeImage=(ImageView) listItemView.findViewById(R.id.activeImage);

        if(currentWord.hasImage()){
            activeImage.setImageResource(currentWord.getImageResourceId());
            activeImage.setVisibility(View.VISIBLE);
        }

        else
            activeImage.setVisibility(View.GONE);

        View textContainer = listItemView.findViewById(R.id.text_container);

        int color = ContextCompat.getColor(getContext() , colorResoursId);

        textContainer.setBackgroundColor(color);


        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
