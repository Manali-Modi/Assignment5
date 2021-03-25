package com.example.assignment5;

import android.content.Intent;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;
@RunWith(AndroidJUnit4.class)
public class MyTest  {

    @Rule
    public ActivityTestRule<SplashActivity> activityRule
            = new ActivityTestRule<>(
            SplashActivity.class,
            true,     // initialTouchMode
            false);   // launchActivity. False to customize the intent


    @Test
    public void intent() {
        Intent intent = new Intent();
        //intent.putExtra("your_key", "your_value");

        activityRule.launchActivity(intent);

        // Continue with your test
    }
}
