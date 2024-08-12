import org.jetbrains.kotlinx.kandy.dsl.internal.LayerPlotContext
import org.jetbrains.kotlinx.kandy.dsl.plot
import org.jetbrains.kotlinx.kandy.ir.Plot
import org.jetbrains.kotlinx.kandy.letsplot.feature.layout
import org.jetbrains.kotlinx.kandy.letsplot.layers.hLine
import org.jetbrains.kotlinx.kandy.letsplot.layers.line
import org.jetbrains.kotlinx.kandy.letsplot.layers.vLine
import org.jetbrains.kotlinx.kandy.letsplot.settings.LineType
import org.jetbrains.kotlinx.kandy.util.color.Color
import org.jetbrains.kotlinx.statistics.kandy.layers.smoothLine

/**
 * This is the Line Graph implementation class of the Two-Dimensional interface contract.
 *
 *
 * @param yAxisDescription The x-axis description of the plot. It has a default value of "X - Axis".
 * @param xAxisDescription The y-axis description of the plot. It has a default value of "Y - Axis".
 * @param diagramDescription The general description of the plot. It has a default value of "Line Plot".
 * @param colour The colour of the plot object. It has a default value of Color.BLUE.
 * @param xDataSet This is the dataset for the x-axis. It is a list of Doubles.
 * @param yDataSet This is the dataset for the y-axis. It is a list of Doubles.
 * @param verticalIntersect This is the vertical intersecting line on the plot.
 * It is a boolean parameter to toggle the line.
 * It has a default value of false.
 * @param verticalIntersectValue This is the vertical intersecting line value on the plot. It has a default value of zero.
 * @param horizontalIntersect This is the horizontal intersecting line on the plot.
 *  * It is a boolean parameter to toggle the line.
 *  * It has a default value of false.
 * @param horizontalIntersectValue This is the horizontal intersecting line on the plot. It has a default value of zero.
 * @param smoothness This is a boolean flag to switch the plot to a smooth line plot.
 */

class Line @JvmOverloads constructor(
    override var yAxisDescription: String = "Y - Axis",
    override var xAxisDescription: String = "X - Axis",
    override var diagramDescription: String = "Line Graph",
    override var colour: Color = Color.BLUE,
    override var xDataSet: List<Double>,
    override var yDataSet: List<Double>,

    var verticalIntersect: Boolean = false,
    var verticalIntersectValue: Double = 0.0,
    var horizontalIntersect: Boolean = false,
    var horizontalIntersectValue: Double = 0.0,
    var smoothness: Boolean = false,
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
     * This function is the Line Graph implementation of the plot method from the two-dimensional interface.
     * It is to plot line graph diagram based on Kotlin Kandy.
     *
     * @return a Kandy internal representation plot object for rendering.
     */
    override fun plot(): Plot {
        return if (smoothness) {
            plot {
                smoothLine(xDataSet, yDataSet) {
                    x(xDataSet)
                    y(yDataSet)

                    if (verticalIntersect) {
                        plotVLine()
                    }

                    if (horizontalIntersect) {
                        plotHLine()
                    }

                    x.axis.name = xAxisDescription
                    y.axis.name = yAxisDescription
                }
                layout.title = diagramDescription
            }
        } else {
            plot {
                line {
                    x(xDataSet)
                    y(yDataSet)

                    if (verticalIntersect) {
                        plotVLine()
                    }

                    if (horizontalIntersect) {
                        plotHLine()
                    }

                    x.axis.name = xAxisDescription
                    y.axis.name = yAxisDescription
                }
                layout.title = diagramDescription
            }
        }
    }


    /**
     * This is a helper function to plot a vertical line on the chart using the data supplied.
     */
    private fun LayerPlotContext.plotVLine() {
        vLine {
            xIntercept.constant(verticalIntersectValue)
            color = Color.RED
            type = LineType.DASHED
        }
    }


    /**
     * This is a helper function to plot a horizontal line on the chart using the data supplied.
     */
    private fun LayerPlotContext.plotHLine() {
        hLine {
            yIntercept.constant(horizontalIntersectValue)
            color = Color.RED
            type = LineType.DASHED
        }
    }
}
