package com.slh.myrateapp.factory

import com.slh.myrateapp.model.MovieModel

object MoviesListFactoryImpl: MoviesListFactory {

    private var moviesList = ArrayList<MovieModel>()

    override fun getMoviesList(): List<MovieModel> {
        if (moviesList.size == 0) {
            buildMoviesList()
        }
        return moviesList
    }

    override fun rateMovie(ratedMovie: MovieModel) {

    }

    override fun randomRateMovies() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun buildMoviesList() {
        moviesList.add(MovieModel("Inception", 5.0))
        moviesList.add(MovieModel("Oldboy", 4.9))
        moviesList.add(MovieModel("Bridge Of Spies", 4.8))
        moviesList.add(MovieModel("The shawshank Redemption", 4.7))
        moviesList.add(MovieModel("Intersteller", 4.5))
        moviesList.add(MovieModel("Pulp fiction", 4.4))
        moviesList.add(MovieModel("Kill Bill ", 4.3))
        moviesList.add(MovieModel("The Good, The Bad and The Ugle", 3.5))
        moviesList.add(MovieModel("The Message", 4.6))
        moviesList.add(MovieModel("Get Out", 2.1))
    }
}