package com.metric.search.visualisation

import org.jetbrains.kotlinx.kandy.ir.Plot
import org.jetbrains.kotlinx.kandy.util.color.Color

class Line(
    override var yAxisDescription: String = "Y - Axis",
    override var xAxisDescription: String = "X - Axis",
    override var diagramDescription: String = "Line Graph",
    override var colour: Color = Color.BLUE,
    override var xDataSet: List<Double>,
    override var yDataSet: List<Double>
) : TwoDimensionalPlot {


    /**
     * This function is the Line Graph implementation of the plot method from the two-dimensional interface.
     * It is to plot line graph diagram based on Kotlin Kandy
     */
    override fun plot(): Plot {
        TODO("Not yet implemented")
    }

    /**
     * This function is the Line Graph implementation of the save method from the two-dimensional interface.
     * It is to save the Line Graph in the form of a static image, and it is based on Kotlin Kandy
     */
    override fun save(plot: Plot, imageName: String) {
        TODO("Not yet implemented")
    }
}