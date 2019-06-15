package com.slh.myrateapp.data

import com.slh.myrateapp.model.MovieModel
import io.reactivex.Completable
import io.reactivex.Scheduler
import io.reactivex.Single

class MoviesUseCaseImpl(val moviesLocalDataSource: MoviesDataSource,
                        val subscribeOnThread: Scheduler,
                        val observeOnThread: Scheduler): MoviesUseCase {

    override fun getMoviesList(): Single<List<MovieModel>> {
        return moviesLocalDataSource.getMoviesList()
            .subscribeOn(subscribeOnThread)
            .observeOn(observeOnThread)
    }

    override fun rateMovie(ratedMovie: MovieModel): Completable {
        return moviesLocalDataSource.rateMovie(ratedMovie)
            .subscribeOn(subscribeOnThread)
            .observeOn(observeOnThread)
    }

    override fun randomRateMovies(): Completable {
        return moviesLocalDataSource.randomRateMovies()
            .subscribeOn(subscribeOnThread)
            .observeOn(observeOnThread)
    }
}