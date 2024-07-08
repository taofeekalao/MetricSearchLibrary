package com.metric.search.visualisation

import org.jetbrains.kotlinx.kandy.dsl.plot
import org.jetbrains.kotlinx.kandy.ir.Plot
import org.jetbrains.kotlinx.kandy.letsplot.export.save
import org.jetbrains.kotlinx.kandy.letsplot.feature.layout
import org.jetbrains.kotlinx.kandy.letsplot.layers.bars
import org.jetbrains.kotlinx.kandy.letsplot.layers.line
import org.jetbrains.kotlinx.kandy.letsplot.settings.LineType
import org.jetbrains.kotlinx.kandy.util.color.Color
import org.jetbrains.kotlinx.statistics.binning.BinsOption
import org.jetbrains.kotlinx.statistics.kandy.stattransform.context.StatBinLayerCollectorContext
import org.jetbrains.kotlinx.statistics.kandy.stattransform.statBin


/**
 * This is the Histogram diagram implementation class of the Two-Dimensional interface contract.
 */
class Histogram(
    override var yAxisDescription: String = "Y - Axis",
    override var xAxisDescription: String = "X - Axis",
    override var diagramDescription: String = "Histogram",
    override var colour: Color = Color.BLUE,
    override var xDataSet: List<Double>,
    override var yDataSet: List<Double> = mutableListOf<Double>(),
    var lineOption: Boolean = false
) : TwoDimensionalPlot {

    /**
     * This is the primary constructor for the implementation.
     */
    init {
        if (xDataSet.isEmpty()) {
            throw IllegalArgumentException("xDataSet can't be empty")
        }

        if (yDataSet.isNotEmpty()) {
            yDataSet= mutableListOf<Double>()
        }
    }

    /**
     * This function is the Histogram Diagram implementation of the plot method from the two-dimensional interface.
     * It is to plot the Histogram diagram based on the Kotlin Kandy library.
     * It can switch off or on a line plot over the bars in the histogram plot.
     */
    override fun plot(): Plot {
        if (lineOption) {
            return plot {
                statBin(xDataSet, binsOption = BinsOption.byNumber(15)) {
                    plotBar()
                    plotLine()
                    layout.title = diagramDescription
                }
            }
        } else {
            return plot {
                statBin(xDataSet, binsOption = BinsOption.byNumber(15)) {
                    plotBar()
                    layout.title = diagramDescription
                }
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
            color = Color.GREEN
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


    /**
     * This function is the Histogram Diagram plot implementation of the save method from the two-dimensional interface.
     * It is to save the Histogram Diagram plot in the form of a static image, and it is based on Kotlin Kandy
     */
    override fun save(plot: Plot, imageName: String) {
        plot.save(imageName)
    }

}


