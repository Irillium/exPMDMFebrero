package edu.iesam.expmdmfebrero.features.collection.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import edu.iesam.expmdmfebrero.R
import edu.iesam.expmdmfebrero.features.collection.domain.Collection

class CollectionAdapter : ListAdapter<Collection, CollectionViewHolder>(CollectionDiffCallback) {

     var onClick: ((Collection, Boolean) -> Unit)? = null
    var navigate: (() -> Unit)? = null



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollectionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.collection_item, parent, false)
        return CollectionViewHolder(view)
    }

    override fun onBindViewHolder(holder: CollectionViewHolder, position: Int) {
        holder.bind(getItem(position),onClick, navigate)
    }
}