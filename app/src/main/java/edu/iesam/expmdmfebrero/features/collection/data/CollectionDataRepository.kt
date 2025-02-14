package edu.iesam.expmdmfebrero.features.collection.data

import edu.iesam.expmdmfebrero.features.collection.domain.Collection
import edu.iesam.expmdmfebrero.features.collection.domain.CollectionRepository
import org.koin.core.annotation.Single

@Single
class CollectionDataRepository(private val local: LocalCollectionDataSource):CollectionRepository {
    override fun getAll(): List<Collection> {
       return local.getCollections()
    }

    override fun save(collection: Collection) {
        
        local.addCollection(collection)
    }


}