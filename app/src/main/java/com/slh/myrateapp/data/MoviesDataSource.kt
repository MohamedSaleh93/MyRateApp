package com.slh.myrateapp.data

import com.slh.myrateapp.model.MovieModel
import io.reactivex.Completable
import io.reactivex.Single

interface MoviesDataSource {

    fun getMoviesList(): Single<List<MovieModel>>

    fun rateMovie(ratedMovie: MovieModel): Completable

    fun randomRateMovies(): Completable
}