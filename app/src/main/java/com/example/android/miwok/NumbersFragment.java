package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class NumbersFragment extends Fragment {
    private MediaPlayer mMediaPlayer;
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };
    private AudioManager mAudioManager; // no initialization is allowed here!!!
    private AudioManager.OnAudioFocusChangeListener afChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                mMediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                releaseMediaPlayer();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0); //start from the beginning
            }
        }
    };

    public NumbersFragment() {  // The constructor can be removed
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);
//        getActivity().getWindow().getDecorView().setBackgroundResource(R.color.category_numbers);
//        String words[] = new String[10];
//        words[0] = "one";
//        words[1] = "two";
//        words[2] = "three";
//        words[3] = "four";
//        words[4] = "five";
//        words[5] = "six";
//        words[6] = "seven";
//        words[7] = "eight";
//        words[8] = "nine";
//        words[9] = "ten";
//        List<String> words = Arrays.asList("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten");
        final List<Word> words = Arrays.asList(
                new Word("one", "lutti", R.drawable.number_one, R.raw.number_one),
                new Word("two", "otiiko", R.drawable.number_two, R.raw.number_two),
                new Word("three", "tolookosu", R.drawable.number_three, R.raw.number_three),
                new Word("four", "oyyisa", R.drawable.number_four, R.raw.number_four),
                new Word("five", "massokka", R.drawable.number_five, R.raw.number_five),
                new Word("six", "temmokka", R.drawable.number_six, R.raw.number_six),
                new Word("seven", "kenekaku", R.drawable.number_seven, R.raw.number_seven),
                new Word("eight", "kawinta", R.drawable.number_eight, R.raw.number_eight),
                new Word("nine", "wo’e", R.drawable.number_nine, R.raw.number_nine),
                new Word("ten", "na’aacha", R.drawable.number_ten, R.raw.number_ten));

//        ArrayAdapter itemsAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,words);
        WordAdapter itemsAdapter = new WordAdapter(getActivity(), R.layout.custom_list_item, words, R.color.category_numbers);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releaseMediaPlayer();
                mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);
                int result = mAudioManager.requestAudioFocus(afChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mMediaPlayer = MediaPlayer.create(getActivity(), words.get(position).getAudio());
//                    mMediaPlayer = MediaPlayer.create(getActivity(), itemsAdapter.getItem(position).getAudio());  // another solution
                    mMediaPlayer.start(); // no need to call prepare(); create() does that for you
                    Log.v("zzzzzzzzzzz", "" + words.get(position));    //why elements don't show???
                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                }
            }
        });
        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
            // Also, abandonAudioFocus of AudioManager
            mAudioManager.abandonAudioFocus(afChangeListener);
        }
    }

}
