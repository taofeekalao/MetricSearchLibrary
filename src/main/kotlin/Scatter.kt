package com.metric.search.visualisation

import org.jetbrains.kotlinx.kandy.util.color.Color
import org.jetbrains.kotlinx.kandy.dsl.plot
import org.jetbrains.kotlinx.kandy.ir.Plot
import org.jetbrains.kotlinx.kandy.letsplot.layers.points
import org.jetbrains.kotlinx.kandy.letsplot.settings.Symbol

/**
 * This is the implementation class of the Scatter Plot.
 */
class Scatter(
    override var yAxisDescription: String = "Y - Axis",
    override var xAxisDescription: String = "X - Axis",
    override var diagramDescription: String = "Histogram diagram",
    override var colour: Color = Color.BLUE,
    override var xDataSet: List<Double>,
    override var yDataSet: List<Double>
) : TwoDimensionalPlot {

    init {
        if (xDataSet.isEmpty() || yDataSet.isEmpty()) {
            throw IllegalArgumentException("xDataSet or yDataSet can't be empty")
        }
    }

    /**
     * Function to plot scatter diagram based on Kotlin Kandy
     */
    override fun plot(): Plot {
        return plot {
            points {
                x(xDataSet)
                y(yDataSet)
                symbol = Symbol.CIRCLE_OPEN
            }
        }
    }
}


