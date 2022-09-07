package com.example.realmdatabase



import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkAllComponentIsVisible_isSuccess() {
        onView(withId(R.id.fabAddContact))
            .check(matches(isDisplayed()))
            .perform(click())

        val name = "N"

        onView(withId(R.id.etName))
            .check(matches(isDisplayed()))
            .perform(typeText(name))
            .check(matches(withText(name)))// набирает текст

        val surname = "P"

        onView(withId(R.id.etSurname))
            .check(matches(isDisplayed()))
            .perform(typeText(surname))
            .check(matches(withText(surname)))

        val phone = "+799999999"

        onView(withId(R.id.etNumber))
            .check(matches(isDisplayed()))
            .perform(typeText(phone))
            .check(matches(withText(phone)))

        onView(withId(R.id.btnSave))
            .check(matches(isDisplayed()))
            .perform(click())

//        onView(withId(R.id.rvContacts))
//            .check(matches(isDisplayed()))
//        onView(withId(R.id.rvContacts))
//            .check(matches(isDisplayed()))
//            .perform(click())

        onView(withId(R.id.rvContacts))
            .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(1,
                clickChildViewWithId(R.id.tvEdit)))

//        onView(withId(R.id.rvContacts))
//            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(17))
//            .perform(RecyclerViewActions.actionOnItem<RecyclerView.ViewHolder>(withId(R.id.tvEdit), click()))
//            .check(matches(isDisplayed()))
//            .perform(click())
        val newName = "f"

        onView(withId(R.id.etName))
            .check(matches(isDisplayed()))
            .perform(setTextInTextView(newName))
            .check(matches(withText(newName)))// набирает текст

        val newSurname2 = "f"

        onView(withId(R.id.etSurname))
            .check(matches(isDisplayed()))
            .perform(setTextInTextView(newSurname2))
            .check(matches(withText(newSurname2)))

        val newPhone = "+"

        onView(withId(R.id.etNumber))
            .check(matches(isDisplayed()))
            .perform(setTextInTextView(newPhone))
            .check(matches(withText(newPhone)))

        onView(withId(R.id.btnSaveChanges))
            .check(matches(isDisplayed()))
            .perform(click())

        onView(withId(R.id.fabAddContact))
            .check(matches(isDisplayed()))
            .perform(click())

        val nameToAdd = "Anastasiya"

        onView(withId(R.id.etName))
            .check(matches(isDisplayed()))
            .perform(typeText(nameToAdd))
            .check(matches(withText(nameToAdd)))// набирает текст

        val surnameToAdd = "Lytneva"

        onView(withId(R.id.etSurname))
            .check(matches(isDisplayed()))
            .perform(typeText(surnameToAdd))
            .check(matches(withText(surnameToAdd)))

        val phoneToAdd = "+7777777777"

        onView(withId(R.id.etNumber))
            .check(matches(isDisplayed()))
            .perform(typeText(phoneToAdd))
            .check(matches(withText(phoneToAdd)))

        onView(withId(R.id.btnSave))
            .check(matches(isDisplayed()))
            .perform(click())

        onView(withId(R.id.rvContacts))
            .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(2,
                clickChildViewWithId(R.id.tvEdit)))
        // Тест экрана редактирования
        onView(withId(R.id.btnDelete))
            .check(matches(isDisplayed()))
            .perform(click())

        onView(withId(R.id.rvContacts))
            .check(matches(isDisplayed()))

    }

}