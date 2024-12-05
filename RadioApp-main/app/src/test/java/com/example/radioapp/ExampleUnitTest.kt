package com.example.radioapp

import org.junit.Test
import android.content.Intent
import org.robolectric.Shadows.shadowOf
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.junit.Assert.assertEquals
import org.junit.Assert.*
import android.widget.Button
import com.IU.radioapp.R
import android.content.Context

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
}

@RunWith(RobolectricTestRunner::class)
class ExampleUnitTest2 {

    @Test
    fun whenSubmitButtonClicked_thenMainActivityIsLaunched() {
        // Create an activity controller for RatePlaylistActivity
        val controller = Robolectric.buildActivity(RatePlaylistActivity::class.java)

        // Get the activity instance
        val activity = controller.get()

        // Simulate a button click
        activity.findViewById<Button>(R.id.submitRatingButton).performClick()

        // Get the actual intent that was started
        val actualIntent = shadowOf(activity).nextStartedActivity

        // Create the expected intent
        val expectedIntent = Intent(activity, RatePlaylistActivity::class.java)

        // Check if the actual intent matches the expected intent
        assertEquals(expectedIntent.component, actualIntent.component)
    }

}




