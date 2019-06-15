package com.slh.myrateapp.data

import com.slh.myrateapp.factory.MoviesListFactory
import com.slh.myrateapp.model.MovieModel
import io.reactivex.Completable
import io.reactivex.Single

class MoviesLocalDataSource(val moviesListFactory: MoviesListFactory): MoviesDataSource {

    override fun getMoviesList(): Single<List<MovieModel>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun rateMovie(ratedMovie: MovieModel): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun randomRateMovies(): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}