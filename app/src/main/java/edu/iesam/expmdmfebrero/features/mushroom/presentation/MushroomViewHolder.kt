package edu.iesam.expmdmfebrero.features.mushroom.presentation

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import edu.iesam.expmdmfebrero.databinding.CollectionItemBinding
import edu.iesam.expmdmfebrero.databinding.MushroomItemBinding

class MushroomViewHolder (view: View) : RecyclerView.ViewHolder(view) {

    private lateinit var binding : MushroomItemBinding

    fun bind(name:String ){
        binding = MushroomItemBinding.bind(itemView)
        binding.textViewMushroomName.text = name
    }
}
