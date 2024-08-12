import org.jetbrains.kotlinx.kandy.util.color.Color
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class DensityPlotTest {

    private val xData = listOf(1.0, 2.0, 3.0)
    private val yData = listOf(2.0, 4.0, 1.0)

    @Test
    fun `test DensityPlot initialization`() {
        val densityPlot = DensityPlot("Y - Axis", "X - Axis", "Density Plot", Color.BLUE, xData, emptyList(), 1.0, Color.BLUE, Color.GREEN, 1.0)

        assertNotNull(densityPlot)
        assertEquals("Y - Axis", densityPlot.yAxisDescription)
        assertEquals("X - Axis", densityPlot.xAxisDescription)
        assertEquals("Density Plot", densityPlot.diagramDescription)
        assertEquals(Color.BLUE, densityPlot.colour)
        assertEquals(xData, densityPlot.xDataSet)
    }

    @Test
    fun `test DensityPlot with empty xDataSet`() {
        assertThrows(IllegalArgumentException::class.java) {
            DensityPlot("Y - Axis", "X - Axis", "Density Plot", Color.BLUE, emptyList(), emptyList(), 1.0, Color.BLUE, Color.GREEN, 1.0)
        }
    }

    @Test
    fun `test DensityPlot plot creation`() {
        val densityPlot = DensityPlot("Y - Axis", "X - Axis", "Density Plot", Color.BLUE, xData, emptyList(), 1.0, Color.BLUE, Color.GREEN, 1.0)
        val plot = densityPlot.plot()

        assertNotNull(plot)
    }

    @Test
    fun `test DensityPlot save`() {
        val densityPlot = DensityPlot("Y - Axis", "X - Axis", "Density Plot", Color.BLUE, xData, emptyList(), 1.0, Color.BLUE, Color.GREEN, 1.0)
        val plot = densityPlot.plot()

        assertDoesNotThrow {
            densityPlot.save(plot, "density_plot_test.png")
        }
    }
}
