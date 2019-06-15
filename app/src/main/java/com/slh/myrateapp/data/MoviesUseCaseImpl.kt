package com.slh.myrateapp.data

import com.slh.myrateapp.model.MovieModel
import io.reactivex.Completable
import io.reactivex.Single

class MoviesUseCaseImpl(val moviesLocalDataSource: MoviesDataSource): MoviesUseCase {

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