import org.jetbrains.kotlinx.kandy.ir.Plot
import org.jetbrains.kotlinx.kandy.letsplot.settings.Symbol
import org.jetbrains.kotlinx.kandy.util.color.Color
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ScatterTest {

    private val xData = listOf(1.0, 2.0, 3.0)
    private val yData = listOf(2.0, 4.0, 1.0)

    @Test
    fun `throws exception for empty x data set`() {
        val emptyList = emptyList<Double>()
        assertThrows<IllegalArgumentException> { Scatter(xDataSet = emptyList, yDataSet = yData) }
    }

    @Test
    fun `throws exception for empty y data set`() {
        val emptyList = emptyList<Double>()
        assertThrows<IllegalArgumentException> { Scatter(xDataSet = xData, yDataSet = emptyList) }
    }

    @Test
    fun `plot method returns a Plot object`() {
        val scatterPlot = Scatter(xDataSet = xData, yDataSet = yData)
        val plot = scatterPlot.plot()
        assertEquals(true, plot is Plot)
    }

    @Test
    fun `test Scatter save`() {
        val scatter = Scatter("Y - Axis", "X - Axis", "Scatter Plot", Color.BLUE, xData, yData, false, 0.5, 3.0, Color.RED, Symbol.CIRCLE_OPEN)
        val plot = scatter.plot()

        assertDoesNotThrow {
            scatter.save(plot, "scatter_test.png")
        }
    }

    @Test
    fun `test Scatter initialization`() {
        val scatter = Scatter("Y - Axis", "X - Axis", "Scatter Plot", Color.BLUE, xData, yData, false, 0.5, 3.0, Color.RED, Symbol.CIRCLE_OPEN)

        assertNotNull(scatter)
        assertEquals("Y - Axis", scatter.yAxisDescription)
        assertEquals("X - Axis", scatter.xAxisDescription)
        assertEquals("Scatter Plot", scatter.diagramDescription)
        assertEquals(Color.BLUE, scatter.colour)
        assertEquals(xData, scatter.xDataSet)
        assertEquals(yData, scatter.yDataSet)
    }

    @Test
    fun `test Scatter plot creation`() {
        val scatter = Scatter("Y - Axis", "X - Axis", "Scatter Plot", Color.BLUE, xData, yData, false, 0.5, 3.0, Color.RED, Symbol.CIRCLE_OPEN)
        val plot = scatter.plot()

        assertNotNull(plot)
    }
}

