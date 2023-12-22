import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class EvaluatorTest {

    @Test
    fun testEvaluate() {
        var table = Array(5) { Array(10) { Lesson(0u, 0u, 0u, 0u,true) } }
        var timetable = Timetable(table)
        val evaluator = Evaluator()

        table[0][0] = Lesson(1u, 23u, 1u, 4u, true)
        table[0][1] = Lesson(2u, 23u, 2u, 4u, true)
        table[0][2] = Lesson(3u, 23u, 3u, 4u, true)
        table[0][3] = Lesson(4u, 23u, 4u, 4u, true)
        table[0][4] = Lesson(4u, 23u, 4u, 4u, true)
        table[0][5] = Lesson(5u, 23u, 5u, 4u, true)
        table[0][6] = Lesson(0u, 0u, 0u, 0u, true)
        table[0][7] = Lesson(6u, 19u, 6u, 3u, false)
        table[0][8] = Lesson(6u, 19u, 6u, 3u, false)
        table[0][9] = Lesson(0u, 0u, 0u, 0u, true)
        table[1][0] = Lesson(4u, 23u, 4u, 4u, true)
        table[1][1] = Lesson(3u, 29u, 3u, 4u, true)
        table[1][2] = Lesson(7u, 17u, 7u, 3u, false)
        table[1][3] = Lesson(7u, 17u, 7u, 3u, false)
        table[1][4] = Lesson(0u, 0u, 0u, 0u, true)
        table[1][5] = Lesson(8u, 23u, 8u, 4u, true)
        table[1][6] = Lesson(9u, 18u, 9u, 3u, false)
        table[1][7] = Lesson(9u, 18u, 9u, 3u, false)
        table[1][8] = Lesson(10u, 1u, 10u, 10u, false)
        table[1][9] = Lesson(0u, 0u, 0u, 0u, true)
        table[2][0] = Lesson(0u, 0u, 0u, 0u, true)
        table[2][1] = Lesson(3u, 23u, 3u, 4u, true)
        table[2][2] = Lesson(8u, 23u, 8u,4u,  true)
        table[2][3] = Lesson(11u, 23u, 11u, 4u, true)
        table[2][4] = Lesson(6u, 23u, 6u, 4u, true)
        table[2][5] = Lesson(12u, 8u, 12u, 2u, false)
        table[2][6] = Lesson(12u, 8u, 12u, 2u, false)
        table[2][7] = Lesson(0u, 0u, 0u, 0u, true)
        table[2][8] = Lesson(0u, 0u, 0u, 0u, true)
        table[2][9] = Lesson(0u, 0u, 0u, 0u, true)
        table[3][0] = Lesson(11u, 19u, 13u, 3u, false)
        table[3][1] = Lesson(11u, 19u, 13u, 3u, false)
        table[3][2] = Lesson(4u, 23u, 4u, 4u, true)
        table[3][3] = Lesson(3u, 23u, 3u, 4u, true)
        table[3][4] = Lesson(9u, 23u, 9u, 4u, true)
        table[3][5] = Lesson(5u, 19u, 5u, 3u, false)
        table[3][6] = Lesson(5u, 19u, 5u, 3u, false)
        table[3][7] = Lesson(0u, 0u, 0u, 0u, true)
        table[3][8] = Lesson(0u, 0u, 0u, 0u, true)
        table[3][9] = Lesson(0u, 0u, 0u, 0u, true)
        table[4][0] = Lesson(0u, 0u, 0u, 0u, true)
        table[4][1] = Lesson(8u, 23u, 8u, 4u, true)
        table[4][2] = Lesson(12u, 23u, 14u, 4u, true)
        table[4][3] = Lesson(2u, 23u, 2u, 4u, true)
        table[4][4] = Lesson(5u, 23u, 5u, 4u, true)
        table[4][5] = Lesson(10u, 1u, 10u, 10u, true)
        table[4][6] = Lesson(0u, 0u, 0u, 0u, true)
        table[4][7] = Lesson(0u, 0u, 0u, 0u, true)
        table[4][8] = Lesson(0u, 0u, 0u, 0u, true)
        table[4][9] = Lesson(0u, 0u, 0u, 0u, true)

        val result = evaluator.evaluate(table)

        val expectedResult = 307.toUShort()
        assertEquals(expectedResult, result)

    }

}
