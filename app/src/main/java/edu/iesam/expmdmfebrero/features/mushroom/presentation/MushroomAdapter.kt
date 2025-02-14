package edu.iesam.expmdmfebrero.features.mushroom.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import edu.iesam.expmdmfebrero.R


class MushroomAdapter: ListAdapter<String, MushroomViewHolder>(MushroomDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MushroomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.mushroom_item, parent, false)
        return MushroomViewHolder(view)
    }

    override fun onBindViewHolder(holder: MushroomViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}