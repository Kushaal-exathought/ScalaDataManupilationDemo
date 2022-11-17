package ImdbDataSetManupilation

object Main {

  val INPUT_FILE = "input/IMDB_dataset.csv"
  val OUTPUT_DIRECTORY = "src/resources/output/"
  val TOTAL_GROSS_BY_GENRE_BY_YEAR = "TotalGrossByGenreByYear.csv"
  val GROSS_HEADER = "Year,Main_Genre,Total_Gross"
  val HIGHEST_RATED_BY_YEAR = "MoviesGroupedByYearWithHighestRating.csv"
  val MOVIE_HEADER = "Movie_Title,Year,Director,Actors,Rating,Runtime(Mins),Censor,Total_Gross,Main_Genre,Side_Genre"

  def writeMoviesToFile(finalMoviesList: AnyRef,
                        outputDirectory: String,
                        fileName: String,
                        fileHeader: String,
                        dynamicFuncRef: (AnyRef, String, String, String) => String): String = {

    dynamicFuncRef(finalMoviesList, outputDirectory, fileName, fileHeader)

  }

  def main(args: Array[String]): Unit = {

    val fileName = INPUT_FILE

    val movies = new MoviesReader(fileName).readMovies()
    val moviesBusinessCalculator = new MoviesServices(movies)

    println("validatedMovies ---> " + moviesBusinessCalculator.getTotalNoOfMovies)

    val moviesGroupedByYearWithHighestRating = moviesBusinessCalculator.getGroupByYearWithHighestRating()
    println("moviesGroupedByYearWithHighestRating -->" + moviesGroupedByYearWithHighestRating)

    val finalMoviesListGroupedByYearAndGenre = moviesBusinessCalculator.getTotalGrossByMainGenreByYear()
    println("finalMoviesListGroupedByYearAndGenre --> " + finalMoviesListGroupedByYearAndGenre)

    val movieWrite = new MoviesWriter()

    val statusOfFileWriteOne = writeMoviesToFile(finalMoviesListGroupedByYearAndGenre,
      OUTPUT_DIRECTORY,
      TOTAL_GROSS_BY_GENRE_BY_YEAR,
      GROSS_HEADER,
      movieWrite.writeToFile)
    println("statusOfFileWriteOne --> " + statusOfFileWriteOne)

    val statusOfFileWriteTwo = writeMoviesToFile(moviesGroupedByYearWithHighestRating,
      OUTPUT_DIRECTORY,
      HIGHEST_RATED_BY_YEAR,
      MOVIE_HEADER,
      movieWrite.writeToFile)
    println("statusOfFileWriteTwo --> " + statusOfFileWriteTwo)

  }

}
