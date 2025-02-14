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
        binding.apply {
            txtCollectionName.text = collection.name
            txtCollectionDate.text = collection.creationDate
            txtCollectionDescription.text = collection.descriptionString

            if(collection.favorite){
                butonUncheked.visibility = View.VISIBLE
                butonChecked.visibility = View.GONE

            }else{
                butonUncheked.visibility = View.GONE
                butonChecked.visibility = View.VISIBLE
            }
            butonUncheked.setOnClickListener(){
                butonUncheked.visibility = View.GONE
                butonChecked.visibility = View.VISIBLE
            }

            butonChecked.setOnClickListener(){
                butonUncheked.visibility = View.VISIBLE
                butonChecked.visibility = View.GONE
            }
        }
    }
}