package edu.iesam.expmdmfebrero.features.collection.presentation.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import edu.iesam.expmdmfebrero.databinding.CollectionItemBinding
import edu.iesam.expmdmfebrero.features.collection.domain.Collection

class CollectionViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private lateinit var binding : CollectionItemBinding

    fun bind(collection: Collection, onClick: ((Collection, Boolean)->Unit)? , navigate:(()->Unit)?){
        binding = CollectionItemBinding.bind(itemView)
        binding.apply {
            txtCollectionName.text = collection.name
            txtCollectionDate.text = collection.creationDate
            txtCollectionDescription.text = collection.descriptionString

            txtCollectionName.setOnClickListener{
                if (navigate != null) {
                    navigate()
                }
            }

            if(collection.favorite){
                butonUncheked.visibility = View.GONE
                butonChecked.visibility = View.VISIBLE

            }else{
                butonUncheked.visibility = View.VISIBLE
                butonChecked.visibility = View.GONE
            }
            butonUncheked.setOnClickListener(){
                butonUncheked.visibility = View.GONE
                butonChecked.visibility = View.VISIBLE
                if (onClick != null) {
                    onClick(collection, true)
                }
            }

            butonChecked.setOnClickListener(){
                butonUncheked.visibility = View.VISIBLE
                butonChecked.visibility = View.GONE
                if (onClick != null) {
                    onClick(collection, false)
                }
            }

        }
    }
}