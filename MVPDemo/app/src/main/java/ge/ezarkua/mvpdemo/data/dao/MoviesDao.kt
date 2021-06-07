package ge.ezarkua.mvpdemo.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ge.ezarkua.mvpdemo.data.entity.Movie

@Dao
interface MoviesDao {

    @Query("Select * from Movie")
    fun getMovies(): List<Movie>

    @Insert
    fun addMovie(movie: Movie)

    @Query("Select * from Movie where id = :movieId")
    fun getMoviesDetails(movieId: Int): Movie
}