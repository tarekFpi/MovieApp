package com.example.mydevesstream.view
import android.annotation.SuppressLint
import android.os.Bundle

import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import  androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import com.example.mydevesstream.R
import com.squareup.picasso.Picasso


class MovieDetailsActivity : AppCompatActivity() {


    private lateinit var movieImage:String

    private lateinit var textViewMovieTitle: TextView

    private lateinit var textViewMovieYear: TextView

    private lateinit var imageView: ImageView

    private lateinit var toolbar: Toolbar

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

          toolbar  = findViewById(R.id.toolbar)
         setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

          // Change the back button color
        toolbar.navigationIcon?.setTint(ContextCompat.getColor(this, R.color.white))
       supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_baseline_keyboard_arrow_down_24)

        textViewMovieTitle = findViewById(R.id.text_detailsmovieName)

        textViewMovieYear = findViewById(R.id.movie_detailstext_year)

        imageView = findViewById(R.id.moviedetailsImage)

    }

    // Handle back button click
    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed() // Handle the back navigation
        return true
    }

    override fun onResume() {
        super.onResume()

        val bundle: Bundle? = intent.extras

        if (bundle != null) {

            movieImage =  bundle.getString("Poster").toString()

            textViewMovieTitle.text = bundle.getString("Title").toString()

            textViewMovieYear.text = bundle.getString("Year").toString()

             Picasso.get().load(movieImage).into(imageView)


        }
    }
}