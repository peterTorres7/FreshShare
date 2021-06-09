package com.androiddev.FreshShare;

import android.view.Gravity;
import android.view.View;

import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.contrib.DrawerActions;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.DrawerMatchers.isClosed;
import static androidx.test.espresso.matcher.ViewMatchers.hasErrorText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@RunWith(AndroidJUnit4.class)

public class FoodCardTests {
    @Rule
    public ActivityScenarioRule<MainActivity> rule
            = new ActivityScenarioRule<MainActivity>(MainActivity.class);

    @Test
    public void checkRecyclerView() throws InterruptedException {
        Thread.sleep(8000);
        onView(withId(R.id.recycler_view)).perform(RecyclerViewActions.scrollToPosition(1));
        onView(withId(R.id.recycler_view)).perform(RecyclerViewActions.actionOnItemAtPosition(1, new ClickOnImage()));
        Thread.sleep(2000);
        onView(withId(R.id.foodName)).check(matches(withText("Shallow-Fried Garlic & Onion Yak")));
    }

    @Test
    public void checkRecyclerViewDrawer() throws InterruptedException {
        Thread.sleep(5000);
        onView(withId(R.id.recycler_view)).perform(RecyclerViewActions.scrollToPosition(1));
        onView(withId(R.id.recycler_view)).perform(RecyclerViewActions.actionOnItemAtPosition(1, new ClickOnImage()));
        Thread.sleep(2000);
        onView(withId(R.id.drawer_layout))
                .check(matches(isClosed(Gravity.LEFT))) // Left Drawer should be closed.
                .perform(DrawerActions.open()); // Open Drawer

        onView(withText("Home")).perform(click());
        onView(withId(R.id.welcome)).check(matches(withText("Welcome to Fresh Share!")));
    }

    public static class ClickOnImage implements ViewAction {

        ViewAction c = click();

        @Override
        public Matcher<View> getConstraints() {
            return c.getConstraints();
        }

        @Override
        public String getDescription() {
            return "Click on a child view with specified id.";
        }

        @Override
        public void perform(UiController uiController, View view) {
            c.perform(uiController,view.findViewById(R.id.match_image));
        }
    }

}
