package edu.iesam.expmdmfebrero.features.mushroom.presentation

import androidx.recyclerview.widget.DiffUtil


class MushroomDiffUtil : DiffUtil.ItemCallback<String>() {
    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }
}