package com.example.mydevesstream.model.movieList

data class movieResponseModel(
    val Response: String,
    val Search: List<Search>,
    val totalResults: String
)