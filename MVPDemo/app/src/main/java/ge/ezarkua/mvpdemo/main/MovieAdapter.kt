package ge.ezarkua.mvpdemo.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ge.ezarkua.mvpdemo.R
import ge.ezarkua.mvpdemo.data.entity.Movie

class MovieAdapter(val listListener: MovieListListener): RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    var list = listOf<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
       return MovieViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.movie_item,parent, false))
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = list[position]
        holder.bindMovie(movie)
        holder.itemView.setOnClickListener {
            listListener.onMovieItemClicked(movie)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }


    inner class MovieViewHolder(view: View): RecyclerView.ViewHolder(view){
        fun bindMovie(movie: Movie) {
            txtName.text = movie.movieName
            txtRating.text = movie.rating.toString()
        }

        private val txtName = view.findViewById<TextView>(R.id.txtName)
        private val txtRating = view.findViewById<TextView>(R.id.txtRate)
    }
}