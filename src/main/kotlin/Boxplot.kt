import org.jetbrains.kotlinx.kandy.ir.Plot
import org.jetbrains.kotlinx.kandy.letsplot.export.save
import org.jetbrains.kotlinx.kandy.dsl.plot
import org.jetbrains.kotlinx.kandy.util.color.Color
import org.jetbrains.kotlinx.statistics.kandy.layers.boxplot


/**
 * This is the Boxplot diagram implementation class of the Two-Dimensional interface contract.
 */
class Boxplot(
    override var yAxisDescription: String = "Y - Axis",
    override var xAxisDescription: String = "X - Axis",
    override var diagramDescription: String = "Boxplot Diagram",
    override var colour: Color = Color.BLUE,
    override var xDataSet: List<Double>,
    override var yDataSet: List<Double> = mutableListOf<Double>(),
) : TwoDimensionalPlot {

    /**
     * This is the primary constructor for the implementation.
     */
    init {
        if (xDataSet.isEmpty()) {
            throw IllegalArgumentException("xDataSet or yDataSet can't be empty")
        }

        if (yDataSet.isNotEmpty()) {
            yDataSet= mutableListOf<Double>()
        }
    }

    /**
     * This function is the Boxplot Diagram implementation of the plot method from the two-dimensional interface.
     * It is to plot a Boxplot diagram based on Kotlin Kandy
     */
    override fun plot(): Plot {
        return plot {
            boxplot(xDataSet)
        }
    }

    /**
     * This function is the Boxplot Diagram implementation of the save method from the two-dimensional interface.
     * It is to save the Boxplot diagram in the form of a static image, and it is based on Kotlin Kandy
     */
    override fun save(plot: Plot, imageName: String) {
        plot.save(imageName)
    }
}