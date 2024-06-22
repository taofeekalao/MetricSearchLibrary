package com.metric.search.visualisation

import org.jetbrains.kotlinx.kandy.ir.Plot
import org.jetbrains.kotlinx.kandy.util.color.Color
/**
 * This histogram interface defines the contract for the visualisation of histograms.
 */
interface TwoDimensionalPlot {
    /**
     * The description of the y-axis on the diagram.
     */
    var yAxisDescription: String

    /**
     * The description of the x-axis on the diagram.
     */
    var xAxisDescription: String

    /**
     * The detailed description or title of the diagram.
     */
    var diagramDescription: String

    /**
     * The fill colour of the diagram plot object.
     */
    var colour: Color

    /**
     * The input dataset whose values will be plotted on the x-axis of the two-dimension diagram.
     */
    var xDataSet: List<Double>

    /**
     * The input dataset whose values will be plotted on the y-axis of the two-dimension diagram.
     */
    var yDataSet: List<Double>

    /**
     * This is the method to plot the two-dimensional diagram.
     */
    fun plot(): Plot
}
