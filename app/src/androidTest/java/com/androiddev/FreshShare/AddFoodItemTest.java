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
import static androidx.test.espresso.contrib.DrawerMatchers.isClosed;
import static androidx.test.espresso.matcher.ViewMatchers.hasErrorText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@RunWith(AndroidJUnit4.class)

public class AddFoodItemTest {
    @Rule
    public ActivityScenarioRule<AddFoodItemActivity> rule
            = new ActivityScenarioRule<AddFoodItemActivity>(AddFoodItemActivity.class);


    @Test
    public void vendorFieldRequired() {
        onView(withId(R.id.foodName)).perform(typeText(""));
        onView(withId(R.id.foodDescription)).perform(typeText("chimichanga@gmail.com"));
        onView(withId(R.id.imageURL)).perform(scrollTo());
        onView(withId(R.id.imageURL)).perform(typeText("https://i.imgur.com/M8rkMOM.jpeg"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.sign_up_button)).perform(scrollTo(), click());
        onView(allOf(withId(R.id.foodName), hasErrorText("Please Enter Vendor Name")));
    }

    @Test
    public void emailFieldRequired() {
        onView(withId(R.id.foodName)).perform(typeText("Deadpool's Doughnuts"));
        onView(withId(R.id.foodDescription)).perform(typeText(""));
        onView(withId(R.id.imageURL)).perform(scrollTo());
        onView(withId(R.id.imageURL)).perform(typeText("https://i.imgur.com/M8rkMOM.jpeg"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.sign_up_button)).perform(scrollTo(), click());
        onView(allOf(withId(R.id.foodDescription), hasErrorText("Please Enter Valid Email")));
    }

    @Test
    public void addressFieldRequired() {
        onView(withId(R.id.foodName)).perform(typeText("Deadpool's Doughnuts"));
        onView(withId(R.id.foodDescription)).perform(typeText("chimichanga@gmail.com"));
        onView(withId(R.id.imageURL)).perform(scrollTo());
        onView(withId(R.id.imageURL)).perform(typeText(""));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.sign_up_button)).perform(scrollTo(), click());
        onView(allOf(withId(R.id.imageURL), hasErrorText("Please Enter address")));
    }

    @Test
    public void URLFieldRequired() {
        onView(withId(R.id.foodName)).perform(typeText("Deadpool's Doughnuts"));
        onView(withId(R.id.foodDescription)).perform(typeText("chimichanga@gmail.com"));
        onView(withId(R.id.imageURL)).perform(scrollTo());
        onView(withId(R.id.imageURL)).perform(typeText(""));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.sign_up_button)).perform(scrollTo(), click());
        onView(allOf(withId(R.id.imageURL), hasErrorText("Please Set ImageURL")));
    }

    @Test
    public void fillForm() {
        onView(withId(R.id.foodName)).perform(typeText("Deadpool's Doughnuts"));
        onView(withId(R.id.foodDescription)).perform(typeText("chimichanga@gmail.com"));
        onView(withId(R.id.imageURL)).perform(scrollTo());
        onView(withId(R.id.imageURL)).perform(typeText("https://i.imgur.com/M8rkMOM.jpeg"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.sign_up_button)).perform(scrollTo(), click());
    }


}
