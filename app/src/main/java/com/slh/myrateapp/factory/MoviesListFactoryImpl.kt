package com.slh.myrateapp.factory

import com.slh.myrateapp.model.MovieModel
import java.text.DecimalFormat
import kotlin.random.Random

object MoviesListFactoryImpl: MoviesListFactory {

    private var moviesList = ArrayList<MovieModel>()

    override fun getMoviesList(): List<MovieModel> {
        if (moviesList.size == 0) {
            buildMoviesList()
        }
        return moviesList
    }

    override fun rateMovie(ratedMovie: MovieModel) {
        for (i in 0 until moviesList.size) {
            if (moviesList[i].movieName.toLowerCase() == ratedMovie.movieName.toLowerCase()) {
                moviesList[i].movieRate = ratedMovie.movieRate
            }
        }
    }

    override fun randomRateMovies() {
        val min = 0.0
        val max = 5.0
        val r = Random(0)
        for (i in 0 until moviesList.size) {
            val nextD = (r.nextDouble((max - min) + 1) + min) % max
            moviesList[i].movieRate = DecimalFormat("0.0").format(nextD).toDouble()
        }
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