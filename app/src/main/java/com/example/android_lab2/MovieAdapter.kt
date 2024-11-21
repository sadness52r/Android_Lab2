package com.example.android_lab2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.android_lab2.databinding.MovieItemBinding

class MovieAdapter(private val clickListener: OnMovieClickListener): RecyclerView.Adapter<MovieAdapter.MovieHolder>() {
    val movieList = ArrayList<Movie>()

    interface OnMovieClickListener {
        fun onLikeClick(position: Int)
        fun onDislikeClick(position: Int)
    }

    class MovieHolder(item: View, private val clickListener: OnMovieClickListener): RecyclerView.ViewHolder(item) {
        val binding = MovieItemBinding.bind(item)

        fun bind(movie: Movie) = with(binding){
            im.setImageResource(movie.imageId)
            tvTitle.text = movie.title

            buttonLike.setOnClickListener {
                clickListener.onLikeClick(position)
            }
            buttonDislike.setOnClickListener {
                clickListener.onDislikeClick(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        return MovieHolder(view, clickListener)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        holder.bind(movieList[position])
    }

    fun addMovie(movie: Movie){
        movieList.add(movie)
        notifyDataSetChanged()
    }


}