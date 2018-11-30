/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/*package com.example.android.miwok;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ActionBar.TabListener {
    private ViewPager viewPager;
    private ActionBar actionBar;
    private ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageSelected(int position) {
            // on changing the page
            // make respected tab selected
            actionBar.setSelectedNavigationItem(position);
        }
        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }
        @Override
        public void onPageScrollStateChanged(int arg0) {
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        CategoryAdapter adapter = new CategoryAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.removeOnPageChangeListener(onPageChangeListener);
        viewPager.addOnPageChangeListener(onPageChangeListener);

        actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(false);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        // Adding Tabs
        actionBar.addTab(actionBar.newTab().setText("Numbers")
                .setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("Family")
                .setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("Colors")
                .setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("Phrases")
                .setTabListener(this));


//        TextView numbers = findViewById(R.id.numbers);
//        numbers.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(MainActivity.this, NumbersActivity.class);
//                startActivity(i);
//            }
//        });
//        TextView family = findViewById(R.id.family);
//        family.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(MainActivity.this, FamilyActivity.class);
//                startActivity(i);
//            }
//        });
//        TextView colors = findViewById(R.id.colors);
//        colors.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(MainActivity.this, ColorsActivity.class);
//                startActivity(i);
//            }
//        });
//        TextView phrases = findViewById(R.id.phrases);
//        phrases.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(MainActivity.this, PhrasesActivity.class);
//                startActivity(i);
//            }
//        });
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}
//    public void openNumbersList(View view) {
//        Intent i = new Intent(this, NumbersActivity.class);
//        startActivity(i);
//    }
//
//    public void openFamilyList(View view) {
//        Intent i = new Intent(this, FamilyActivity.class);
//        startActivity(i);
//    }
//
//    public void openColorsList(View view) {
//        Intent i = new Intent(this, ColorsActivity.class);
//        startActivity(i);
//    }
//
//    public void openNPhrasesList(View view) {
//        Intent i = new Intent(this, PhrasesActivity.class);
//        startActivity(i);
//    }
*/