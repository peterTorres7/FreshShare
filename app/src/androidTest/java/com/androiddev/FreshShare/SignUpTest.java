package com.androiddev.FreshShare;

import androidx.test.espresso.Espresso;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.hasErrorText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

@RunWith(AndroidJUnit4.class)

public class SignUpTest {
    @Rule
    public ActivityScenarioRule<SignUpActivity> activityScenarioRule
            = new ActivityScenarioRule<>(SignUpActivity.class);

    @Test
    public void vendorFieldRequired() {
        onView(withId(R.id.vendor)).perform(typeText(""));
        onView(withId(R.id.email)).perform(typeText("chimichanga@gmail.com"));
        onView(withId(R.id.address)).perform(typeText("100 Awesome St. Seattle WA 98101"));
        onView(withId(R.id.imageURL)).perform(scrollTo());
        onView(withId(R.id.imageURL)).perform(typeText("https://i.imgur.com/M8rkMOM.jpeg"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.sign_up_button)).perform(scrollTo(), click());
        onView(allOf(withId(R.id.vendor), hasErrorText("Please Enter Vendor Name")));
    }

    @Test
    public void emailFieldRequired() {
        onView(withId(R.id.vendor)).perform(typeText("Deadpool's Doughnuts"));
        onView(withId(R.id.email)).perform(typeText(""));
        onView(withId(R.id.address)).perform(typeText("100 Awesome St. Seattle WA 98101"));
        onView(withId(R.id.imageURL)).perform(scrollTo());
        onView(withId(R.id.imageURL)).perform(typeText("https://i.imgur.com/M8rkMOM.jpeg"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.sign_up_button)).perform(scrollTo(), click());
        onView(allOf(withId(R.id.email), hasErrorText("Please Enter Valid Email")));
    }

    @Test
    public void addressFieldRequired() {
        onView(withId(R.id.vendor)).perform(typeText("Deadpool's Doughnuts"));
        onView(withId(R.id.email)).perform(typeText("chimichanga@gmail.com"));
        onView(withId(R.id.address)).perform(typeText(""));
        onView(withId(R.id.imageURL)).perform(scrollTo());
        onView(withId(R.id.imageURL)).perform(typeText("https://i.imgur.com/M8rkMOM.jpeg"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.sign_up_button)).perform(scrollTo(), click());
        onView(allOf(withId(R.id.address), hasErrorText("Please Enter address")));
    }

    @Test
    public void passwordFieldRequired() {
        onView(withId(R.id.vendor)).perform(typeText("Deadpool's Doughnuts"));
        onView(withId(R.id.email)).perform(typeText("chimichanga@gmail.com"));
        onView(withId(R.id.address)).perform(typeText("100 Awesome St. Seattle WA 98101"));
        onView(withId(R.id.imageURL)).perform(scrollTo());
        onView(withId(R.id.imageURL)).perform(typeText("https://i.imgur.com/M8rkMOM.jpeg"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.sign_up_button)).perform(scrollTo(), click());
        onView(allOf(withId(R.id.imageURL), hasErrorText("Please Set ImageURL")));
    }

    @Test
    public void fillForm() {
        onView(withId(R.id.vendor)).perform(typeText("Deadpool's Doughnuts"));
        onView(withId(R.id.email)).perform(typeText("chimichanga@gmail.com"));
        onView(withId(R.id.address)).perform(typeText("100 Awesome St. Seattle WA 98101"));
        onView(withId(R.id.imageURL)).perform(scrollTo());
        onView(withId(R.id.imageURL)).perform(typeText("https://i.imgur.com/M8rkMOM.jpeg"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.sign_up_button)).perform(scrollTo(), click());
    }

}


