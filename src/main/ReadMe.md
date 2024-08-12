# Kotlin Visualisation Library for Metric Space Search

## Overview

This Kotlin Visualisation Library for Metric Space Search is designed to simplify the creation of various types of visualisations, including boxplots, scatter plots, histograms, density plots, line plots, heatmaps, and cumulative distribution function plots. Built around Kotlin Kandy, this library is compatible with Java, Kotlin, and Kotlin Notebook environments, making it a versatile tool for metric space search research and other data visualisation needs.

## Features

- **Visualisation Support**: Includes a wide range of plots such as boxplots, scatter plots, histograms, density plots, line plots, heatmaps, and cumulative distribution function plots.
- **Seamless Integration**: Works effortlessly with Java, Kotlin, and Kotlin Notebook environments.
- **Customizable**: Provides extensive customization options for axis descriptions, colors, plot types, and more.
- **Easy to Use**: Simple and intuitive API designed to be used with minimal setup.

## Detailed Documentation

#### Parent Interface Description:
The `TwoDimensionalPlot` interface defines the contract for creating two-dimensional plots. It includes properties for axis descriptions, diagram titles, colour, data sets, and methods for plotting and saving diagrams.

```kotlin
interface TwoDimensionalPlot {
    var yAxisDescription: String
    var xAxisDescription: String
    var diagramDescription: String
    var colour: Color
    var xDataSet: List<Double>
    var yDataSet: List<Double>

    fun plot(): Plot

    fun save(plot: Plot, imageName: String) {
        plot.save(imageName)
    }
}
```

#### Child Class Description:

The `Line` class implements the `TwoDimensionalPlot` interface to create line graphs.
It includes additional properties for vertical and horizontal intersect lines and smoothness.


The `BoxPlot` class implements the `TwoDimensionalPlot` interface to create.
It includes additional properties for fill colour, colour and plot symbol for the outliers.

The `Histogram` class implements the `TwoDimensionalPlot` interface to create.
It includes additional properties for a line plot that mimics the distribution function,
line colour, and bin option value used to determine the number of grouped dataset samples.

The `Scatter Plot` class implements the `TwoDimensionalPlot` interface to create.
It includes additional properties for a line plot to plot an intersection, line colour, and plot symbol.

The `Density Plot (PDF)` class implements the `TwoDimensionalPlot` interface to create.
It includes additional properties for a border line width, colour, and fill colour.

The `Cumulative Distribution Function Plot` class implements the `TwoDimensionalPlot` interface to create.
It includes additional properties for a vertical and a horizontal intersect with their respective values.



## Getting Started

To use this library, ensure that you have Kotlin and Java development environments set up. You can include the library in your project by adding the necessary dependencies to your build system (Gradle, Maven, etc.).

### Generic Prerequisites

- Metric Space Search Framework Library
- Kotlin Visualisation Library for Metric Space Search
- Install both libraries above into local Maven repository or publish both to a central repository and reference them from the central repository.

### Install the Artefacts in the local Maven Repository
#### Installing The Metric Space Search Framework Library in Maven Local Repository
- Download the required jar libraries to your system.
- Make a copy of the command below to install the jars into the local repository.
- Replace "path/to/your/jar/" with the location of the jar files on your system in the command below.
- Execute the command to install the jar file in the local Maven repo.
  
```shell
    mvn install:install-file -Dfile=path/to/your/jar/Metric-space-framework-1.0-20211209.152843-1.jar \
    -DgroupId=com.example \
    -DartifactId=metric-space-framework \
    -Dversion=1.0 \
    -Dpackaging=jar
    
    
    mvn install:install-file -Dfile=path/to/your/jar/visualisation-library-1.0-SNAPSHOT.jar \
    -DgroupId=com.metric.search.visualisation \
    -DartifactId=visualisation-library \
    -Dversion=1.0-SNAPSHOT \
    -Dpackaging=jar
```


## Java Usage

### Prerequisites

- JDK 8 or above
- Maven or Gradle for dependency management
- Metric Space Search Framework Library

### Dependency & Repository Setup

Add the following dependency and repository entry to your `pom.xml` (for Maven) or `build.gradle` (for Gradle):

**Maven:**
```xml
<!-- Repositories
    Maven Local Repo
    Maven Central Repo
    Kotlin Statistics JVM Repo
 -->
<repositories>
    <repository>
        <id>maven-local</id>
        <url>file://${user.home}/.m2/repository</url>
    </repository>
    <repository>
        <id>central</id>
        <url>https://repo.maven.apache.org/maven2</url>
    </repository>
    <repository>
        <id>kotlin-statistics-jvm</id>
        <url>https://packages.jetbrains.team/maven/p/kds/kotlin-ds-maven</url>
    </repository>
</repositories>
```

