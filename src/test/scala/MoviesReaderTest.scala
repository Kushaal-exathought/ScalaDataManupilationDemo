import ImdbDataSetManupilation.{Movie, MoviesReader}
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

class MoviesReaderTest extends AnyFunSuite{
  test("Reading list of movies from a csv file") {

    val fileName = "/Users/u1130462/Desktop/Scala Code Base/ScalaDataManupilationDemo/src/test/test_resources/input/TestSet.csv"
    val movies = new MoviesReader(fileName).readMovies();

    println("movies --> " +movies(0).formatToString)
    assert(movies.isInstanceOf[Seq[Movie]] === true)
    assert(movies.size > 1)
    movies(0).movieTitle shouldBe "Kantara"
    assert(movies(0).formatToString === "Kantara,2022,Rishab Shetty,\"Rishab Shetty, Sapthami Gowda, Kishore Kumar G., Achyuth Kumar\",9.3,148,UA,$2900000.0M,Action,\" Adventure,  Drama\"")
  }
}
