import org.jetbrains.kotlinx.kandy.dsl.plot
import org.jetbrains.kotlinx.kandy.ir.Plot
import org.jetbrains.kotlinx.kandy.util.color.Color
import org.jetbrains.kotlinx.kandy.letsplot.feature.layout
import org.jetbrains.kotlinx.kandy.letsplot.layers.context.aes.WithAlpha
import org.jetbrains.kotlinx.statistics.kandy.layers.densityPlot


/**
 * This is the Density Plot implementation class of the Two-Dimensional interface contract.
 */
class DensityPlot(
    override var yAxisDescription: String = "Y - Axis",
    override var xAxisDescription: String = "X - Axis",
    override var diagramDescription: String = "Density Plot",
    override var colour: Color = Color.BLUE,
    override var xDataSet: List<Double>,
    override var yDataSet: List<Double> = mutableListOf<Double>(),

    var borderLineWidth: Double = 0.0,
    var borderLineColour: Color = Color.BLUE,
    var plotFillColour: Color = Color.GREEN,
    var alphaValue: Double = 0.0,

) : TwoDimensionalPlot {

    /**
     * This is the primary constructor for the implementation.
     */
    init {
        if (xDataSet.isEmpty()) {
            throw IllegalArgumentException("Dataset for x-axis cannot be empty")
        }

        if (yDataSet.isNotEmpty()) {
            yDataSet= mutableListOf<Double>()
        }
    }

    /**
     * This is the Density Plot implementation class of the Two-Dimensional interface contract.
     */
    override fun plot(): Plot {
        return plot {
            densityPlot(xDataSet) {
                alpha = alphaValue
                fillColor = plotFillColour
                borderLine.color = borderLineColour
                borderLine.width = borderLineWidth
                x.axis.name = xAxisDescription
            }
            layout.title = diagramDescription
        }
    }
}