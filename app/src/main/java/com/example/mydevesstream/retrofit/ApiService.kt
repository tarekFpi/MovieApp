package com.example.mydevesstream.retrofit

import com.example.mydevesstream.model.movieList.movieResponseModel
import retrofit2.http.GET


interface ApiService {

    @GET("/?apikey=e54276c0&s=movie")
    suspend fun getItems() : movieResponseModel

}