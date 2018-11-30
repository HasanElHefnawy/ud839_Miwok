package com.example.android.miwok;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class WordAdapter extends ArrayAdapter<Word> {
    private int mColor;

    public WordAdapter(Context context, int resource, List<Word> zzz, int color) {
        super(context, resource, zzz);
        mColor = color;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView;
        if (convertView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.custom_list_item, parent, false);
        } else {
            listItemView = convertView;
        }
        final Word currentWord = getItem(position); // final???
        TextView DefaultTranslationTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        DefaultTranslationTextView.setText(currentWord.getDefaultTranslation());
        TextView MiwokTranslationTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        MiwokTranslationTextView.setText(currentWord.getMiwokTranslation());
        ImageView icon = (ImageView) listItemView.findViewById(R.id.image);
        icon.setImageResource(currentWord.getImage()); // public void setImageResource(int resId) @param resId can't be a negative number
        if (currentWord.hasImage()) {
//            icon.setVisibility(View.VISIBLE); // VISIBLE is the default value of the initial visibility of the view
        } else {
            icon.setVisibility(View.GONE);
        }
//        if (getContext().toString().contains("NumbersActivity")){
//            listItemView.setBackgroundColor(getContext().getResources().getColor(R.color.category_numbers));
//        }
//        else if (getContext().toString().contains("FamilyActivity")){
//            listItemView.setBackgroundColor(getContext().getResources().getColor(R.color.category_family));
//        }
//        else if (getContext().toString().contains("ColorsActivity")){
//            listItemView.setBackgroundColor(getContext().getResources().getColor(R.color.category_colors));
//        }
//        else if (getContext().toString().contains("PhrasesActivity")){
//            listItemView.setBackgroundColor(getContext().getResources().getColor(R.color.category_phrases));
//        }
        listItemView.setBackgroundResource(mColor);
//        listItemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick (View v)  {
//                MediaPlayer mediaPlayer = MediaPlayer.create(getContext(), currentWord.getAudio());
//                mediaPlayer.start(); // no need to call prepare(); create() does that for you
//            }
//        });
        return listItemView;
//        return super.getView(position, convertView, parent);
    }
}