```xml
<!-- Dependencies -->
<dependencies>
    <!-- Use This Dependency Format If Jar File Is Located In A Folder Called 'lib' Your Project Root -->
    <dependency>
        <groupId>com.example</groupId>
        <artifactId>metric-space-framework</artifactId>
        <version>1.0</version>
        <scope>system</scope>
        <systemPath>${project.basedir}/libs/Metric-space-framework-1.0-20211209.152843-1.jar</systemPath>
    </dependency>

    <dependency>
        <groupId>com.metric.search.visualisation</groupId>
        <artifactId>visualisation-library</artifactId>
        <version>1.0-SNAPSHOT</version>
        <scope>system</scope>
        <systemPath>${project.basedir}/libs/Metric-space-framework-1.0-20211209.152843-1.jar</systemPath>
    </dependency>
    <!--  -->


    <!-- Use This Dependency Format If Jar File Is Installed In Your Local Maven Director By The Steps Given Under General Requirements. -->
    <dependency>
        <groupId>com.example</groupId>
        <artifactId>metric-space-framework</artifactId>
        <version>1.0</version>
    </dependency>

    <dependency>
        <groupId>com.metric.search.visualisation</groupId>
        <artifactId>visualisation-library</artifactId>
        <version>1.0-SNAPSHOT</version>
    </dependency>
    <!-- -->
    
    <dependency>
        <groupId>org.jetbrains.kotlinx</groupId>
        <artifactId>kotlin-statistics-jvm</artifactId>
        <version>0.2.1</version>
        <scope>runtime</scope>
    </dependency>
    <!-- -->
    <dependency>
        <groupId>org.jetbrains.kotlin</groupId>
        <artifactId>kotlin-stdlib-jdk8</artifactId>
        <version>${kotlin.version}</version>
    </dependency>

    <dependency>
        <groupId>org.apache.commons</groupId>
        <artifactId>commons-math3</artifactId>
        <version>3.6.1</version>
    </dependency>
</dependencies>
```

**Gradle:**
```kotlin
repositories {
    mavenLocal()
    mavenCentral()
    maven("https://packages.jetbrains.team/maven/p/kds/kotlin-ds-maven")
}


dependencies {
// use these if the jar files are located in a folder name libs in the project root directory.
    implementation(files("libs/Metric-space-framework-1.0-20211209.152843-1.jar"))
    implementation(files("libs/visualisation-library-1.0-SNAPSHOT.jar"))

// use these if the jar files are successfully installed in the local Maven or a central Maven directory.
    implementation("com.example:metric-space-framework:1.0")
    implementation("com.metric.search.visualisation:visualisation-library:1.0-SNAPSHOT")
    
    
    implementation("org.jetbrains.kotlinx:kandy-lets-plot:0.6.0")
    implementation("org.apache.commons:commons-math3:3.6.1")
}
```

### Example Java Usage (Using Random Data)

```java
import com.metric.search.visualisation.*;

import org.jetbrains.kotlinx.kandy.ir.Plot;
import org.jetbrains.kotlinx.kandy.util.color.Color;

import java.util.Arrays;
import java.util.List;

public class VisualisationExample {

    public static void main(String[] args) {
        // Example for creating a Boxplot
        List<Double> xData = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0);

        Boxplot boxplot = new Boxplot("Y Axis", "X Axis", "Boxplot Example", Color.BLUE, xData, null, Color.BLACK, Color.RED, Symbol.CIRCLE_OPEN);
        Plot plot = boxplot.plot();
        boxplot.save(plot, "boxplot_example.png");

        // Additional examples can be created similarly for other plot types.
    }
}
```

### How to Run

- Compile the Java files using your preferred IDE or command line.
- Run the `VisualisationExample` class to generate and save the visualisations.

## Kotlin Usage 

### Prerequisites

- Kotlin 1.5 or above
- Maven or Gradle for dependency management
- Metric Space Search Framework Library

### Dependency & Repository Setup

Add the following dependency and repository entries to your `build.gradle.kts` (for Gradle Kotlin DSL):

```kotlin
repositories {
    mavenLocal()
    mavenCentral()
    maven("https://packages.jetbrains.team/maven/p/kds/kotlin-ds-maven")
}


dependencies {
// use these if the jar files are located in a folder name libs in the project root directory.
    implementation(files("libs/Metric-space-framework-1.0-20211209.152843-1.jar"))
    implementation(files("libs/visualisation-library-1.0-SNAPSHOT.jar"))

// use these if the jar files are successfully installed in the local Maven or a central Maven directory.
    implementation("com.example:metric-space-framework:1.0")
    implementation("com.metric.search.visualisation:visualisation-library:1.0-SNAPSHOT")
    
    implementation("org.jetbrains.kotlinx:kandy-lets-plot:0.6.0")
    implementation("org.apache.commons:commons-math3:3.6.1")
}
```

