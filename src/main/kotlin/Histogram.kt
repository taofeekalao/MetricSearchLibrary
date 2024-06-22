package com.metric.search.visualisation

import org.jetbrains.kotlinx.kandy.util.color.Color
import org.jetbrains.kotlinx.kandy.dsl.plot
import org.jetbrains.kotlinx.kandy.ir.Plot
import org.jetbrains.kotlinx.statistics.kandy.layers.histogram

/**
 * This is the implementation class of the Histogram interface.
 */
class Histogram(
    override var yAxisDescription: String = "Y - Axis",
    override var xAxisDescription: String = "X - Axis",
    override var diagramDescription: String = "Histogram diagram",
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
     * Function to plot histogram based on Kotlin Kandy
     */
    override fun plot(): Plot {
        return plot {
            histogram(xDataSet)
        }
    }
}


