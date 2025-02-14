package edu.iesam.expmdmfebrero.features.collection.domain

interface CollectionRepository {
    fun getAll():List<Collection>
    fun save(collection: Collection)
}