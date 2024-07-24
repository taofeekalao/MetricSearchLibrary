import org.jetbrains.kotlinx.kandy.dsl.plot
import org.jetbrains.kotlinx.kandy.ir.Plot
import org.jetbrains.kotlinx.kandy.letsplot.feature.layout
import org.jetbrains.kotlinx.kandy.letsplot.layers.pie
import org.jetbrains.kotlinx.kandy.util.color.Color


/**
 * This is the Pie Chart implementation class of the Two-Dimensional interface contract.
 */
class PieChart(
    override var yAxisDescription: String = "Y - Axis",
    override var xAxisDescription: String = "X - Axis",
    override var diagramDescription: String = "Pie Chart",
    override var colour: Color = Color.BLUE,
    override var xDataSet: List<Double>,
    override var yDataSet: List<Double> = mutableListOf<Double>(),
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
     * This function is the Pie Chart implementation of the plot method from the two-dimensional interface.
     * It is to plot a Pie Chart based on Kotlin Kandy
     */
    override fun plot(): Plot {
        return plot {
            pie {
                x(xDataSet)
                y(yDataSet)

                x.axis.name = xAxisDescription
                y.axis.name = yAxisDescription
            }
            layout.title = diagramDescription
        }
    }
}
