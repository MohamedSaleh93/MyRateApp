package com.slh.myrateapp.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.slh.myrateapp.data.MoviesUseCase
import com.slh.myrateapp.model.MovieModel
import io.reactivex.disposables.CompositeDisposable

class MoviesListViewModel(val moviesUseCase: MoviesUseCase): ViewModel() {

    val moviesListObservable = MutableLiveData<List<MovieModel>>()

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

    }

    fun randomRateMovies() {

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