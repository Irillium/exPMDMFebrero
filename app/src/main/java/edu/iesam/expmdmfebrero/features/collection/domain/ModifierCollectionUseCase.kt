package edu.iesam.expmdmfebrero.features.collection.domain

class ModifierCollectionUseCase(private val repository: CollectionRepository) {
    fun invoke(collection: Collection, isFavorite:Boolean){
        repository.deleteByName(collection.name)
        repository.save(Collection(
            collection.name,
            collection.creationDate,
            collection.descriptionString,
            collection.image,
            isFavorite))
    }
}