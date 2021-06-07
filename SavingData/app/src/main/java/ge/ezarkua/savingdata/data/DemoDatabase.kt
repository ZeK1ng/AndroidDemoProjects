package ge.ezarkua.savingdata.data

import androidx.room.Database
import androidx.room.RoomDatabase
import ge.ezarkua.savingdata.data.dao.MoviesDao
import ge.ezarkua.savingdata.data.entitiy.Movie

@Database(entities = arrayOf(Movie::class), version = 1)
abstract class DemoDatabase(): RoomDatabase() {
    abstract fun moviesDao(): MoviesDao
}