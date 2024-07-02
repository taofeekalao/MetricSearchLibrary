
import com.metric.search.visualisation.Line
import org.jetbrains.kotlinx.kandy.util.color.Color
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

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
}