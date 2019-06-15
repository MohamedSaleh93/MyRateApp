package com.slh.myrateapp.data

import com.slh.myrateapp.model.MovieModel
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import io.reactivex.schedulers.TestScheduler
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class MoviesUseCaseImplTest {


    lateinit var moviesUseCase: MoviesUseCase

    @Mock
    lateinit var moviesDataSource: MoviesDataSource

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        RxJavaPlugins.setIoSchedulerHandler { Schedulers.trampoline() }
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }
        moviesUseCase = MoviesUseCaseImpl(moviesDataSource, Schedulers.io(), AndroidSchedulers.mainThread())
    }

    @Test
    fun getMoviesList() {
        Mockito.`when`(moviesDataSource.getMoviesList()).thenReturn(Single.just(ArrayList<MovieModel>()))
        moviesUseCase.getMoviesList().test().dispose()
    }

    @Test
    fun rateMovie() {
        val sampleMovieModel = MovieModel("Inception", 4.2)
        Mockito.`when`(moviesDataSource.rateMovie(sampleMovieModel)).thenReturn(Completable.create {  })
        moviesUseCase.rateMovie(sampleMovieModel).test().dispose()
    }

    @Test
    fun randomRateMovies() {
        Mockito.`when`(moviesDataSource.randomRateMovies()).thenReturn(Completable.create {  })
        moviesUseCase.randomRateMovies().test().dispose()
    }
}