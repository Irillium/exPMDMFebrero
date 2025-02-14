package edu.iesam.expmdmfebrero.features.collection.presentation.adapter
import edu.iesam.expmdmfebrero.features.collection.domain.Collection
import androidx.recyclerview.widget.DiffUtil

object CollectionDiffCallback : DiffUtil.ItemCallback<Collection>() {
    override fun areItemsTheSame(oldItem: Collection, newItem: Collection): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Collection, newItem: Collection): Boolean {
        return oldItem == newItem
    }
}