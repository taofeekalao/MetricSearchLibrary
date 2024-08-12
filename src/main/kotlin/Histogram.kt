import org.jetbrains.kotlinx.kandy.dsl.plot
import org.jetbrains.kotlinx.kandy.ir.Plot
import org.jetbrains.kotlinx.kandy.letsplot.feature.layout
import org.jetbrains.kotlinx.kandy.letsplot.layers.bars
import org.jetbrains.kotlinx.kandy.letsplot.layers.line
import org.jetbrains.kotlinx.kandy.letsplot.x
import org.jetbrains.kotlinx.kandy.letsplot.y
import org.jetbrains.kotlinx.kandy.util.color.Color
import org.jetbrains.kotlinx.statistics.binning.BinsOption
import org.jetbrains.kotlinx.statistics.kandy.stattransform.context.StatBinLayerCollectorContext
import org.jetbrains.kotlinx.statistics.kandy.stattransform.statBin

/**
 * This is the Histogram diagram implementation class of the Two-Dimensional interface contract.
 *
 * @param yAxisDescription The x-axis description of the plot. It has a default value of "X - Axis".
 * @param xAxisDescription The y-axis description of the plot. It has a default value of "Y - Axis".
 * @param diagramDescription The general description of the plot. It has a default value of "Histogram Plot".
 * @param colour The colour of the plot object. It has a default value of Color.BLUE.
 * @param xDataSet This is the dataset for the x-axis. It is a list of Doubles.
 * @param yDataSet This is the dataset for the y-axis. It is a list of Doubles.
 * @param lineColour - This is the line colour for the plot. It has a default value of Color.BLACK.
 * @param BinsOptionByNumber This is the bin option value for statistics bin API of the plot. It has a default value of 10.
 * @param lineOption TThis is a boolean flag to toggle line on the plot.
 */
class Histogram @JvmOverloads constructor(
    override var yAxisDescription: String = "Y - Axis",
    override var xAxisDescription: String = "X - Axis",
    override var diagramDescription: String = "Histogram Plot",
    override var colour: Color = Color.BLUE,
    override var xDataSet: List<Double>,
    override var yDataSet: List<Double> = mutableListOf<Double>(),

    var lineOption: Boolean = false,
    var BinsOptionByNumber: Int = 10,
    var lineColour: Color = Color.BLACK,
) : TwoDimensionalPlot {

    /**
     * This is the primary constructor for the implementation. It enforces checks on the datasets supplied to the class.
     *
     */
    init {
        if (xDataSet.isEmpty()) {
            throw IllegalArgumentException("xDataSet can't be empty")
        }

        if (yDataSet.isNotEmpty()) {
            yDataSet = mutableListOf<Double>()
        }
    }

    /**
     * This function is the Histogram Diagram implementation of the plot method from the two-dimensional interface.
     * It is to plot the Histogram diagram based on the Kotlin Kandy library.
     * It can switch off or on a line plot over the bars in the histogram plot.
     *
     * @return a Kandy internal representation plot object for rendering.
     */
    override fun plot(): Plot {
        if (lineOption) {
            return plot {
                statBin(xDataSet, binsOption = BinsOption.byNumber(BinsOptionByNumber)) {
                    plotBar()
                    plotLine()

                    x.axis.name = xAxisDescription
                    y.axis.name = yAxisDescription
                }
                layout.title = diagramDescription
            }
        } else {
            return plot {
                statBin(xDataSet, binsOption = BinsOption.byNumber(BinsOptionByNumber)) {
                    plotBar()
                    x.axis.name = xAxisDescription
                    y.axis.name = yAxisDescription
                }
                layout.title = diagramDescription
            }
        }
    }

    /**
     * This is a helper function to plot a line graph using the data supplied.
     */
    private fun StatBinLayerCollectorContext.plotLine() {
        line {
            x(Stat.x)
            y(Stat.count)
            color = lineColour
        }
    }

    /**
     * This is a helper function to plot a bar chart using the data supplied.
     */
    private fun StatBinLayerCollectorContext.plotBar() {
        bars {
            x(Stat.x)
            y(Stat.count)
        }
    }
}
