package com.slh.myrateapp.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.slh.myrateapp.R
import com.slh.myrateapp.model.MovieModel
import kotlinx.android.synthetic.main.movies_list_item.view.*

class MoviesListAdapter:
    RecyclerView.Adapter<MoviesListAdapter.MoviesHolder>(){
    private var moviesList: List<MovieModel> = ArrayList<MovieModel>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesHolder {
        return MoviesHolder(LayoutInflater.from(parent.context).inflate(R.layout.movies_list_item, parent, false))
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

    override fun onBindViewHolder(holder: MoviesHolder, position: Int) {
        holder.bind(moviesList[position])

    }

    fun setMoviesList(movies: List<MovieModel>) {
        this.moviesList = movies.sortedBy { it.movieRate }.toList().reversed()
        notifyDataSetChanged()
    }

    private fun reSortList() {
        this.moviesList = moviesList.sortedBy { it.movieRate }.toList().reversed()
        notifyDataSetChanged()
    }

    class MoviesHolder(view: View): RecyclerView.ViewHolder(view) {
        fun bind(movieModel: MovieModel) {
            itemView.movieNameTV.text = movieModel.movieName
            itemView.movieRateStarsView.rating = movieModel.movieRate.toFloat()
        }
    }
}