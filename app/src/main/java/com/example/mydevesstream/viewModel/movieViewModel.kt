package com.example.mydevesstream.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mydevesstream.model.movieList.Search
import com.example.mydevesstream.repository.MovieRepository
import com.example.mydevesstream.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(private val movieRepository: MovieRepository) : ViewModel() {

    private var movieResponseMutableLiveData = MutableLiveData<Resource<List<Search>>>()
    val movieResponseLiveData: LiveData<Resource<List<Search>>>
    get() = movieResponseMutableLiveData

    init {

        showMovieList()
    }


    fun showMovieList() {

        viewModelScope.launch(Dispatchers.Main) {

            val response = movieRepository.getMovieList()

            try {
                movieResponseMutableLiveData.postValue(Resource.Loading())

                if (response.Search != null) {

                    movieResponseMutableLiveData.postValue(Resource.Success(response.Search))
                 //   _movieResponseMutableLiveData.value =Resource.Success(response.searchlist)

                } else {
                    movieResponseMutableLiveData.postValue(Resource.Error("Something Went Wrong"))
                }

            } catch (e: Exception) {

                movieResponseMutableLiveData.postValue(Resource.Error(e.message))
            }

        }
    }


}