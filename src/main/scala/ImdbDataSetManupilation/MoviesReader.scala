package ImdbDataSetManupilation

import scala.collection.Seq
import scala.io.Source

class MoviesReader(val fileName: String) extends CsvReader {
  override def readMovies(): Seq[Movie] = {
    for {
      line <- Source.fromFile(fileName).getLines().drop(1).toVector
      values = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)").map(_.trim)
    } yield Movie(values(0), values(1).toInt, values(2), values(3), values(4).toFloat,
      values(5).toInt, values(6), values(7).toDouble, values(8), values(9))
  }

  //Movie_Title	Year	Director	Actors	Rating	Runtime(Mins)	Censor	Total_Gross	main_genre	side_genre
}
