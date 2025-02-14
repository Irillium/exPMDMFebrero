package edu.iesam.expmdmfebrero.features.collection.domain




class GetCollectionsUseCase(private val collectionRepository: CollectionRepository) {
    fun invoke():List<Collection>{
        return  collectionRepository.getAll()
    }
}