package edu.iesam.expmdmfebrero.features.collection.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import edu.iesam.expmdmfebrero.databinding.CollectionItemBinding
import edu.iesam.expmdmfebrero.features.collection.domain.Collection

class CollectionViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private lateinit var binding : CollectionItemBinding

    fun bind(collection: Collection) {
        binding = CollectionItemBinding.bind(itemView)

    }
}