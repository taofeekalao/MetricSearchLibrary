import org.jetbrains.kotlinx.kandy.util.color.Color
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CumulativeDistributionPlotTest {

    private val xData = listOf(1.0, 2.0, 3.0)
    private val yData = listOf(2.0, 4.0, 1.0)

    @Test
    fun `test CDFPlot initialization`() {
        val cdfPlot = CumulativeDistributionPlot("Y - Axis", "X - Axis", "CDF Plot", Color.BLUE, xData, emptyList(), emptyList(), 0.0, 1.0, false, 0.0, false, 0.0)

        assertNotNull(cdfPlot)
        assertEquals("Y - Axis", cdfPlot.yAxisDescription)
        assertEquals("X - Axis", cdfPlot.xAxisDescription)
        assertEquals("CDF Plot", cdfPlot.diagramDescription)
        assertEquals(Color.BLUE, cdfPlot.colour)
        assertEquals(xData, cdfPlot.xDataSet)
    }

    @Test
    fun `test CDFPlot with empty xDataSet`() {
        assertThrows(IllegalArgumentException::class.java) {
            CumulativeDistributionPlot("Y - Axis", "X - Axis", "CDF Plot", Color.BLUE, emptyList(), emptyList(), emptyList(), 0.0, 1.0, false, 0.0, false, 0.0)
        }
    }

    @Test
    fun `test CDFPlot plot creation`() {
        val cdfPlot = CumulativeDistributionPlot("Y - Axis", "X - Axis", "CDF Plot", Color.BLUE, xData, emptyList(), emptyList(), 0.0, 1.0, false, 0.0, false, 0.0)
        val plot = cdfPlot.plot()

        assertNotNull(plot)
    }

    @Test
    fun `test CDFPlot save`() {
        val cdfPlot = CumulativeDistributionPlot("Y - Axis", "X - Axis", "CDF Plot", Color.BLUE, xData, emptyList(), emptyList(), 0.0, 1.0, false, 0.0, false, 0.0)
        val plot = cdfPlot.plot()

        assertDoesNotThrow {
            cdfPlot.save(plot, "cdf_plot_test.png")
        }
    }
}
