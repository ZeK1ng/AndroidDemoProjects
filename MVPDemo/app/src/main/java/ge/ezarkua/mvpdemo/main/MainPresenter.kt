package ge.ezarkua.mvpdemo.main

import ge.ezarkua.mvpdemo.data.entity.Movie

class MainPresenter(var view: IMainView?) : IMainPresenter{

    private val interactor = MainInteractor(this)

    fun getMovies() {
        interactor.getMoviesListFromDatabase()
    }

    override fun onMovieListFetched(movies: List<Movie>) {
        view?.showLastMovieName(movies)
    }

    fun detachView() {
        view = null
    }
}