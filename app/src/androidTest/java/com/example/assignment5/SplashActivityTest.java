package com.example.assignment5;


import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class SplashActivityTest {

    @Rule
    public ActivityTestRule<SplashActivity> mActivityTestRule = new ActivityTestRule<>(SplashActivity.class);

    @Test
    public void splashActivityTest() {
        ViewInteraction materialButton = onView(
                allOf(withText("Click here to Sign up"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        materialButton.perform(click());

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.etname),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                2)));
        appCompatEditText.perform(scrollTo(), replaceText("Manali"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.etnum),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                4)));
        appCompatEditText2.perform(scrollTo(), replaceText("9876543210"), closeSoftKeyboard());

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.etemail),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                6)));
        appCompatEditText3.perform(scrollTo(), replaceText("manali@gmail.com"), closeSoftKeyboard());

        ViewInteraction appCompatEditText4 = onView(
                allOf(withId(R.id.etcountry),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                8)));
        appCompatEditText4.perform(scrollTo(), replaceText("India"), closeSoftKeyboard());

        ViewInteraction appCompatEditText5 = onView(
                allOf(withId(R.id.etaddress),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                10)));
        appCompatEditText5.perform(scrollTo(), replaceText("flat no. 123\nKillol flats\nBhavnagar"), closeSoftKeyboard());

        pressBack();

        ViewInteraction materialButton2 = onView(
                allOf(withId(R.id.btndob), withText("Click Here"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                12)));
        materialButton2.perform(scrollTo(), click());

        ViewInteraction materialTextView = onView(
                allOf(withClassName(is("com.google.android.material.textview.MaterialTextView")), withText("2020"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                0),
                        isDisplayed()));
        materialTextView.perform(click());

        DataInteraction materialTextView2 = onData(anything())
                .inAdapterView(allOf(withClassName(is("android.widget.YearPickerView")),
                        childAtPosition(
                                withClassName(is("com.android.internal.widget.DialogViewAnimator")),
                                1)))
                .atPosition(100);
        materialTextView2.perform(scrollTo(), click());

        ViewInteraction materialButton3 = onView(
                allOf(withId(android.R.id.button1), withText("OK"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                3)));
        materialButton3.perform(scrollTo(), click());

        ViewInteraction materialRadioButton = onView(
                allOf(withId(R.id.rdofemale), withText("Female"),
                        childAtPosition(
                                allOf(withId(R.id.rdogender),
                                        childAtPosition(
                                                withClassName(is("android.widget.LinearLayout")),
                                                14)),
                                1)));
        materialRadioButton.perform(scrollTo(), click());

        ViewInteraction materialCheckBox = onView(
                allOf(withId(R.id.chkreading), withText("Reading"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                16)));
        materialCheckBox.perform(scrollTo(), click());

        ViewInteraction materialCheckBox2 = onView(
                allOf(withId(R.id.chkmusic), withText("Music"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                18)));
        materialCheckBox2.perform(scrollTo(), click());

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.btnnext), withText("Sign up"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                19)));
        appCompatButton.perform(scrollTo(), click());
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
