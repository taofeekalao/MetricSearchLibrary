import org.jetbrains.kotlinx.kandy.util.color.Color
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class HeatmapTest {

    private val xData = listOf(1.0, 2.0, 3.0)
    private val yData = listOf(2.0, 4.0, 1.0)

    @Test
    fun `test Heatmap initialization`() {
        val heatmap = Heatmap("Y - Axis", "X - Axis", "Heatmap", Color.BLUE, xData, yData)

        assertNotNull(heatmap)
        assertEquals("Y - Axis", heatmap.yAxisDescription)
        assertEquals("X - Axis", heatmap.xAxisDescription)
        assertEquals("Heatmap", heatmap.diagramDescription)
        assertEquals(Color.BLUE, heatmap.colour)
        assertEquals(xData, heatmap.xDataSet)
        assertEquals(yData, heatmap.yDataSet)
    }

    @Test
    fun `test Heatmap with empty xDataSet`() {
        assertThrows(IllegalArgumentException::class.java) {
            Heatmap("Y - Axis", "X - Axis", "Heatmap", Color.BLUE, emptyList(), listOf(4.0, 5.0, 6.0))
        }
    }

    @Test
    fun `test Heatmap with empty yDataSet`() {
        assertThrows(IllegalArgumentException::class.java) {
            Heatmap("Y - Axis", "X - Axis", "Heatmap", Color.BLUE, listOf(1.0, 2.0, 3.0), emptyList())
        }
    }

    @Test
    fun `test Heatmap plot creation`() {
        val heatmap = Heatmap("Y - Axis", "X - Axis", "Heatmap", Color.BLUE, xData, yData)
        val plot = heatmap.plot()

        assertNotNull(plot)
    }

    @Test
    fun `test Heatmap save`() {
        val heatmap = Heatmap("Y - Axis", "X - Axis", "Heatmap", Color.BLUE, xData, yData)
        val plot = heatmap.plot()

        assertDoesNotThrow {
            heatmap.save(plot, "heatmap_test.png")
        }
    }
}
