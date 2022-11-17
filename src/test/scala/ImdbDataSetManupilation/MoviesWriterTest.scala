package ImdbDataSetManupilation

import ImdbDataSetManupilation.Main.writeMoviesToFile
import org.scalatest.BeforeAndAfter
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

import scala.collection.immutable.ListMap
import scala.collection.mutable.ListBuffer

class MoviesWriterTest extends AnyFunSuite with BeforeAndAfter {
  // Constants Declared and initialised
  val OUTPUT_DIRECTORY = "output/"
  val TOTAL_GROSS_BY_GENRE_BY_YEAR = "TestTotalGrossByGenreByYear.csv"
  val GROSS_HEADER = "Year,Main_Genre,Total_Gross"
  val HIGHEST_RATED_BY_YEAR = "TestMoviesGroupedByYearWithHighestRating.csv"
  val MOVIE_HEADER = "Movie_Title,Year,Director,Actors,Rating,Runtime(Mins),Censor,Total_Gross,Main_Genre,Side_Genre"

  // Variable declaration with wildcard Lazy loading
  var movieBusinessCalculator: MoviesServices = _
  var moviesGroupedByYearWithHighestRating: ListBuffer[Movie] = _
  var finalMoviesListGroupedByYearAndGenre:  ListMap[(Int, String), String] = _
  var movieWriter: MoviesWriter = _

  // before running each test cases execute this block of code
  before {
    val inputFileName = "input/TestSet.csv"
    val movies = new MoviesReader(inputFileName).readMovies()
    movieWriter = new MoviesWriter()
    movieBusinessCalculator = new MoviesServices(movies)

    moviesGroupedByYearWithHighestRating = movieBusinessCalculator.getGroupByYearWithHighestRating()
    finalMoviesListGroupedByYearAndGenre = movieBusinessCalculator.getTotalGrossByMainGenreByYear()
  }

  test("Test if the data is written into the right files"){
    val statusOfFileWriteOne = writeMoviesToFile(finalMoviesListGroupedByYearAndGenre,
      OUTPUT_DIRECTORY,
      TOTAL_GROSS_BY_GENRE_BY_YEAR,
      GROSS_HEADER,
      movieWriter.writeToFile)
    println("statusOfFileWriteOne --> " + statusOfFileWriteOne)

    val statusOfFileWriteTwo = writeMoviesToFile(moviesGroupedByYearWithHighestRating,
      OUTPUT_DIRECTORY,
      HIGHEST_RATED_BY_YEAR,
      MOVIE_HEADER,
      movieWriter.writeToFile)
    println("statusOfFileWriteTwo --> " + statusOfFileWriteTwo)

    statusOfFileWriteOne shouldBe "Data saved successfully with file name TestTotalGrossByGenreByYear.csv"
    statusOfFileWriteTwo shouldBe "Data saved successfully with file name TestMoviesGroupedByYearWithHighestRating.csv"
  }

}
