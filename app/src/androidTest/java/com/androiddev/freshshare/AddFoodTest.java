package com.androiddev.freshshare;

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
public class AddFoodTest {
    @Rule
    public ActivityScenarioRule<AddFoodItemActivity> activityScenarioRule
            = new ActivityScenarioRule<>(AddFoodItemActivity.class);

    @Test
    public void foodNameRequired() {
        onView(withId(R.id.foodName)).perform(typeText(""));
        onView(withId(R.id.foodDescription)).perform(typeText("Energy Fueled to fight Francis"));
        onView(withId(R.id.imageURL)).perform(scrollTo());
        onView(withId(R.id.imageURL)).perform(typeText("https://i.imgur.com/M8rkMOM.jpeg"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.sign_up_button)).perform(scrollTo(), click());
        onView(allOf(withId(R.id.foodName), hasErrorText("Please Enter Name of the Food")));
    }

    @Test
    public void foodDescriptionRequired() {
        onView(withId(R.id.foodName)).perform(typeText("Deadpool's Doughnuts"));
        onView(withId(R.id.foodDescription)).perform(typeText(""));
        onView(withId(R.id.imageURL)).perform(scrollTo());
        onView(withId(R.id.imageURL)).perform(typeText("https://i.imgur.com/M8rkMOM.jpeg"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.sign_up_button)).perform(scrollTo(), click());
        onView(allOf(withId(R.id.foodDescription), hasErrorText("Please Enter the Description of the Food")));
    }

    @Test
    public void foodImageUrlRequired() {
        onView(withId(R.id.foodName)).perform(typeText("Deadpool's Doughnuts"));
        onView(withId(R.id.foodDescription)).perform(typeText("Energy Fueled to fight Francis"));
        onView(withId(R.id.imageURL)).perform(scrollTo());
        onView(withId(R.id.imageURL)).perform(typeText(""));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.sign_up_button)).perform(scrollTo(), click());
        onView(allOf(withId(R.id.imageURL), hasErrorText("Please Enter Image URl")));
    }
}

