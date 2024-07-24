import org.jetbrains.kotlinx.kandy.dsl.plot
import org.jetbrains.kotlinx.kandy.ir.Plot
import org.jetbrains.kotlinx.kandy.letsplot.feature.layout
import org.jetbrains.kotlinx.kandy.letsplot.x
import org.jetbrains.kotlinx.kandy.letsplot.y
import org.jetbrains.kotlinx.kandy.util.color.Color
import org.jetbrains.kotlinx.statistics.kandy.statplots.heatmap

class Heatmap(
    override var yAxisDescription: String,
    override var xAxisDescription: String,
    override var diagramDescription: String,
    override var colour: Color,
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
     * This is the Heatmap Plot implementation class of the Two-Dimensional interface contract.
     */
    override fun plot(): Plot {
        return plot {
            heatmap(xDataSet, yDataSet)

            x.axis.name = xAxisDescription
            y.axis.name = yAxisDescription

            layout.title = diagramDescription
        }
    }
}