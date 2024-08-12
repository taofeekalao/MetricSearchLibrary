import org.jetbrains.kotlinx.kandy.dsl.plot
import org.jetbrains.kotlinx.kandy.ir.Plot
import org.jetbrains.kotlinx.kandy.letsplot.feature.layout
import org.jetbrains.kotlinx.kandy.letsplot.settings.Symbol
import org.jetbrains.kotlinx.kandy.letsplot.x
import org.jetbrains.kotlinx.kandy.letsplot.y
import org.jetbrains.kotlinx.kandy.util.color.Color
import org.jetbrains.kotlinx.statistics.kandy.layers.boxplot

/**
 * This is the Boxplot diagram implementation class of the Two-Dimensional interface contract.
 *
 *
 * @param yAxisDescription The x-axis description of the plot. It has a default value of "X - Axis".
 * @param xAxisDescription The y-axis description of the plot. It has a default value of "Y - Axis".
 * @param diagramDescription The general description of the plot. It has a default value of "Boxplot Diagram".
 * @param colour The colour of the plot object. It has a default value of Color.BLUE.
 * @param xDataSet This is the dataset for the x-axis. It is a list of Doubles.
 * @param yDataSet This is the dataset for the y-axis. It is a list of Doubles.
 * @param boxplotFillColor This is the fill colour for the box plot.  It has a default value of Color.BLACK.
 * @param boxplotColor This is the colour for the box plot.  It has a default value of Color.BLACK.
 * @param boxplotSymbol This is the symbol for the box plot.  It has a default value of Symbol.DIAMOND.
 */

class Boxplot @JvmOverloads constructor(
    override var yAxisDescription: String = "Y - Axis",
    override var xAxisDescription: String = "X - Axis",
    override var diagramDescription: String = "Boxplot Diagram",
    override var colour: Color = Color.BLUE,
    override var xDataSet: List<Double>,
    override var yDataSet: List<Double> = mutableListOf<Double>(),

    var boxplotFillColor: Color = Color.BLACK,
    var boxplotColor: Color = Color.BLACK,
    var boxplotSymbol: Symbol = Symbol.DIAMOND
) : TwoDimensionalPlot {

    /**
     * This is the primary constructor for the implementation. It enforces checks on the datasets supplied to the class.
     */
    init {
        if (xDataSet.isEmpty()) {
            throw IllegalArgumentException("xDataSet or yDataSet can't be empty")
        }

        if (yDataSet.isNotEmpty()) {
            yDataSet = mutableListOf<Double>()
        }
    }


    /**
     * This function is the Boxplot Diagram implementation of the plot method from the two-dimensional interface.
     * It is to plot a Boxplot diagram.
     *
     * @return a Kandy internal representation plot object for rendering.
     */
    override fun plot(): Plot {
        return plot {
            boxplot(xDataSet) {
                outliers {
                    fillColor = boxplotFillColor
                    color = boxplotColor
                    symbol = boxplotSymbol
                }

                x.axis.name = xAxisDescription
                y.axis.name = yAxisDescription
            }
            layout.title = diagramDescription
        }
    }
}