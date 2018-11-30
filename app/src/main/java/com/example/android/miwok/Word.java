package com.example.android.miwok;

import android.media.Image;

public class Word {
    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mImage = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = 0; // public void setImageResource(int resId) @param resId can't be a negative number
    private int mAudio;

    public Word(String defaultTranslation, String miwokTranslation, int audio) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mAudio = audio;
    }

    public Word(String defaultTranslation, String miwokTranslation, int image, int audio) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImage = image;
        mAudio = audio;
    }

    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    public int getImage() {
        return mImage;
    }

    public boolean hasImage() {
        return mImage != NO_IMAGE_PROVIDED;
    }

    public int getAudio() {
        return mAudio;
    }

    @Override
    public String toString() {  // That's why elements did't show
        return "Word{" +
                "mDefaultTranslation='" + mDefaultTranslation + '\'' +
                ", mMiwokTranslation='" + mMiwokTranslation + '\'' +
                ", mImage=" + mImage +
                ", mAudio=" + mAudio +
                '}';
    }
}
