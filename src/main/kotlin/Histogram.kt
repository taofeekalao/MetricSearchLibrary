package com.metric.search.visualisation

import org.jetbrains.kotlinx.kandy.util.color.Color
import org.jetbrains.kotlinx.kandy.dsl.plot
import org.jetbrains.kotlinx.kandy.ir.Plot
import org.jetbrains.kotlinx.kandy.letsplot.export.save
import org.jetbrains.kotlinx.statistics.kandy.layers.histogram

/**
 * This is the Histogram diagram implementation class of the Two-Dimensional interface contract.
 */
class Histogram(
    override var yAxisDescription: String = "Y - Axis",
    override var xAxisDescription: String = "X - Axis",
    override var diagramDescription: String = "Histogram",
    override var colour: Color = Color.BLUE,
    override var xDataSet: List<Double>,
    override var yDataSet: List<Double> = mutableListOf<Double>()
) : TwoDimensionalPlot {

    init {
        if (xDataSet.isEmpty()) {
            throw IllegalArgumentException("xDataSet can't be empty")
        }
    }

    /**
     * This function is the Histogram Diagram implementation of the plot method from the two-dimensional interface.
     * It is to plot the Histogram diagram based on Kotlin Kandy
     */
    override fun plot(): Plot {
        return plot {
            histogram(xDataSet)
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


