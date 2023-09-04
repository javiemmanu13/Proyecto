package com.example.miproyectojavierheredia

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.miproyectojavierheredia.View.MainActivity
import com.example.proyectofinal.R
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class MainActivityTest {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun MainActivityComparador() {
        ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.primerTexto)).perform(typeText("Hola"), closeSoftKeyboard())
        onView(withId(R.id.segundoTexto)).perform(typeText("Hola"), closeSoftKeyboard())
        onView(withId(R.id.botonComparar)).perform(click())
        onView(withId(R.id.resultado)).check(matches(withText("Los textos son iguales")))
    }
}