Or to your `pom.xml` (for Maven):

```xml
<!-- Repositories
    Maven Local Repo
    Maven Central Repo
    Kotlin Statistics JVM Repo
 -->
<repositories>
    <repository>
        <id>maven-local</id>
        <url>file://${user.home}/.m2/repository</url>
    </repository>
    <repository>
        <id>central</id>
        <url>https://repo.maven.apache.org/maven2</url>
    </repository>
    <repository>
        <id>kotlin-statistics-jvm</id>
        <url>https://packages.jetbrains.team/maven/p/kds/kotlin-ds-maven</url>
    </repository>
</repositories>
```

```xml
<!-- Dependencies -->
<dependencies>
    <!-- Use This Dependency Format If Jar File Is Located In A Folder Called 'lib' Your Project Root -->
    <dependency>
        <groupId>com.example</groupId>
        <artifactId>metric-space-framework</artifactId>
        <version>1.0</version>
        <scope>system</scope>
        <systemPath>${project.basedir}/libs/Metric-space-framework-1.0-20211209.152843-1.jar</systemPath>
    </dependency>

    <dependency>
        <groupId>com.metric.search.visualisation</groupId>
        <artifactId>visualisation-library</artifactId>
        <version>1.0-SNAPSHOT</version>
        <scope>system</scope>
        <systemPath>${project.basedir}/libs/Metric-space-framework-1.0-20211209.152843-1.jar</systemPath>
    </dependency>
    <!--  -->


    <!-- Use This Dependency Format If Jar File Is Installed In Your Local Maven Director By The Steps Given Under General Requirements. -->
    <dependency>
        <groupId>com.example</groupId>
        <artifactId>metric-space-framework</artifactId>
        <version>1.0</version>
    </dependency>

    <dependency>
        <groupId>com.metric.search.visualisation</groupId>
        <artifactId>visualisation-library</artifactId>
        <version>1.0-SNAPSHOT</version>
    </dependency>
    <!-- -->
    
    <dependency>
        <groupId>org.jetbrains.kotlinx</groupId>
        <artifactId>kotlin-statistics-jvm</artifactId>
        <version>0.2.1</version>
        <scope>runtime</scope>
    </dependency>
    <!-- -->
    <dependency>
        <groupId>org.jetbrains.kotlin</groupId>
        <artifactId>kotlin-stdlib-jdk8</artifactId>
        <version>${kotlin.version}</version>
    </dependency>

    <dependency>
        <groupId>org.apache.commons</groupId>
        <artifactId>commons-math3</artifactId>
        <version>3.6.1</version>
    </dependency>
</dependencies>
```

### Example Kotlin Usage (Using Random Data)

```kotlin
import com.metric.search.visualisation.*
import org.jetbrains.kotlinx.kandy.util.color.Color
import org.jetbrains.kotlinx.kandy.ir.Plot

fun main() {
    // Example for creating a Scatter Plot
    val xData = listOf(1.0, 2.0, 3.0, 4.0, 5.0)
    val yData = listOf(5.0, 4.0, 3.0, 2.0, 1.0)

    val scatterPlot = Scatter("Y Axis", "X Axis", "Scatter Plot Example", Color.RED, xData, yData)
    val plot: Plot = scatterPlot.plot()
    scatterPlot.save(plot, "scatter_plot_example.png")

    // Additional examples can be created similarly for other plot types.
}
```

### How to Run

- Use your preferred Kotlin IDE (like IntelliJ IDEA) to compile and run the Kotlin files.
- The visualisations will be generated and saved in the specified file path.

## Kotlin Notebook Usage

### Prerequisites

- Kotlin Kernel for Jupyter Notebook
- Notebook environment like JupyterLab
- Metric Space Search Framework Library

### Dependency & Repository Setup

Add the following dependency to your `build.gradle.kts` (for Gradle Kotlin DSL):

```kotlin
repositories {
    mavenLocal()
    mavenCentral()
    maven("https://packages.jetbrains.team/maven/p/kds/kotlin-ds-maven")
}


dependencies {
// use these if the jar files are located in a folder name libs in the project root directory.
    implementation(files("libs/Metric-space-framework-1.0-20211209.152843-1.jar"))
    implementation(files("libs/visualisation-library-1.0-SNAPSHOT.jar"))

// use these if the jar files are successfully installed in the local Maven or a central Maven directory.
    implementation("com.example:metric-space-framework:1.0")
    implementation("com.metric.search.visualisation:visualisation-library:1.0-SNAPSHOT")
    
    
    implementation("org.jetbrains.kotlinx:kandy-lets-plot:0.6.0")
    implementation("org.apache.commons:commons-math3:3.6.1")
}
```

