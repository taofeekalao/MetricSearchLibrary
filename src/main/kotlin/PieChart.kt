import org.jetbrains.kotlinx.kandy.ir.Plot
import org.jetbrains.kotlinx.kandy.letsplot.export.save
import org.jetbrains.kotlinx.kandy.util.color.Color
import org.jetbrains.kotlinx.kandy.dsl.plot
import org.jetbrains.kotlinx.kandy.letsplot.layers.crossBars


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
     * This function is the Pie Chart implementation of the plot method from the two-dimensional interface.
     * It is to plot a Pie Chart based on Kotlin Kandy
     */
    override fun plot(): Plot {
        return plot {
            crossBars {
                x(xDataSet)
                y(yDataSet)
            }
        }
    }


    /**
     * This function is the Pie Chart implementation of the save method from the two-dimensional interface.
     * It is to save the Pie Chart in the form of a static image, and it is based on Kotlin Kandy
     */
    override fun save(plot: Plot, imageName: String) {
        plot.save(imageName)
    }
}