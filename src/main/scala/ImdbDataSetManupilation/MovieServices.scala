package ImdbDataSetManupilation

import scala.collection.Seq
import scala.collection.mutable.ListBuffer
import scala.collection.mutable.Map
import scala.collection.immutable.ListMap
import scala.math.Ordered.orderingToOrdered


class MoviesServices(val moviesList: Seq[Movie]) {

  var movies = moviesList

  def getTotalNoOfMovies(): Int = movies.size

  def getGroupByYearWithHighestRating(): ListBuffer[Movie] = {
    val groupedMoviesByYear = movies.groupBy(_.year)
    var finalMoviesListAfterGrouping: ListBuffer[Movie] = ListBuffer[Movie]();
    groupedMoviesByYear.keys.foreach(key => {
      val groupedMoviesByRatingPerYear = groupedMoviesByYear(key).groupBy(_.rating);
      val groupedMoviesListByRatingPerYear = groupedMoviesByRatingPerYear(groupedMoviesByRatingPerYear.keys.max);
      finalMoviesListAfterGrouping = finalMoviesListAfterGrouping ++ groupedMoviesListByRatingPerYear.toList
    })
    finalMoviesListAfterGrouping.sortBy(-_.year)
  }

  def getTotalGrossByMainGenreByYear(): ListMap[(Int, String), String] = {
    val groupedMoviesByYear = movies.groupBy(_.year)
    val finalMoviesListGroupedByYearAndGenre: Map[(Int, String), String] = Map.empty[(Int, String), String]
    groupedMoviesByYear.keys.foreach(year => {
      val mainGenreForAParticularYear = groupedMoviesByYear(year).groupBy(_.mainGenre)
      mainGenreForAParticularYear.keys.foreach(genre => {
        var totalGross: Double = 0.0;
        mainGenreForAParticularYear(genre).foreach(movie => {
          totalGross += movie.totalGross
        })
        val yearGenreTotalGross = "" + year + "," + genre + "," + "$" + totalGross.toFloat + "M"
        finalMoviesListGroupedByYearAndGenre += ((year -> genre) -> yearGenreTotalGross)
      })
    })
    ListMap(finalMoviesListGroupedByYearAndGenre.toSeq.sortWith(_._1 > _._1):_*)
  }

}

