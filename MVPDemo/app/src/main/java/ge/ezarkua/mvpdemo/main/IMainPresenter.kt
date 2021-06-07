package ge.ezarkua.mvpdemo.main

import ge.ezarkua.mvpdemo.data.entity.Movie

interface IMainPresenter {
    abstract fun onMovieListFetched(movies: List<Movie>)
}