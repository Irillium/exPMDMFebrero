package edu.iesam.expmdmfebrero.features.collection.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.iesam.expmdmfebrero.features.collection.domain.Collection
import edu.iesam.expmdmfebrero.features.collection.domain.GetCollectionsUseCase
import edu.iesam.expmdmfebrero.features.collection.domain.GetFavoritesCollectionUseCase


class CollectionViewModel(
    private val getCollectionsUseCase: GetCollectionsUseCase,
    private val getFavoritesCollectionUseCase: GetFavoritesCollectionUseCase) : ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState:LiveData<UiState> get() =  _uiState

    fun loadCollections(){
        val collections = getCollectionsUseCase.invoke()
        _uiState.postValue(UiState(collections=collections))
    }
    fun loadFavoritesCollections(){
        val collections = getFavoritesCollectionUseCase.invoke()
        _uiState.postValue(UiState(collections=collections))
    }
    data class UiState(
        val isLoading:Boolean=false,
        val String:Error?=null,
        val collections:List<Collection>?=null
    )
}