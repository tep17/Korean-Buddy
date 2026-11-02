package com.example

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.data.CourseData
import com.example.data.HangulData
import com.example.data.VocabularyData
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [34])
class ExampleRobolectricTest {

  @Test
  fun `read string from context`() {
    val context = ApplicationProvider.getApplicationContext<Context>()
    val appName = context.getString(R.string.app_name)
    assertEquals("Korean Buddy", appName)
  }

  @Test
  fun `verify hangul alphabet data integrity`() {
    assertEquals(14, HangulData.basicConsonants.size)
    assertEquals(5, HangulData.doubleConsonants.size)
    assertEquals(10, HangulData.basicVowels.size)
    assertEquals(11, HangulData.compoundVowels.size)
    assertEquals(7, HangulData.batchimRules.size)
  }

  @Test
  fun `verify lessons and vocabulary exist`() {
    assertTrue(CourseData.allLessons.isNotEmpty())
    assertTrue(VocabularyData.items.size >= 20)
  }
}
