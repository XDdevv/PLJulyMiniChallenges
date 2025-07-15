package zed.rainxch.pljulyminichallenges

import org.junit.Test

import org.junit.Assert.*
import zed.rainxch.pljulyminichallenges.test.getSeperatorText

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

    @Test
    fun `Test apply seperator text with comma`() {
        // , dot, space
        val (text, char) = "1000" to ','

        val result = getSeperatorText(text, char)

        assertEquals("1,000", result)
    }
}