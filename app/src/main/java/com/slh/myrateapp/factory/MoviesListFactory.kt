package com.slh.myrateapp.factory

import com.slh.myrateapp.model.MovieModel

interface MoviesListFactory {

    fun getMoviesList(): List<MovieModel>

    fun rateMovie(ratedMovie: MovieModel)

    fun randomRateMovies()
}