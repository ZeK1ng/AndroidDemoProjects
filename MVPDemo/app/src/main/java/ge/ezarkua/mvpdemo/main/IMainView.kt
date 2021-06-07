package ge.ezarkua.mvpdemo.main

import ge.ezarkua.mvpdemo.data.entity.Movie

interface IMainView {
    fun showLastMovieName(movies: List<Movie>)
}