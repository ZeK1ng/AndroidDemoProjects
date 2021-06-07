package ge.ezarkua.mvpdemo.details

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ge.ezarkua.mvpdemo.R

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        var id = intent.getIntExtra(MOVIE_ID_EXTRA, 0)
    }

    companion object{
        const val MOVIE_ID_EXTRA = "movieId"
        fun start(context: Context, id: Int){
            context.startActivity(Intent(context, DetailsActivity::class.java).apply {
                putExtra(MOVIE_ID_EXTRA, id)
            })
        }
    }
}