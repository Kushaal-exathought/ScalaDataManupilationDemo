package ImdbDataSetManupilation

import java.io.{File, PrintWriter}
import scala.collection.immutable.ListMap
import scala.collection.mutable.{ListBuffer, Map}

class MoviesWriter {

  def writeToFile(data: AnyRef, outputDirectory: String, fileName: String, fileHeader: String): String = {
    data match {
      case _: ListMap[(Int, String), String] => {
        val totalGrossByGenreByYear: ListMap[(Int, String), String] = data.asInstanceOf[ListMap[(Int, String), String]]
        val outputLocation = outputDirectory + fileName;
        val header = fileHeader;
        val printWriter = new PrintWriter(new File(outputLocation));
        printWriter.write(header + "\n");
        for (line <- totalGrossByGenreByYear.values) {
          printWriter.write(line + "\n")
        }
        printWriter.close();
        "Data saved successfully with file name " + fileName
      }

      case _: ListBuffer[Movie] => {
        val moviesGroupedByYearWithHighestRating: ListBuffer[Movie] = data.asInstanceOf[ListBuffer[Movie]]
        val outputLocation = outputDirectory + fileName
        val header = fileHeader;
        val printWriter = new PrintWriter(new File(outputLocation));
        printWriter.write(header + "\n");
        moviesGroupedByYearWithHighestRating.foreach(movie => {
          printWriter.write(movie.formatToString + "\n")
        })
        printWriter.close();
        "Data saved successfully with file name " + fileName
      }
    }
  }

}
