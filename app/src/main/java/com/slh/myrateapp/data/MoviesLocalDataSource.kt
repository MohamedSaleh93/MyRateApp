package com.slh.myrateapp.data

import com.slh.myrateapp.factory.MoviesListFactory
import com.slh.myrateapp.factory.MoviesListFactoryImpl
import com.slh.myrateapp.model.MovieModel
import io.reactivex.Completable
import io.reactivex.Single

class MoviesLocalDataSource: MoviesDataSource {

    override fun getMoviesList(): Single<List<MovieModel>> {
        return Single.just(MoviesListFactoryImpl.getMoviesList())
    }

    override fun rateMovie(ratedMovie: MovieModel): Completable {
        return Completable.create {
            MoviesListFactoryImpl.rateMovie(ratedMovie)
        }
    }

    override fun randomRateMovies(): Completable {
        return Completable.create {
            MoviesListFactoryImpl.randomRateMovies()
        }
    }
}