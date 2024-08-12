import org.jetbrains.kotlinx.kandy.util.color.Color
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.Assertions.*
import java.lang.IllegalArgumentException

class LineTest {

    private val xData = listOf(1.0, 2.0, 3.0)
    private val yData = listOf(2.0, 4.0, 1.0)

    @Test
    fun `throws exception for empty x data set`() {
        val emptyList = emptyList<Double>()
        assertThrows<IllegalArgumentException> {
            Line(xDataSet = emptyList, yDataSet = yData)
        }
    }

    @Test
    fun `throws exception for empty y data set`() {
        val emptyList = emptyList<Double>()
        assertThrows<IllegalArgumentException> {
            Line(xDataSet = xData, yDataSet = emptyList)
        }
    }

    @Test
    fun `creates Line object for non-empty x and y data sets`() {
        val line = Line(xDataSet = xData, yDataSet = yData)
        assertEquals(xData, line.xDataSet)
        assertEquals(yData, line.yDataSet)
        assertEquals("Y - Axis", line.yAxisDescription)
        assertEquals("X - Axis", line.xAxisDescription)
        assertEquals("Line Graph", line.diagramDescription)
        assertEquals(Color.BLUE, line.colour)
    }

    @Test
    fun `test Line plot creation`() {
        val line = Line("Y - Axis", "X - Axis", "Line Graph", Color.BLUE, xData, yData, false, 0.0, false, 0.0, false)
        val plot = line.plot()

        assertNotNull(plot)
    }

    @Test
    fun `test Line save`() {
        val line = Line("Y - Axis", "X - Axis", "Line Graph", Color.BLUE, xData, yData, false, 0.0, false, 0.0, false)
        val plot = line.plot()

        assertDoesNotThrow {
            line.save(plot, "line_test.png")
        }
    }
}