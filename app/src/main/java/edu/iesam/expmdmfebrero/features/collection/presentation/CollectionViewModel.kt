package edu.iesam.expmdmfebrero.features.collection.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.iesam.expmdmfebrero.features.collection.domain.Collection
import edu.iesam.expmdmfebrero.features.collection.domain.GetCollectionsUseCase
import edu.iesam.expmdmfebrero.features.collection.domain.GetFavoritesCollectionUseCase
import edu.iesam.expmdmfebrero.features.collection.domain.ModifierCollectionUseCase


class CollectionViewModel(
    private val getCollectionsUseCase: GetCollectionsUseCase,
    private val getFavoritesCollectionUseCase: GetFavoritesCollectionUseCase,
    private val modifierCollectionUseCase: ModifierCollectionUseCase) : ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState:LiveData<UiState> get() =  _uiState

    fun loadCollections(){
        val collections = getCollectionsUseCase.invoke()
        _uiState.postValue(UiState(
            collections = collections,
            onClick = ::modifierCollection
        ))
    }
    fun loadFavoritesCollections(){
        val collections = getFavoritesCollectionUseCase.invoke()
        _uiState.postValue(UiState(
            collections =collections,
            onClick = ::modifierCollection))
    }

    fun modifierCollection(collection: Collection, isFavorite:Boolean){
        modifierCollectionUseCase.invoke(collection,isFavorite)
    }

    data class UiState(
        val isLoading:Boolean=false,
        val String:Error?=null,
        val onClick: ((Collection, Boolean) -> Unit)? = null,
        val collections:List<Collection>?=null
    )
}