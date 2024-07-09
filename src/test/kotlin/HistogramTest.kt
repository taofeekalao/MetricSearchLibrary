
import org.jetbrains.kotlinx.kandy.ir.Plot
import org.jetbrains.kotlinx.kandy.util.color.Color
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertEquals

class HistogramTest {

    private val xData = listOf(1.0, 2.0, 3.0)


    @Test
    fun `throws exception for empty x data set`() {
        val emptyList = emptyList<Double>()
        assertThrows<IllegalArgumentException> {
            Histogram(xDataSet = emptyList)
        }
    }

    @Test
    fun `creates Histogram object for non-empty x data set`() {
        val histogram = Histogram(xDataSet = xData)
        assertEquals(xData, histogram.xDataSet)
        assertEquals("Y - Axis", histogram.yAxisDescription)
        assertEquals("X - Axis", histogram.xAxisDescription)
        assertEquals("Histogram", histogram.diagramDescription)
        assertEquals(Color.BLUE, histogram.colour)
    }

    @Test
    fun `plot method returns a Plot object`() {
        val histogram = Histogram(xDataSet = xData)
        val plot = histogram.plot()
        assertEquals(true, plot is Plot)
    }
}
