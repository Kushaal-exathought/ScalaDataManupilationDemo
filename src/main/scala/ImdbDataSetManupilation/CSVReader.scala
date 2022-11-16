package ImdbDataSetManupilation

import scala.collection.Seq

trait CsvReader {

  def readMovies(): Seq[Movie]

}

//Movie_Title	Year	Director	Actors	Rating	Runtime(Mins)	Censor	Total_Gross	main_genre	side_genre
case class Movie(movieTitle: String,
                 year: Int,
                 director: String,
                 actors: String,
                 rating: Float,
                 runtimeInMins: Int,
                 censor: String,
                 totalGross: Double,
                 mainGenre: String,
                 sideGenre: String
                ){
   def formatToString: String = {
    movieTitle + "," + year + "," + director + "," + actors + "," + rating + "," + runtimeInMins + "," + censor + "," + "$" + totalGross + "M" + "," + mainGenre + "," + sideGenre
  }
}
