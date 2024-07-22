import org.jetbrains.kotlinx.kandy.util.color.Color
import org.jetbrains.kotlinx.kandy.dsl.plot
import org.jetbrains.kotlinx.kandy.ir.Plot
import org.jetbrains.kotlinx.kandy.letsplot.layers.points
import org.jetbrains.kotlinx.kandy.letsplot.settings.Symbol

/**
 * This is the Scatter plot implementation class of the Two-Dimensional interface contract.
 */
class Scatter(
    override var yAxisDescription: String = "Y - Axis",
    override var xAxisDescription: String = "X - Axis",
    override var diagramDescription: String = "Scatter Plot",
    override var colour: Color = Color.BLUE,
    override var xDataSet: List<Double>,
    override var yDataSet: List<Double>
) : TwoDimensionalPlot {

    /**
     * This is the primary constructor for the implementation.
     */
    init {
        if (xDataSet.isEmpty()) {
            throw IllegalArgumentException("Dataset for x-axis cannot be empty")
        }

        if (yDataSet.isEmpty()) {
            throw IllegalArgumentException("Dataset for y-axis cannot be empty")
        }
    }

    /**
     * This function is the Scatter Plot implementation of the plot method from the two-dimensional interface.
     * It is to plot scatter plot diagram based on Kotlin Kandy
     */
    override fun plot(): Plot {
        return plot {
            points {
                x(xDataSet)
                y(yDataSet)
                symbol = Symbol.CIRCLE_OPEN
            }
        }
    }
}


