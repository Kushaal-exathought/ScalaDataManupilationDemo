package ImdbDataSetManupilation

import org.scalatest.BeforeAndAfter
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

import scala.collection.immutable.ListMap
import scala.collection.mutable.ListBuffer

class MovieServicesTest extends AnyFunSuite with BeforeAndAfter{
  var movieBusinessCalculator: MoviesServices = _
  before{
    val fileName = "input/TestSet.csv"
    val movies = new MoviesReader(fileName).readMovies()
    movieBusinessCalculator = new MoviesServices(movies)
  }
  test("Total Number of Movies"){
    println(movieBusinessCalculator.getTotalNoOfMovies)
    assert(movieBusinessCalculator.getTotalNoOfMovies === 7)
  }
  test("Test moviesGroupedByYearWithHighestRating logic"){
    val moviesGroupedByYearWithHighestRating = movieBusinessCalculator.getGroupByYearWithHighestRating()
    println(moviesGroupedByYearWithHighestRating)
    moviesGroupedByYearWithHighestRating.isInstanceOf[ListBuffer[Movie]] shouldBe true
    moviesGroupedByYearWithHighestRating(2).rating shouldBe 7.4f
  }
  test("Test moviesListGroupedByYearAndGenre logic"){
    val moviesListGroupedByYearAndGenre = movieBusinessCalculator.getTotalGrossByMainGenreByYear()
    println(moviesListGroupedByYearAndGenre)
    moviesListGroupedByYearAndGenre.isInstanceOf[ListMap[(Int, String), String]] shouldBe true
    moviesListGroupedByYearAndGenre(2022,"Action").split(",")(2) shouldBe "$3790000.0M"
    moviesListGroupedByYearAndGenre(2021,"Action").split(",")(2) shouldBe "$3450000.0M"
    moviesListGroupedByYearAndGenre(2020,"Drama").split(",")(2) shouldBe "$200000.0M"
    moviesListGroupedByYearAndGenre(2020,"Animation").split(",")(2) shouldBe "$5875000.0M"
    moviesListGroupedByYearAndGenre(2020,"Adventure").split(",")(2) shouldBe "$770000.0M"
    moviesListGroupedByYearAndGenre(2020,"Action").split(",")(2) shouldBe "$1590000.0M"

  }
}
