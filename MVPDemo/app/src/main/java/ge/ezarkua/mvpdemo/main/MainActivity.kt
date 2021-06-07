package ge.ezarkua.mvpdemo.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ge.ezarkua.mvpdemo.R
import ge.ezarkua.mvpdemo.data.DemoDatabase
import ge.ezarkua.mvpdemo.data.entity.Movie
import ge.ezarkua.mvpdemo.details.DetailsActivity

class MainActivity : AppCompatActivity(), IMainView, MovieListListener {

    private lateinit var rvMovies: RecyclerView
    private lateinit var presenter: MainPresenter
    private var adapter = MovieAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()

        presenter = MainPresenter(this)

        presenter.getMovies()

    }

    //პრესენტერში არ უნდა დაგვრჩეს ვიუს ლისენერი აქტიური როცა აქთივისი დაიხურება
    override fun onDestroy() {
        presenter.detachView()
        super.onDestroy()
    }

    private fun initView() {
        rvMovies = findViewById(R.id.rvMovies)
        rvMovies.adapter = adapter
    }

    override fun showLastMovieName(movies: List<Movie>) {
        adapter.list = movies
        adapter.notifyDataSetChanged()
    }

    override fun onMovieItemClicked(movie: Movie) {
        DetailsActivity.start(this, movie.id)
    }
}

interface MovieListListener {
    fun onMovieItemClicked(movie: Movie)
}