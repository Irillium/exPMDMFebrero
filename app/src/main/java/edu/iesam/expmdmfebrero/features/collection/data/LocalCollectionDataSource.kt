package edu.iesam.expmdmfebrero.features.collection.data

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import edu.iesam.expmdmfebrero.features.collection.domain.Collection
import org.koin.core.annotation.Single

@Single
class LocalCollectionDataSource(context: Context) {
    private val sharedPreferences = context.getSharedPreferences("collection_prefs", Context.MODE_PRIVATE)
    private val gson = Gson()

    companion object {
        private const val COLLECTIONS_KEY = "collections_list"
    }

    fun saveCollections(collections: List<Collection>) {
        val json = gson.toJson(collections)
        sharedPreferences.edit().putString(COLLECTIONS_KEY, json).apply()
    }

    fun getCollections(): List<Collection> {
        val json = sharedPreferences.getString(COLLECTIONS_KEY, null)
        return if (json != null) {
            val type = object : TypeToken<List<Collection>>() {}.type
            gson.fromJson(json, type)
        } else {
            emptyList()
        }
    }

    fun addCollection(collection: Collection) {
        val currentList = getCollections().toMutableList()
        currentList.add(collection)
        saveCollections(currentList)
    }

    fun removeCollectionByName(name: String) {
        val filteredList = getCollections().filter { it.name != name }
        saveCollections(filteredList)
    }
}