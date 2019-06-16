package com.slh.myrateapp.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.slh.myrateapp.data.MoviesUseCase
import com.slh.myrateapp.model.MovieModel
import io.reactivex.disposables.CompositeDisposable

class MoviesListViewModel(val moviesUseCase: MoviesUseCase): ViewModel() {

    val moviesListObservable = MutableLiveData<List<MovieModel>>()

    val randomRateMoviesObservable = MutableLiveData<Boolean>()

    private val compositeDisposable = CompositeDisposable()

    fun getMoviesList() {
        compositeDisposable.add(moviesUseCase.getMoviesList()
            .subscribe({
                moviesListObservable.value = it
            }, {
                moviesListObservable.value = null
            }))
    }

    fun rateMovie(ratedMovie: MovieModel) {
        compositeDisposable.add(moviesUseCase.rateMovie(ratedMovie)
            .subscribe())
    }

    fun randomRateMovies() {
        compositeDisposable.add(moviesUseCase.randomRateMovies()
            .subscribe({
                randomRateMoviesObservable.value = true
            }, {
                randomRateMoviesObservable.value = false
            }))
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    class MoviesListViewModelFactory(val moviesUseCase: MoviesUseCase): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(MoviesListViewModel::class.java)) {
                return MoviesListViewModel(moviesUseCase) as T
            }
            throw IllegalArgumentException("Invalid View model class")
        }

    }
}