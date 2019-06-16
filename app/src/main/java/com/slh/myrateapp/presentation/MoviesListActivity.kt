package com.slh.myrateapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.slh.myrateapp.R
import com.slh.myrateapp.data.MoviesLocalDataSource
import com.slh.myrateapp.data.MoviesUseCaseImpl
import com.slh.myrateapp.model.MovieModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_movies_list.*
import java.util.concurrent.TimeUnit

class MoviesListActivity: AppCompatActivity() {

    var disposableTimer: Disposable? = null

    private lateinit var moviesListViewModel: MoviesListViewModel
    private lateinit var moviesAdapter: MoviesListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies_list)

        inject()

        moviesListViewModel.moviesListObservable.observe(this, Observer {
            handleWhenMoviesLoaded(it)
        })

        rateMoviesTV.setOnClickListener {
            if (rateMoviesTV.text == getString(R.string.rate_movies_random)) {
                rateMoviesTV.text = getString(R.string.stop_rate_movies_random)
                disposableTimer = Observable.interval(10L, TimeUnit.SECONDS)
                    .timeInterval()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe {
                        moviesListViewModel.randomRateMovies()
                        moviesListViewModel.getMoviesList()
                    }
                moviesListViewModel.randomRateMovies()
                moviesListViewModel.getMoviesList()
            } else if (rateMoviesTV.text == getString(R.string.stop_rate_movies_random)) {
                rateMoviesTV.text = getString(R.string.rate_movies_random)
                disposableTimer?.dispose()
            }
        }

        moviesAdapter = MoviesListAdapter()
        moviesRV.layoutManager = LinearLayoutManager(this)
        moviesRV.adapter = moviesAdapter

        moviesListViewModel.getMoviesList()
    }

    private fun inject() {
        val moviesUseCase = MoviesUseCaseImpl(MoviesLocalDataSource(), Schedulers.io(), AndroidSchedulers.mainThread())
        val moviesListViewModelFactory = MoviesListViewModel.MoviesListViewModelFactory(moviesUseCase)
        moviesListViewModel = ViewModelProviders.of(this, moviesListViewModelFactory).get(MoviesListViewModel::class.java)
    }

    private fun handleWhenMoviesLoaded(moviesList: List<MovieModel>?) {
        if (moviesList != null) {
            moviesAdapter.setMoviesList(moviesList)
        }
    }

    override fun onStop() {
        super.onStop()
        if (disposableTimer?.isDisposed == false) {
            disposableTimer?.dispose()
        }
    }

}