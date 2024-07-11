import org.jetbrains.kotlinx.kandy.dsl.plot
import org.jetbrains.kotlinx.kandy.ir.Plot
import org.jetbrains.kotlinx.kandy.letsplot.export.save
import org.jetbrains.kotlinx.kandy.util.color.Color
import org.jetbrains.kotlinx.statistics.kandy.layers.densityPlot


/**
 * This is the Density Plot implementation class of the Two-Dimensional interface contract.
 */
class DensityPlot(
    override var yAxisDescription: String = "Y - Axis",
    override var xAxisDescription: String = "X - Axis",
    override var diagramDescription: String = "Pie Chart",
    override var colour: Color = Color.BLUE,
    override var xDataSet: List<Double>,
    override var yDataSet: List<Double> = mutableListOf<Double>(),
) : TwoDimensionalPlot {


    /**
     * This is the Density Plot implementation class of the Two-Dimensional interface contract.
     */
    override fun plot(): Plot {
        return plot {
            densityPlot(xDataSet)
        }
    }

    /**
     * This function is the Density Plot implementation of the plot method from the two-dimensional interface.
     * It is to plot a Density Plot based on Kotlin Kandy
     */
    override fun save(plot: Plot, imageName: String) {
        plot.save(imageName)
    }
}