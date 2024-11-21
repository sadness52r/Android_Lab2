package com.example.android_lab2

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_lab2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MovieAdapter.OnMovieClickListener{
    lateinit var binding: ActivityMainBinding
    private val adapter = MovieAdapter(this)
    private val imageIdList = listOf(
        R.drawable.pic1,
        R.drawable.pic2,
        R.drawable.pic3,
        R.drawable.pic4,
        R.drawable.pic5,
        R.drawable.pic6,
        R.drawable.pic7,
        R.drawable.pic8,
        R.drawable.pic9,
        R.drawable.pic10
    )
    private val titleList = listOf(
        "Берсерк",
        "Лолита",
        "Волк с Уолл-Стрит",
        "Интерстеллар",
        "Чернобыль",
        "Бандитский Петербург: Адвокат",
        "Побег из Шоушенка",
        "Американский пирог",
        "Пила",
        "Маяк"
    )
    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val inflater = LayoutInflater.from(this)
        val otherLayout = inflater.inflate(R.layout.movie_item, null)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init(){
        binding.apply {
            rcView.layoutManager = LinearLayoutManager(this@MainActivity)
            rcView.adapter = adapter
            for (i in 0 until imageIdList.size){
                val movie = Movie(imageIdList[i], titleList[i])
                adapter.addMovie(movie)
            }
        }
    }

    override fun onLikeClick(position: Int) {
        val likeButton = binding.rcView.findViewHolderForAdapterPosition(position)?.itemView?.findViewById<Button>(R.id.buttonLike)
        val dislikeButton = binding.rcView.findViewHolderForAdapterPosition(position)?.itemView?.findViewById<Button>(R.id.buttonDislike)

        likeButton?.setBackgroundColor(Color.RED)
        dislikeButton?.setBackgroundColor(Color.LTGRAY)
    }

    override fun onDislikeClick(position: Int) {
        val dislikeButton = binding.rcView.findViewHolderForAdapterPosition(position)?.itemView?.findViewById<Button>(R.id.buttonDislike)
        val likeButton = binding.rcView.findViewHolderForAdapterPosition(position)?.itemView?.findViewById<Button>(R.id.buttonLike)

        dislikeButton?.setBackgroundColor(Color.RED)
        likeButton?.setBackgroundColor(Color.LTGRAY)
    }
}