import org.jetbrains.kotlinx.kandy.dsl.plot
import org.jetbrains.kotlinx.kandy.ir.Plot
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
     * This is the Heatmap Plot implementation class of the Two-Dimensional interface contract.
     */
    override fun plot(): Plot {
        return plot {
            heatmap(xDataSet, yDataSet)
        }
    }
}