package com.slh.myrateapp.factory

import com.slh.myrateapp.model.MovieModel
import org.junit.Test

import org.junit.Assert.*

class MoviesListFactoryImplTest {

    @Test
    fun getMoviesList() {
        assertEquals(MoviesListFactoryImpl.getMoviesList().size, 10)
    }

    @Test
    fun test_call_getMoviesList_more_than_one_time() {
        MoviesListFactoryImpl.getMoviesList()
        assertEquals(MoviesListFactoryImpl.getMoviesList().size, 10)
    }

    @Test
    fun rateMovie() {
        MoviesListFactoryImpl.getMoviesList()
        val sampleMovieModel = MovieModel("Inception", 1.0)
        MoviesListFactoryImpl.rateMovie(sampleMovieModel)
        for (movie in MoviesListFactoryImpl.getMoviesList()) {
            if (movie.movieName.toLowerCase() == sampleMovieModel.movieName.toLowerCase()) {
                assertEquals(movie.movieRate, sampleMovieModel.movieRate, 0.0)
            }
        }
    }

    @Test
    fun randomRateMovies() {
        val listBeforeRandom = ArrayList<MovieModel>()
        for (movie in MoviesListFactoryImpl.getMoviesList()) {
            val m = MovieModel(movie.movieName, movie.movieRate)
            listBeforeRandom.add(m)
        }
        MoviesListFactoryImpl.randomRateMovies()
        val listAfterRandom = MoviesListFactoryImpl.getMoviesList()
        for (i in 0 until listBeforeRandom.size) {
            assertNotEquals(listBeforeRandom[i].movieRate, listAfterRandom[i].movieRate)
        }
    }

    @Test
    fun test_randomRateMovies_within_range() {
        MoviesListFactoryImpl.getMoviesList()
        MoviesListFactoryImpl.randomRateMovies()
        for (movie in MoviesListFactoryImpl.getMoviesList()) {
            assertTrue(movie.movieRate in 0.0..5.0)
        }
    }
}