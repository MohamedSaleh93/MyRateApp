package com.slh.myrateapp.factory

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
    }

    @Test
    fun randomRateMovies() {
    }
}