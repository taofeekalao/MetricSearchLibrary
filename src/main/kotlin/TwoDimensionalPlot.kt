import org.jetbrains.kotlinx.kandy.ir.Plot
import org.jetbrains.kotlinx.kandy.util.color.Color

/**
 * This is the two-dimensional interface definition of the contract for the visualisation library.
 * The library is a custom wrapper around a Kotlin Kandy library for visualisation.
 */
interface TwoDimensionalPlot {
    /**
     * This is the description of the y-axis on the diagram.
     */
    var yAxisDescription: String

    /**
     * This is the description of the x-axis on the diagram.
     */
    var xAxisDescription: String

    /**
     * This is the detailed description or title of the diagram.
     */
    var diagramDescription: String

    /**
     * This is the fill colour of the diagram plot object.
     */
    var colour: Color

    /**
     * This is the input dataset whose values will be plotted on the x-axis of the two-dimension diagram.
     */
    var xDataSet: List<Double>

    /**
     * This is the input dataset whose values will be plotted on the y-axis of the two-dimension diagram.
     */
    var yDataSet: List<Double>

    /**
     * This is the interface definition of the method to plot a two-dimensional diagram.
     */
    fun plot(): Plot


    /**
     * This is the interface definition of the method to save a two-dimensional diagram generated.
     * The generated visualisation will be saved in an acceptable format - jpg, jpeg, png.
     */
    fun save(plot: Plot, imageName: String)
}
