package edu.iesam.expmdmfebrero.features.collection.domain

data class Collection(
    val name:String,
    val creationDate:String,
    val descriptionString: String,
    val image:String,
    val favorite:Boolean)
