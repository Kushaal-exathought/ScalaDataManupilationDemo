This Project reads the IMDB Movie Dataset which is in .csv format and generates two files , as follows
1. MoviesGroupedByYearWithHighestRating.csv
2. TotalGrossByGenreByYear.csv
-------------------------------------------------------------------------------------------------------------------------------------------
Project Implementation Details:
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
1. CSVReader.scala ---> contains a trait (CSV Reader) with readMovies() , and class Movies

2. MoviesReader.scala ---> contains class MovieReader with extends a trait CSV Reader and overrides readMovies()
    - the implementation includes a yield function whose responsibility is to read the data from the .csv file
    - and create a Movie Object for each row in the file
    - and add the Movie Objects into a Sequence[Movie]

3. Movies Services.scala ---> contains class MoviesServices which as the business validation function definitions
    - getGroupByYearWithHighestRating() : ListBuffer[Movie]
      -> this functions takes a movies list and groups by year and takes the highest rated movie of that
         year and pushes it to the List

    - getTotalGrossByMainGenreByYear(): ListMap[(Int, String), String]
      -> this function takes a movies list and groups by year and genre and adds the totalGross
         and pushes it to a Map

4. MoviesWriter.scala ---> the class contains a method
                           - writeToFile(data: AnyRef, outputDirectory: String, fileName: String, fileHeader: String): String
                           - here based on the data which is the movies List which is groupedByYear and totalGrossByGenre
                           - executes the code block which satisfies the case condition
                           - the result is a file is created on the directory specified

-------------------------------------------------------------------------------------------------------------------------------------------

Flow of Execution
~~~~~~~~~~~~~~~~~~
Main.scala ---> in this file the execution starts from main()

                1. MovieReader Object is instanciated by passing in a filename and then invoking the readMovies()
                    which return Seq[Movies]

                2. MovieServices Object is instanciated by passing in the Seq[Movies] during the creation

                3. On the Movie ServicesObject we invoke the necessary methods to get the list of movies based on the problem statement
                   - getGroupByYearWithHighestRating()
                   - getTotalGrossByMainGenreByYear()

                4. MoviesWriter Object is instanciated and we invoke the writeMoviesToFile()
                    - the resultant is a Output file is generated in the directory specified

-------------------------------------------------------------------------------------------------------------------------------------------

Test Cases are written using the scalaTest library:

src/test/scala
1. MoviesServicesTest
2. MoviesReaderTest
3. MoviesWriterTest

src/test/resources
is where the input file and output files reside

-------------------------------------------------------------------------------------------------------------------------------------------

How to Run the Project
~~~~~~~~~~~~~~~~~~~~~~~
 Navigate to --- > src/main/scala
    Run the Main.scala

