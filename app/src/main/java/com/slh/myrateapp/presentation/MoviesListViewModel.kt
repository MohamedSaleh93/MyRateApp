package com.slh.myrateapp.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.slh.myrateapp.data.MoviesUseCase
import com.slh.myrateapp.model.MovieModel

class MoviesListViewModel(val moviesUseCase: MoviesUseCase): ViewModel() {

    val moviesListObservable = MutableLiveData<List<MovieModel>>()

    fun getMoviesList() {

    }

    fun rateMovie(ratedMovie: MovieModel) {

    }

    fun randomRateMovies() {

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