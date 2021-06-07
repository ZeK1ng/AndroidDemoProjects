package ge.ezarkua.mvpdemo.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ge.ezarkua.mvpdemo.data.dao.MoviesDao
import ge.ezarkua.mvpdemo.data.entity.Movie

@Database(entities = arrayOf(Movie::class), version = 1)
abstract class DemoDatabase(): RoomDatabase() {
    abstract fun moviesDao(): MoviesDao

    companion object{
        private val dbName = "demo-db"
       /* @Volatile private var INSTANTCE: DemoDatabase? = null

        fun getInstance(context: Context): DemoDatabase{

            if(INSTANTCE == null){
                synchronized(this){
                    if(INSTANTCE == null) {
                        INSTANTCE =
                            Room.databaseBuilder(context, DemoDatabase::class.java, dbName).build()
                    }
                }
            }
            return INSTANTCE!!

        }*/

        private lateinit var INSTANTCE: DemoDatabase

        fun getInstance(): DemoDatabase{
            return INSTANTCE
        }

        fun createDatabase(context: Context){
            INSTANTCE = Room.databaseBuilder(context, DemoDatabase::class.java, dbName).build()
        }

    }
}