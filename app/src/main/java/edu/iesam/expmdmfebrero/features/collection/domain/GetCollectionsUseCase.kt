package edu.iesam.expmdmfebrero.features.collection.domain

import org.koin.core.annotation.Single

@Single
class GetCollectionsUseCase(private val collectionRepository: CollectionRepository) {
    fun invoke():List<Collection>{
        return  collectionRepository.getAll()
    }
}