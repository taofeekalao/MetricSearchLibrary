import org.jetbrains.kotlinx.kandy.dsl.internal.LayerPlotContext
import org.jetbrains.kotlinx.kandy.dsl.plot
import org.jetbrains.kotlinx.kandy.ir.Plot
import org.jetbrains.kotlinx.kandy.letsplot.feature.layout
import org.jetbrains.kotlinx.kandy.letsplot.layers.hLine
import org.jetbrains.kotlinx.kandy.letsplot.layers.line
import org.jetbrains.kotlinx.kandy.letsplot.layers.vLine
import org.jetbrains.kotlinx.kandy.letsplot.settings.LineType
import org.jetbrains.kotlinx.kandy.util.color.Color
import org.jetbrains.kotlinx.statistics.math3.distribution.NormalDistribution

/**
 * This is the Cumulative Distribution CDF Plot implementation class of the Two-Dimensional interface contract.
 * It calculates the CDF using the Apache Maths Commons Library, and then plots the output using the Line graph from Kotlin Kandy.
 *
 *
 * @param yAxisDescription The x-axis description of the plot. It has a default value of "X - Axis".
 * @param xAxisDescription The y-axis description of the plot. It has a default value of "Y - Axis - Cumulative Values".
 * @param diagramDescription The general description of the plot. It has a default value of "Cumulative Distribution Function Plot".
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
 */

class CumulativeDistributionPlot @JvmOverloads constructor(
    override var yAxisDescription: String = "Y - Axis - Cumulative Values",
    override var xAxisDescription: String = "X - Axis",
    override var diagramDescription: String = "Cumulative Distribution Function Plot",
    override var colour: Color = Color.BLUE,
    override var xDataSet: List<Double>,
    override var yDataSet: List<Double> = mutableListOf<Double>(),

    var CDFDistanceValueList: List<Double> = mutableListOf<Double>(),
    mean: Double = 0.0,
    standardDeviation: Double = 1.0,
    var verticalIntersect: Boolean = false,
    var verticalIntersectValue: Double = 0.0,
    var horizontalIntersect: Boolean = false,
    var horizontalIntersectValue: Double = 0.0,
) : TwoDimensionalPlot {


    /**
     * This is the primary constructor for the implementation. It enforces checks on the datasets supplied to the class.
     */
    init {
        if (xDataSet.isEmpty()) {
            throw IllegalArgumentException("Dataset for x-axis cannot be empty")
        }

        if (yDataSet.isNotEmpty()) {
            yDataSet = mutableListOf<Double>()
        }

        computeCumulativeDistributionValues(mean, standardDeviation)
        if (CDFDistanceValueList.isEmpty()) {
            throw IllegalArgumentException("Dataset for cumulative distribution function cannot be empty")
        }
    }

    /**
     * This function is the Line Graph implementation of the plot method from the two-dimensional interface.
     * It is to plot line graph diagram based on Kotlin Kandy
     *
     * @return a Kandy internal representation plot object for rendering.
     */
    override fun plot(): Plot {
        return plot {
                line {
                    x(xDataSet)
                    y(CDFDistanceValueList)

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


    /**
     * This is a helper function to compute the cumulative distribution values using the data supplied.
     */
    private fun computeCumulativeDistributionValues(mean: Double, standardDeviation: Double) {
        val normalDistribution = NormalDistribution(mean, standardDeviation)
        CDFDistanceValueList = xDataSet.map { x ->
            normalDistribution.cumulativeProbability(x)
        }
    }
}
