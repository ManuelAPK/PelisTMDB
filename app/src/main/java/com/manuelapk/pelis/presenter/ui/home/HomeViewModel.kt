package com.manuelapk.pelis.presenter.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.manuelapk.pelis.data.model.Response
import com.manuelapk.pelis.data.model.TimeWindow
import com.manuelapk.pelis.data.model.TrendingMovieApi
import com.manuelapk.pelis.domain.model.TrendingMovie
import com.manuelapk.pelis.domain.usecase.GetMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getMoviesUseCase: GetMoviesUseCase
) : ViewModel() {

    private val _list = MutableLiveData<List<TrendingMovie>>()
    val list: LiveData<List<TrendingMovie>> get() = _list

    fun getMovies() {
        viewModelScope.launch {
            val response = getMoviesUseCase(timeWindow = TimeWindow.DAY)
            if (response is Response.Successful) {
                _list.value = response.data.orEmpty()
            }
        }
    }

    init {
        getMovies()
    }
}