Or to your `pom.xml` (for Maven):

```xml
<!-- Repositories
    Maven Local Repo
    Maven Central Repo
    Kotlin Statistics JVM Repo
 -->
<repositories>
    <repository>
        <id>maven-local</id>
        <url>file://${user.home}/.m2/repository</url>
    </repository>
    <repository>
        <id>central</id>
        <url>https://repo.maven.apache.org/maven2</url>
    </repository>
    <repository>
        <id>kotlin-statistics-jvm</id>
        <url>https://packages.jetbrains.team/maven/p/kds/kotlin-ds-maven</url>
    </repository>
</repositories>
```

```xml
<!-- Dependencies -->
<dependencies>
    <!-- Use This Dependency Format If Jar File Is Located In A Folder Called 'lib' Your Project Root -->
    <dependency>
        <groupId>com.example</groupId>
        <artifactId>metric-space-framework</artifactId>
        <version>1.0</version>
        <scope>system</scope>
        <systemPath>${project.basedir}/libs/Metric-space-framework-1.0-20211209.152843-1.jar</systemPath>
    </dependency>

    <dependency>
        <groupId>com.metric.search.visualisation</groupId>
        <artifactId>visualisation-library</artifactId>
        <version>1.0-SNAPSHOT</version>
        <scope>system</scope>
        <systemPath>${project.basedir}/libs/Metric-space-framework-1.0-20211209.152843-1.jar</systemPath>
    </dependency>
    <!--  -->


    <!-- Use This Dependency Format If Jar File Is Installed In Your Local Maven Director By The Steps Given Under General Requirements. -->
    <dependency>
        <groupId>com.example</groupId>
        <artifactId>metric-space-framework</artifactId>
        <version>1.0</version>
    </dependency>

    <dependency>
        <groupId>com.metric.search.visualisation</groupId>
        <artifactId>visualisation-library</artifactId>
        <version>1.0-SNAPSHOT</version>
    </dependency>
    <!-- -->
    
    <dependency>
        <groupId>org.jetbrains.kotlinx</groupId>
        <artifactId>kotlin-statistics-jvm</artifactId>
        <version>0.2.1</version>
        <scope>runtime</scope>
    </dependency>
    <!-- -->
    <dependency>
        <groupId>org.jetbrains.kotlin</groupId>
        <artifactId>kotlin-stdlib-jdk8</artifactId>
        <version>${kotlin.version}</version>
    </dependency>

    <dependency>
        <groupId>org.apache.commons</groupId>
        <artifactId>commons-math3</artifactId>
        <version>3.6.1</version>
    </dependency>
</dependencies>
```


Add the necessary dependencies in a Kotlin Notebook cell:

```kotlin
// use these if the jar files are successfully installed in the local Maven or a central Maven directory.

@file:DependsOn("com.metric.search.visualisation:visualisation-library:1.0-SNAPSHOT")
@file:DependsOn("com.example:metric-space-framework:1.0")
```

```kotlin
// use these if the jar files are located in a folder name libs in the project root directory.

@file:DependsOn("../../../libs/visualisation-library-1.0-SNAPSHOT.jar")
@file:DependsOn("../../../libs/Metric-space-framework-1.0-20211209.152843-1.jar")
```

### Example Kotlin Usage (Using Random Data)

```kotlin
import com.metric.search.visualisation.*
import org.jetbrains.kotlinx.kandy.util.color.Color
import org.jetbrains.kotlinx.kandy.ir.Plot

// Example for creating a Line Plot
val xData = listOf(1.0, 2.0, 3.0, 4.0, 5.0)
val yData = listOf(2.0, 4.0, 6.0, 8.0, 10.0)

val linePlot = Line("Y Axis", "X Axis", "Line Plot Example", Color.GREEN, xData, yData)
val plot: Plot = linePlot.plot()

// Display the plot in the notebook
plot

// Save the plot to a file
linePlot.save(plot, "line_plot_example.png")
```

### How to Use

- Add the above dependency setup to your notebook.
- Write your code in a notebook cell and run it to generate visualisations.
- Use the `plot` function to visualise the plot directly in the notebook.

## Usage With The Metric Search Framework
See the JavaUsage and the MetricSearchNote repositories for practical use of the visualisation library with the Metric Search framework.
- JavaUsage repository - 
- MetricSearchNote repository -

## Contributing

We welcome contributions to enhance the library.

## Contact

For any queries or issues, please reach out to [tla2@st-andrews.ac.uk].

---

This README provides a comprehensive guide for using the Kotlin Visualisation Library for Metric Space Search across Java, Kotlin, and Kotlin Notebook environments. It covers dependency setup, example usage, and instructions for running the code, ensuring that users can integrate and utilise the library effectively in their projects.