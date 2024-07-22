import org.jetbrains.kotlinx.kandy.dsl.plot
import org.jetbrains.kotlinx.kandy.ir.Plot
import org.jetbrains.kotlinx.kandy.letsplot.settings.Symbol
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
    var boxplotFillColor: Color = Color.BLACK,
    var boxplotColor: Color = Color.BLACK,
    var boxplotSymbol: Symbol = Symbol.DIAMOND
) : TwoDimensionalPlot {

    /**
     * This is the primary constructor for the implementation.
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
     * It is to plot a Boxplot diagram based on Kotlin Kandy
     */
    override fun plot(): Plot {
        return plot {
            boxplot(xDataSet) {
                outliers {
                    fillColor = boxplotFillColor
                    color = boxplotColor
                    symbol = boxplotSymbol
                }
            }
        }
    }
}