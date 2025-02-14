package edu.iesam.expmdmfebrero.features.collection.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.iesam.expmdmfebrero.features.collection.domain.Collection
import edu.iesam.expmdmfebrero.features.collection.domain.GetCollectionsUseCase
import org.koin.android.annotation.KoinViewModel


class CollectionViewModel(private val getCollectionsUseCase: GetCollectionsUseCase) : ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState:LiveData<UiState> get() =  _uiState

    fun loadCollections(){
        val collections = getCollectionsUseCase
        _uiState.value
    }

    data class UiState(
        val isLoading:Boolean=false,
        val String:Error?=null,
        val collections:List<Collection>?=null
    )
}