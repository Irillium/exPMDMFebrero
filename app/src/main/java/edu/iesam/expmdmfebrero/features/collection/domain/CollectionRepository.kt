package edu.iesam.expmdmfebrero.features.collection.domain

interface CollectionRepository {
    fun getAll():List<Collection>
    fun saveAll(collection: List<Collection>)
    fun deleteByName(name:String)
    fun save(collection: Collection)
}