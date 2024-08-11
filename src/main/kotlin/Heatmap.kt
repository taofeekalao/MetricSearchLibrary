import org.jetbrains.kotlinx.dataframe.DataFrame
import org.jetbrains.kotlinx.kandy.dsl.continuous
import org.jetbrains.kotlinx.kandy.dsl.plot
import org.jetbrains.kotlinx.kandy.ir.Plot
import org.jetbrains.kotlinx.kandy.letsplot.feature.layout
import org.jetbrains.kotlinx.kandy.letsplot.layers.points
import org.jetbrains.kotlinx.kandy.letsplot.layers.tiles
import org.jetbrains.kotlinx.kandy.letsplot.scales.BrewerPalette
import org.jetbrains.kotlinx.kandy.letsplot.scales.continuousColorBrewer
import org.jetbrains.kotlinx.kandy.letsplot.x
import org.jetbrains.kotlinx.kandy.letsplot.y
import org.jetbrains.kotlinx.kandy.util.color.Color
import org.jetbrains.kotlinx.statistics.kandy.layers.heatmap
import org.jetbrains.kotlinx.statistics.kandy.statplots.heatmap
import org.jetbrains.kotlinx.statistics.kandy.stattransform.statCount2D

class Heatmap(
    override var yAxisDescription: String = "Y - Axis",
    override var xAxisDescription: String = "X - Axis",
    override var diagramDescription: String = "Heatmap",
    override var colour: Color = Color.BLUE,
    override var xDataSet: List<Double>,
    override var yDataSet: List<Double>,

    var plotColour: Color = Color.RED,
) : TwoDimensionalPlot {


    /**
     * This is the primary constructor for the implementation.
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