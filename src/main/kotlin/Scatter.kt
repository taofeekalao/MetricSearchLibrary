import org.jetbrains.kotlinx.kandy.dsl.plot
import org.jetbrains.kotlinx.kandy.ir.Plot
import org.jetbrains.kotlinx.kandy.letsplot.feature.layout
import org.jetbrains.kotlinx.kandy.letsplot.layers.abLine
import org.jetbrains.kotlinx.kandy.letsplot.layers.points
import org.jetbrains.kotlinx.kandy.letsplot.settings.Symbol
import org.jetbrains.kotlinx.kandy.util.color.Color

/**
 * This is the Scatter plot implementation class of the Two-Dimensional interface contract.
 *
 *
 * @param yAxisDescription The x-axis description of the plot. It has a default value of "X - Axis".
 * @param xAxisDescription The y-axis description of the plot. It has a default value of "Y - Axis".
 * @param diagramDescription The general description of the plot. It has a default value of "Scatter Diagram".
 * @param colour The colour of the plot object. It has a default value of Color.BLUE.
 * @param xDataSet This is the dataset for the x-axis. It is a list of Doubles.
 * @param yDataSet This is the dataset for the y-axis. It is a list of Doubles.
 * @param slopeConstant This is the slope constant value of the plot. It has a default value of 0.5.
 * @param interceptConstant This is the intersecting constant value of the plot. It has a default value of 3.0.
 * @param abLineOption This is abLine flag to toggle the line option of the plot.
 * @param abLineColor This is the colour for the plot. It has a default value of Color.RED.
 * @param pointSymbol This is the symbol for the plot.  It has a default value of Symbol.CIRCLE_OPEN.
 */
class Scatter @JvmOverloads constructor(
    override var yAxisDescription: String = "Y - Axis",
    override var xAxisDescription: String = "X - Axis",
    override var diagramDescription: String = "Scatter Plot",
    override var colour: Color = Color.BLUE,
    override var xDataSet: List<Double>,
    override var yDataSet: List<Double>,

    var abLineOption: Boolean = false,
    var slopeConstant: Double = 0.5,
    var interceptConstant: Double = 3.0,
    var abLineColor: Color = Color.RED,
    var pointSymbol: Symbol = Symbol.CIRCLE_OPEN

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
     * This function is the Scatter Plot implementation of the plot method from the two-dimensional interface.
     * It is to plot scatter plot diagram based on Kotlin Kandy.
     *
     * @return a Kandy internal representation plot object for rendering.
     */
    override fun plot(): Plot {
        return plot {
            points {
                x(xDataSet)
                y(yDataSet)
                symbol = pointSymbol

                x.axis.name = xAxisDescription
                y.axis.name = yAxisDescription
            }

            if (abLineOption) {
                abLine {
                    slope.constant(slopeConstant)
                    intercept.constant(interceptConstant)
                    color = abLineColor
                }
            }
            layout.title = diagramDescription
        }
    }
}
