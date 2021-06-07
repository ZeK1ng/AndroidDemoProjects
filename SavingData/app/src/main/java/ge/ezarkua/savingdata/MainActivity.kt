package ge.ezarkua.savingdata

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.room.Room
import ge.ezarkua.savingdata.data.DemoDatabase
import ge.ezarkua.savingdata.data.entitiy.Movie
import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {

    val dbName = "demo-db"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       /* var inputStream = resources.openRawResource(R.raw.loremipsum)
        var reader = BufferedReader(InputStreamReader(inputStream))
        var line = reader.readLine()
        reader.close()*/

     /*   var fileName = "test.txt"

        var file = File(filesDir, fileName)*/

       /* findViewById<TextView>(R.id.txt_description).setOnClickListener {
            if(file.exists()){
                file.writeText("Lorem ipsum dolor sit amet")

                findViewById<TextView>(R.id.txt_description).text = file.readText()
            }else{
                file.createNewFile()
            }
            Toast.makeText(this, file.absolutePath, Toast.LENGTH_SHORT).show()
        }
*/

       /* var isFirstRun = "isFirstRun"
        var sharedPreferecnes = getSharedPreferences("demo-pref", Context.MODE_PRIVATE)

        findViewById<TextView>(R.id.txt_description).setOnClickListener {
            sharedPreferecnes.edit().putBoolean(isFirstRun, false).apply()
        }

        if(sharedPreferecnes.getBoolean(isFirstRun, true)){
            findViewById<ConstraintLayout>(R.id.layout).setBackgroundColor(ContextCompat.getColor(this, R.color.purple_200))
        }*/

        var database = Room.databaseBuilder(this, DemoDatabase::class.java, dbName).build()
        var moviedDao = database.moviesDao()


        Thread(Runnable {
            moviedDao.addMovie(Movie(5,"Friends: The Reunion", 0f))
            var list = moviedDao.getMovies()
            Log.d("THREADS", "from background")

            runOnUiThread {

                Log.d("THREADS", "from ui background")
                findViewById<TextView>(R.id.txt_description).text = list.last().movieName
            }
        }).start()


        for(i in 0..100000) {
            Log.d("THREADS", "from main activity $i")
        }

    }
}