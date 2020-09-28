package com.jaymason.sportbuff


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.scrollTo
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun mainActivityTest() {
        val appCompatImageButton = onView(
            allOf(
                withClassName(`is`("androidx.appcompat.widget.AppCompatImageButton")),
                withContentDescription("Rewind"),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.LinearLayout")),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatImageButton.perform(click())

        val appCompatImageButton2 = onView(
            allOf(
                withClassName(`is`("androidx.appcompat.widget.AppCompatImageButton")),
                withContentDescription("Rewind"),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.LinearLayout")),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatImageButton2.perform(click())

        val appCompatImageView = onView(
            allOf(
                withId(R.id.ivCloseCard),
                childAtPosition(
                    allOf(
                        withId(R.id.clRoot),
                        childAtPosition(
                            withClassName(`is`("android.widget.ScrollView")),
                            0
                        )
                    ),
                    3
                )
            )
        )
        appCompatImageView.perform(scrollTo(), click())

        val appCompatImageView2 = onView(
            allOf(
                withId(R.id.ivCloseCard),
                childAtPosition(
                    allOf(
                        withId(R.id.clRoot),
                        childAtPosition(
                            withClassName(`is`("android.widget.ScrollView")),
                            0
                        )
                    ),
                    3
                )
            )
        )
        appCompatImageView2.perform(scrollTo(), click())

        val appCompatImageView3 = onView(
            allOf(
                withId(R.id.ivCloseCard),
                childAtPosition(
                    allOf(
                        withId(R.id.clRoot),
                        childAtPosition(
                            withClassName(`is`("android.widget.ScrollView")),
                            0
                        )
                    ),
                    3
                )
            )
        )
        appCompatImageView3.perform(scrollTo(), click())

        val appCompatImageView4 = onView(
            allOf(
                withId(R.id.ivCloseCard),
                childAtPosition(
                    allOf(
                        withId(R.id.clRoot),
                        childAtPosition(
                            withClassName(`is`("android.widget.ScrollView")),
                            0
                        )
                    ),
                    3
                )
            )
        )
        appCompatImageView4.perform(scrollTo(), click())

        val appCompatImageView5 = onView(
            allOf(
                withId(R.id.ivCloseCard),
                childAtPosition(
                    allOf(
                        withId(R.id.clRoot),
                        childAtPosition(
                            withClassName(`is`("android.widget.ScrollView")),
                            0
                        )
                    ),
                    3
                )
            )
        )
        appCompatImageView5.perform(scrollTo(), click())

        val appCompatImageView6 = onView(
            allOf(
                withId(R.id.ivCloseCard),
                childAtPosition(
                    allOf(
                        withId(R.id.clRoot),
                        childAtPosition(
                            withClassName(`is`("android.widget.ScrollView")),
                            0
                        )
                    ),
                    3
                )
            )
        )
        appCompatImageView6.perform(scrollTo(), click())

        val appCompatImageView7 = onView(
            allOf(
                withId(R.id.ivCloseCard),
                childAtPosition(
                    allOf(
                        withId(R.id.clRoot),
                        childAtPosition(
                            withClassName(`is`("android.widget.ScrollView")),
                            0
                        )
                    ),
                    3
                )
            )
        )
        appCompatImageView7.perform(scrollTo(), click())

        val appCompatImageView8 = onView(
            allOf(
                withId(R.id.ivCloseCard),
                childAtPosition(
                    allOf(
                        withId(R.id.clRoot),
                        childAtPosition(
                            withClassName(`is`("android.widget.ScrollView")),
                            0
                        )
                    ),
                    3
                )
            )
        )
        appCompatImageView8.perform(scrollTo(), click())

        val appCompatImageView9 = onView(
            allOf(
                withId(R.id.ivCloseCard),
                childAtPosition(
                    allOf(
                        withId(R.id.clRoot),
                        childAtPosition(
                            withClassName(`is`("android.widget.ScrollView")),
                            0
                        )
                    ),
                    3
                )
            )
        )
        appCompatImageView9.perform(scrollTo(), click())

        val appCompatImageView10 = onView(
            allOf(
                withId(R.id.ivCloseCard),
                childAtPosition(
                    allOf(
                        withId(R.id.clRoot),
                        childAtPosition(
                            withClassName(`is`("android.widget.ScrollView")),
                            0
                        )
                    ),
                    3
                )
            )
        )
        appCompatImageView10.perform(scrollTo(), click())

        val appCompatImageView11 = onView(
            allOf(
                withId(R.id.ivCloseCard),
                childAtPosition(
                    allOf(
                        withId(R.id.clRoot),
                        childAtPosition(
                            withClassName(`is`("android.widget.ScrollView")),
                            0
                        )
                    ),
                    3
                )
            )
        )
        appCompatImageView11.perform(scrollTo(), click())
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
