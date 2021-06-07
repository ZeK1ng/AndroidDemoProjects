package ge.ezarkua.mvpdemo.main

import android.os.AsyncTask
import ge.ezarkua.mvpdemo.data.DemoDatabase
import ge.ezarkua.mvpdemo.data.entity.Movie

class MainInteractor(val presenter: IMainPresenter) {
    fun getMoviesListFromDatabase() {
       GetMoviesTask(presenter).execute()
    }

    class GetMoviesTask(val presenter: IMainPresenter): AsyncTask<Void, Void, List<Movie>>(){
        override fun doInBackground(vararg params: Void?): List<Movie> {
            var moviedDao = DemoDatabase.getInstance().moviesDao()
            moviedDao.addMovie(Movie("Friends: The Reunion", 0f))
            var list = moviedDao.getMovies()
            return list
        }

        override fun onPostExecute(result: List<Movie>?) {
            super.onPostExecute(result)
            if(result != null) {
                presenter.onMovieListFetched(result)
            }
        }
    }
}