package edu.iesam.expmdmfebrero.features.collection.data

import edu.iesam.expmdmfebrero.features.collection.domain.Collection
import edu.iesam.expmdmfebrero.features.collection.domain.CollectionRepository


class CollectionDataRepository(private val local: LocalCollectionDataSource):CollectionRepository {
    override fun getAll(): List<Collection> {
       return local.getCollections()
    }

    override fun saveAll(collection: List<Collection>) {

        local.saveCollections(collection)
    }


}