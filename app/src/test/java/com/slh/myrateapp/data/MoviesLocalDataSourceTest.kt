package com.slh.myrateapp.data


import com.slh.myrateapp.model.MovieModel
import org.junit.Before
import org.junit.Test

import org.mockito.MockitoAnnotations

class MoviesLocalDataSourceTest {

    lateinit var moviesDataSource: MoviesDataSource

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        moviesDataSource = MoviesLocalDataSource()
    }

    @Test
    fun getMoviesList() {
        moviesDataSource.getMoviesList().test().assertComplete().dispose()
    }

    @Test
    fun rateMovie() {
        val sampleMovie = MovieModel("Inception", 2.5)
        moviesDataSource.rateMovie(sampleMovie).test().dispose()
    }

    @Test
    fun randomRateMovies() {
        moviesDataSource.randomRateMovies().test().dispose()
    }
}