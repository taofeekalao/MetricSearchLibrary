import org.jetbrains.kotlinx.kandy.util.color.Color
import org.jetbrains.kotlinx.kandy.letsplot.settings.Symbol
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

class BoxplotTest {

    private val xData = listOf(1.0, 2.0, 3.0)
    private val yData = listOf(2.0, 4.0, 1.0)

    @Test
    fun `test Boxplot initialization`() {
        val boxplot = Boxplot("Y - Axis", "X - Axis", "Boxplot Diagram", Color.BLUE, xData, emptyList(), Color.BLACK, Color.BLACK, Symbol.DIAMOND)

        assertNotNull(boxplot)
        assertEquals("Y - Axis", boxplot.yAxisDescription)
        assertEquals("X - Axis", boxplot.xAxisDescription)
        assertEquals("Boxplot Diagram", boxplot.diagramDescription)
        assertEquals(Color.BLUE, boxplot.colour)
        assertEquals(xData, boxplot.xDataSet)
    }

    @Test
    fun `test Boxplot with empty xDataSet`() {
        assertThrows(IllegalArgumentException::class.java) {
            Boxplot("Y - Axis", "X - Axis", "Boxplot Diagram", Color.BLUE, emptyList(), emptyList(), Color.BLACK, Color.BLACK, Symbol.DIAMOND)
        }
    }

    @Test
    fun `test Boxplot plot creation`() {
        val boxplot = Boxplot("Y - Axis", "X - Axis", "Boxplot Diagram", Color.BLUE, xData, emptyList(), Color.BLACK, Color.BLACK, Symbol.DIAMOND)
        val plot = boxplot.plot()

        assertNotNull(plot)
    }

    @Test
    fun `test Boxplot save`() {
        val boxplot = Boxplot("Y - Axis", "X - Axis", "Boxplot Diagram", Color.BLUE, xData, emptyList(), Color.BLACK, Color.BLACK, Symbol.DIAMOND)
        val plot = boxplot.plot()

        assertDoesNotThrow {
            boxplot.save(plot, "boxplot_test.png")
        }
    }
}
