package com.example.mydevesstream.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mydevesstream.model.movieList.Search
import com.example.mydevesstream.retrofit.ApiService
import com.example.mydevesstream.utils.Resource
import javax.inject.Inject

class MovieRepository @Inject constructor(val apiService: ApiService){




    suspend  fun getMovieList() = apiService.getItems()




    /*    private var movieResponseMutableLiveData = MutableLiveData<Resource<List<Search>>>()
          val movieResponseLiveData: LiveData<Resource<List<Search>>>
            get() = movieResponseMutableLiveData



        suspend  fun getMovieList(){


            val  response=  apiService.getItems()

            try {
                movieResponseMutableLiveData.postValue(Resource.Loading())

                if(response.Search != null){

                    movieResponseMutableLiveData.postValue(Resource.Success(response.Search))

                }
                else{
                    movieResponseMutableLiveData.postValue(Resource.Error("Something Went Wrong ${response}"))

                    Log.i("movieResponseMutableLiveData:","${response.toString()}")
                }

            } catch(e: Exception) {

                movieResponseMutableLiveData.postValue(Resource.Error(e.message))
            }


        }*/
}