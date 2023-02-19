package com.krisna.airwise.data.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.krisna.airwise.data.AirVisualRepository
import com.krisna.airwise.data.models.AirVisualData
import kotlinx.coroutines.launch

class AirVisualViewModel(private val repository: AirVisualRepository): ViewModel() {
    private val _data = MutableLiveData<AirVisualData>()
    val data: LiveData<AirVisualData> = _data

    fun loadData() {
        viewModelScope.launch {
            val result = repository.getNearestCity()
            _data.value = result
        }
    }
}