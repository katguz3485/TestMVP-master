package com.example.sda.testmvp;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.sda.testmvp.main.MainActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class MainActivityEspressoTest {


    @Rule
    public ActivityTestRule<MainActivity> testRule = new ActivityTestRule<>(MainActivity.class);
    private MainActivity mainActivity;


    public String stringToBeTyped;

    @Before
    public void setUp() throws Exception {
        stringToBeTyped = "12";
        //mLocatingActivity = mActivityTestRule.getActivity();
        mainActivity = testRule.getActivity();
    }


    public void validateEditText() {
        onView(withId(R.id.editText)).perform(typeText("1")).check(matches(withText("1")));
    }


    @Test
    public void testEditText() throws Exception {
        onView(withId(R.id.editText)).perform(click(), typeText(stringToBeTyped), closeSoftKeyboard());
        onView(withId(R.id.submit_button)).perform(click());
        onView(withId(R.id.textView)).check(matches(withText(stringToBeTyped)));


    }


}