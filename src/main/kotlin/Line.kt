package com.metric.search.visualisation

import org.jetbrains.kotlinx.kandy.ir.Plot
import org.jetbrains.kotlinx.kandy.letsplot.export.save
import org.jetbrains.kotlinx.kandy.letsplot.layers.hLine
import org.jetbrains.kotlinx.kandy.letsplot.layers.line
import org.jetbrains.kotlinx.kandy.letsplot.layers.vLine
import org.jetbrains.kotlinx.kandy.letsplot.settings.LineType
import org.jetbrains.kotlinx.kandy.util.color.Color


/**
 * This is the Line Graph implementation class of the Two-Dimensional interface contract.
 */
class Line(
    override var yAxisDescription: String = "Y - Axis",
    override var xAxisDescription: String = "X - Axis",
    override var diagramDescription: String = "Line Graph",
    override var colour: Color = Color.BLUE,
    override var xDataSet: List<Double>,
    override var yDataSet: List<Double>,

    var verticalIntersect: Boolean = false,
    var verticalIntersectValue: Double = 0.0,
    var horizontalIntersect: Boolean = false,
    var horizontalIntersectValue: Double = 0.0,
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
     * This function is the Line Graph implementation of the plot method from the two-dimensional interface.
     * It is to plot line graph diagram based on Kotlin Kandy
     */
    override fun plot(): Plot {
        return org.jetbrains.kotlinx.kandy.dsl.plot {
            line {
                x(xDataSet)
                y(yDataSet)

                if (verticalIntersect) {
                    vLine {
                        xIntercept.constant(verticalIntersectValue)
                        color = Color.RED
                        type = LineType.DASHED
                    }
                }

                if (horizontalIntersect) {
                    hLine {
                        yIntercept.constant(horizontalIntersectValue)
                        color = Color.RED
                        type = LineType.DASHED
                    }
                }
            }
        }
    }

    /**
     * This function is the Line Graph implementation of the save method from the two-dimensional interface.
     * It is to save the Line Graph in the form of a static image, and it is based on Kotlin Kandy
     */
    override fun save(plot: Plot, imageName: String) {
        plot.save(imageName)
    }
}