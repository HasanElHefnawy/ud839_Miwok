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
package com.example.android.miwok;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {//implements TabLayout.OnTabSelectedListener {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    /*private ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageSelected(int position) {
            // on changing the page
            // make respected tab selected
            tabLayout.setScrollPosition(position, 0, true);
//            tabLayout.setSelected(true);  // Don't use this line, it highlights all tabs for the first page selected!!!
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        @Override
        public void onPageScrollStateChanged(int arg0) {
        }
    };*/

//    private TabLayout.OnTabSelectedListener onTabSelectedListener = new TabLayout.OnTabSelectedListener() {
//        @Override
//        public void onTabSelected(TabLayout.Tab tab) {
//            viewPager.setCurrentItem(tab.getPosition());
//        }
//
//        @Override
//        public void onTabUnselected(TabLayout.Tab tab) {
//        }
//
//        @Override
//        public void onTabReselected(TabLayout.Tab tab) {
//        }
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        CategoryAdapter adapter = new CategoryAdapter(this, getSupportFragmentManager());
        viewPager.setAdapter(adapter);
//        viewPager.removeOnPageChangeListener(onPageChangeListener);
//        viewPager.addOnPageChangeListener(onPageChangeListener);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setTabTextColors(Color.parseColor("#A8A19E"), Color.parseColor("#FFFFFF"));
//        tabLayout.addTab(tabLayout.newTab().setText("Tab 1"));
//        tabLayout.addTab(tabLayout.newTab().setText("Tab 2"));
//        tabLayout.addTab(tabLayout.newTab().setText("Tab 3"));
//        tabLayout.addTab(tabLayout.newTab().setText("Tab 4"));
//        tabLayout.removeOnTabSelectedListener(onTabSelectedListener);
//        tabLayout.addOnTabSelectedListener(onTabSelectedListener);
//        tabLayout.setOnTabSelectedListener(this);
        tabLayout.setupWithViewPager(viewPager);

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

    /*@Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }*/
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
