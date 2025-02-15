package edu.iesam.expmdmfebrero.features.collection.data

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import edu.iesam.expmdmfebrero.features.collection.domain.Collection


class LocalCollectionDataSource(context: Context) {
    private val sharedPreferences = context.getSharedPreferences("collection_prefs", Context.MODE_PRIVATE)
    private val gson = Gson()

    var count = 0
    companion object {
        private const val COLLECTIONS_KEY = "collections_list"
    }

    fun saveCollections(collections: List<Collection>) {
        val json = gson.toJson(collections)
        sharedPreferences.edit().putString(COLLECTIONS_KEY, json).apply()
    }

    fun getCollections(): List<Collection> {

        if (count == 0){
            val defaultList = listOf(
                Collection("Setas Comestibles", "2024-01-01", "Setas seguras para el consumo.", "https://example.com/comestibles.jpg", false),
                Collection("Setas Venenosas", "2024-01-05", "Lista de setas tóxicas y peligrosas.", "https://example.com/venenosas.jpg", false),
                Collection("Hongos Medicinales", "2024-01-10", "Setas usadas en medicina tradicional.", "https://example.com/medicinales.jpg", false),
                Collection("Setas Bioluminiscentes", "2024-01-15", "Hongos que brillan en la oscuridad.", "https://example.com/bioluminiscentes.jpg", false),
                Collection("Micología General", "2024-01-20", "Guía completa sobre setas y hongos.", "https://example.com/micologia.jpg", false),
                Collection("Cultivo de Setas", "2024-01-25", "Métodos para cultivar setas en casa.", "https://example.com/cultivo.jpg", false),
                Collection("Setas en la Gastronomía", "2024-02-01", "Platos famosos con setas.", "https://example.com/gastronomia.jpg", false),
                Collection("Setas Raras", "2024-02-05", "Hongos exóticos y poco comunes.", "https://example.com/raras.jpg", false),
                Collection("Setas en la Historia", "2024-02-10", "El uso de hongos a lo largo del tiempo.", "https://example.com/historia.jpg", false),
                Collection("Setas Psicodélicas", "2024-02-15", "Hongos con propiedades alucinógenas.", "https://example.com/psicodelicas.jpg", false)
            )
            saveCollections(defaultList)
            count = 1
        }
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