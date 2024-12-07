package com.example.mydevesstream.view

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.models.SlideModel
import com.example.mydevesstream.R
import com.example.mydevesstream.adapter.MovieListAdapter
import com.example.mydevesstream.model.movieList.Search
import com.example.mydevesstream.utils.CheckInternetConnection
import com.example.mydevesstream.utils.Resource
import com.example.mydevesstream.viewModel.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private lateinit var movieAdapter : MovieListAdapter

    private lateinit var recyclerMovieList: RecyclerView

    private var movieList: ArrayList<Search> = ArrayList()

    private lateinit var movieListViewModel: MovieViewModel

    private lateinit var  progressDialog: ProgressDialog

    @Inject
    lateinit var checkInternetConnection: CheckInternetConnection

    private lateinit var  editText_TaskSearch: EditText

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        movieListViewModel= ViewModelProvider(this)[MovieViewModel::class.java]

        recyclerMovieList = findViewById(R.id.recyclerView_movieList)

        progressDialog = ProgressDialog(this)
        progressDialog.setMessage("please wait...")
        progressDialog.show()

        val imageSlider = findViewById<ImageSlider>(R.id.image_slider)
        val imageList = ArrayList<SlideModel>()

        imageList.add(SlideModel(R.drawable.image1))
        imageList.add(SlideModel(R.drawable.image2))
        imageList.add(SlideModel(R.drawable.image3))
        imageList.add(SlideModel(R.drawable.image4))

        imageSlider.setImageList(imageList)


        editText_TaskSearch= findViewById(R.id.edit_movieSearch)

        editText_TaskSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(editable: Editable) {

               searchTaskList(editable.toString())
            }
        })

        internetConnection()
    }

    private fun searchTaskList(textData: String) {
        try {
            val list =ArrayList<Search>()


            for (item:Search in movieList) {

                if (item.Year.toString().lowercase().contains(textData.toString().lowercase()) || item.Title.toString().lowercase().contains(textData.toString().lowercase()))
                {
                    list.add(item)
                }
            }

            movieAdapter.filterdList(list)

        } catch (exception: Exception) {

            Toast.makeText(this, "${exception.toString()}", Toast.LENGTH_SHORT).show()
        }

    }


    override fun onResume() {
        super.onResume()

        movieAdapter= MovieListAdapter(this@HomeActivity,movieList)

        recyclerMovieList.apply {
            setHasFixedSize(true)
            layoutManager= LinearLayoutManager(this@HomeActivity)
            adapter=movieAdapter
        }


        movieListViewModel.movieResponseLiveData.observe(this@HomeActivity, Observer {

            when(it){
                is Resource.Loading -> {
                    progressDialog.show()

                }

                is Resource.Error -> {


                    progressDialog.dismiss()

                    Toast.makeText(this, "${it.message}", Toast.LENGTH_SHORT).show()
                }

                is  Resource.Success -> {

                    movieList.addAll(it.data!!)
                    movieAdapter.setMovieList(movieList)
                    progressDialog.dismiss()

                    movieAdapter.setOnItemClick(object :MovieListAdapter.onItemClickLisiner{
                        override fun OnClickLisiner(position: Int) {


                            startActivity(Intent(this@HomeActivity, MovieDetailsActivity::class.java).apply {
                                putExtra("Title", it.data[position].Title)
                                putExtra("Year", it.data[position].Year)
                                putExtra("Poster", it.data[position].Poster)

                            })

                        }
                    })

                }
            }

        })



    }



    private  fun internetConnection(){

        if (checkInternetConnection.isInternetAvailable(this)) else
            Toast.makeText(this, "No Internet", Toast.LENGTH_SHORT).show()

    }
}