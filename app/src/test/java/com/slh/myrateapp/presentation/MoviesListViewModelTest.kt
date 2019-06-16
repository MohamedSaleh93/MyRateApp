package com.slh.myrateapp.presentation

import com.slh.myrateapp.data.MoviesUseCase
import com.slh.myrateapp.factory.MoviesListFactoryImpl
import com.slh.myrateapp.model.MovieModel
import io.reactivex.Single
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Rule
import java.lang.Exception


class MoviesListViewModelTest {

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()
    @Mock
    lateinit var moviesUseCase: MoviesUseCase

    lateinit var moviesViewMovieModel: MoviesListViewModel

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        RxJavaPlugins.setIoSchedulerHandler { Schedulers.trampoline() }
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }
        moviesViewMovieModel = MoviesListViewModel(moviesUseCase)
    }

    @Test
    fun getMoviesList() {
        val mockedList = buildMoviesMockList()
        Mockito.`when`(moviesUseCase.getMoviesList()).thenReturn(Single.just(mockedList))
        moviesViewMovieModel.getMoviesList()
        assertEquals(moviesViewMovieModel.moviesListObservable.value, mockedList)
    }

    @Test
    fun test_exception_getMoviesList() {
        Mockito.`when`(moviesUseCase.getMoviesList()).thenReturn(Single.error(Throwable()))
        moviesViewMovieModel.getMoviesList()
        assertEquals(moviesViewMovieModel.moviesListObservable.value, null)
    }


    @Test
    fun rateMovie() {
    }

    @Test
    fun randomRateMovies() {
    }

    private fun buildMoviesMockList(): List<MovieModel> {
        val moviesList = ArrayList<MovieModel>()
        moviesList.add(MovieModel("Inception", 5.0))
        moviesList.add(MovieModel("Oldboy", 4.9))
        moviesList.add(MovieModel("Bridge Of Spies", 4.8))
        moviesList.add(MovieModel("The shawshank Redemption", 4.7))
        moviesList.add(MovieModel("Intersteller", 4.5))
        moviesList.add(MovieModel("Pulp fiction", 4.4))
        moviesList.add(MovieModel("Kill Bill ", 4.3))
        moviesList.add(MovieModel("The Good, The Bad and The Ugle", 3.5))
        moviesList.add(MovieModel("The Message", 4.6))
        moviesList.add(MovieModel("Get Out", 2.1))
        return moviesList
    }
}