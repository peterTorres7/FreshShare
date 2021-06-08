package com.example.freshshare;

import android.content.Intent;

import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

public class IntentTest {
    @Rule
    public ActivityTestRule<SignUpActivity> testRule1 = new ActivityTestRule<>(SignUpActivity.class,
            false,
            false);

    @Test
    public void testIntent() {
        Intent intent1 = new Intent();
        testRule1.launchActivity(intent1);
    }

    @Rule
    public ActivityTestRule<MainActivity> testRule2 = new ActivityTestRule<>(MainActivity.class,
            false,
            false);

    @Test
    public void testIntent2() {
        Intent intent1 = new Intent();
        testRule2.launchActivity(intent1);
    }
}
