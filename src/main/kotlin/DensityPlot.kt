import org.jetbrains.kotlinx.kandy.dsl.plot
import org.jetbrains.kotlinx.kandy.ir.Plot
import org.jetbrains.kotlinx.kandy.letsplot.feature.layout
import org.jetbrains.kotlinx.kandy.util.color.Color
import org.jetbrains.kotlinx.statistics.kandy.layers.densityPlot


/**
 * This is the Density Plot implementation class of the Two-Dimensional interface contract.
 *
 *
 * @param yAxisDescription The x-axis description of the plot. It has a default value of "X - Axis".
 * @param xAxisDescription The y-axis description of the plot. It has a default value of "Y - Axis".
 * @param diagramDescription The general description of the plot. It has a default value of "Density Plot".
 * @param colour The colour of the plot object. It has a default value of Color.BLUE.
 * @param xDataSet This is the dataset for the x-axis. It is a list of Doubles.
 * @param yDataSet This is the dataset for the y-axis. It is a list of Doubles.
 * @param plotFillColour - This is the fill colour for the plot. It has a default value of Color.BLUE.
 * @param borderLineWidth This is the borderline width of the plot. It has a default value of 1.0.
 * @param borderLineColour This is the borderline colour for the plot. It has a default value of Color.GREEN.
 * @param alphaValue This is the alpha value. It has a default value of 1.0.
 */
class DensityPlot @JvmOverloads constructor(
    override var yAxisDescription: String = "Y - Axis",
    override var xAxisDescription: String = "X - Axis",
    override var diagramDescription: String = "Density Plot",
    override var colour: Color = Color.BLUE,
    override var xDataSet: List<Double>,
    override var yDataSet: List<Double> = mutableListOf<Double>(),

    var borderLineWidth: Double = 1.0,
    var borderLineColour: Color = Color.BLUE,
    var plotFillColour: Color = Color.GREEN,
    var alphaValue: Double = 1.0,

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
    }

    /**
     * This is the Density Plot implementation class of the Two-Dimensional interface contract.
     *
     * @return a Kandy internal representation plot object for rendering.
     */
    override fun plot(): Plot {
        return plot {
            densityPlot(xDataSet) {
                alpha = alphaValue
                fillColor = plotFillColour
                borderLine.color = borderLineColour
                borderLine.width = borderLineWidth

                x.axis.name = xAxisDescription
                y.axis.name = yAxisDescription
            }
            layout.title = diagramDescription
        }
    }
}