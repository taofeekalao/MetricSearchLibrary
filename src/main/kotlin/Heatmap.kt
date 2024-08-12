import org.jetbrains.kotlinx.kandy.dsl.plot
import org.jetbrains.kotlinx.kandy.ir.Plot
import org.jetbrains.kotlinx.kandy.letsplot.feature.layout
import org.jetbrains.kotlinx.kandy.letsplot.layers.points
import org.jetbrains.kotlinx.kandy.letsplot.x
import org.jetbrains.kotlinx.kandy.letsplot.y
import org.jetbrains.kotlinx.kandy.util.color.Color
import org.jetbrains.kotlinx.statistics.kandy.stattransform.statCount2D


/**
 * This is the Heatmap diagram implementation class of the Two-Dimensional interface contract.
 *
 *
 * @param yAxisDescription The x-axis description of the plot. It has a default value of "X - Axis".
 * @param xAxisDescription The y-axis description of the plot. It has a default value of "Y - Axis".
 * @param diagramDescription The general description of the plot. It has a default value of "Heatmap Diagram".
 * @param colour The colour of the plot object. It has a default value of Color.BLUE.
 * @param xDataSet This is the dataset for the x-axis. It is a list of Doubles.
 * @param yDataSet This is the dataset for the y-axis. It is a list of Doubles.
 * @param plotColour This is the plot colour for the heatmap plot.  It has a default value of Color.RED.
 */
class Heatmap @JvmOverloads constructor(
    override var yAxisDescription: String = "Y - Axis",
    override var xAxisDescription: String = "X - Axis",
    override var diagramDescription: String = "Heatmap Diagram",
    override var colour: Color = Color.BLUE,
    override var xDataSet: List<Double>,
    override var yDataSet: List<Double>,

    var plotColour: Color = Color.RED,
) : TwoDimensionalPlot {


    /**
     * This is the primary constructor for the implementation. It enforces checks on the datasets supplied to the class.
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
     *
     * @return a Kandy internal representation plot object for rendering.
     */
    override fun plot(): Plot {
        return plot {
            statCount2D(xDataSet, yDataSet) {
                points {
                    x(Stat.x)
                    y(Stat.y)
                    color = plotColour
                }
            }

            x.axis.name = xAxisDescription
            y.axis.name = yAxisDescription

            layout.title = diagramDescription
        }
    }
}