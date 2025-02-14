package edu.iesam.expmdmfebrero.features.collection.domain

class GetFavoritesCollectionUseCase(private val repository: CollectionRepository) {
    fun invoke():List<Collection>{
        return repository.getAll().filter { it.favorite }
    }
}