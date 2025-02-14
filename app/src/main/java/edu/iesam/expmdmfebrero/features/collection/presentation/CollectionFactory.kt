package edu.iesam.expmdmfebrero.features.collection.presentation

import android.content.Context
import edu.iesam.expmdmfebrero.features.collection.data.CollectionDataRepository
import edu.iesam.expmdmfebrero.features.collection.data.LocalCollectionDataSource
import edu.iesam.expmdmfebrero.features.collection.domain.GetCollectionsUseCase
import edu.iesam.expmdmfebrero.features.collection.domain.GetFavoritesCollectionUseCase

class CollectionFactory (val context: Context) {
    val local = LocalCollectionDataSource(context)
    val repo = CollectionDataRepository(local)
    val getCollectionsUseCase = GetCollectionsUseCase(repo)
    val getFavoritesCollectionUseCase = GetFavoritesCollectionUseCase(repo)

    fun buildViewModel():CollectionViewModel{
        return CollectionViewModel(getCollectionsUseCase, getFavoritesCollectionUseCase)
    }
}