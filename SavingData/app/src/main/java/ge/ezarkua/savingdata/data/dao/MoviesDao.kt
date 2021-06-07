package ge.ezarkua.savingdata.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ge.ezarkua.savingdata.data.entitiy.Movie

@Dao
interface MoviesDao {

    @Query("Select * from Movie")
    fun getMovies(): List<Movie>

    @Insert
    fun addMovie(movie: Movie)
}