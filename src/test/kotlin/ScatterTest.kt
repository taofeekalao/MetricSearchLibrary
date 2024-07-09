import org.jetbrains.kotlinx.kandy.ir.Plot
import org.junit.jupiter.api.Assertions.assertEquals
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
}

