package edu.iesam.expmdmfebrero.features.collection.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import edu.iesam.expmdmfebrero.R
import edu.iesam.expmdmfebrero.databinding.FragmentCollectionBinding
import edu.iesam.expmdmfebrero.features.collection.data.LocalCollectionDataSource
import edu.iesam.expmdmfebrero.features.collection.domain.Collection
import edu.iesam.expmdmfebrero.features.collection.presentation.adapter.CollectionAdapter

class CollectionFragment : Fragment() {

    private var _binding: FragmentCollectionBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: CollectionViewModel
    private lateinit var factory: CollectionFactory

    private lateinit var adapter:CollectionAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCollectionBinding.inflate(inflater, container, false)
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        factory = CollectionFactory(requireContext())
        viewModel = factory.buildViewModel()
        adapter = CollectionAdapter()
        setupObserver()
        setupBind()

        viewModel.loadCollections()



    }


    fun setupObserver(){
        val observer= Observer<CollectionViewModel.UiState>{ uiState ->
            uiState.collections?.let { setupView(it) }
        }
        viewModel.uiState.observe(viewLifecycleOwner, observer)
    }

    fun setupView(collections:List<Collection>){
        adapter.submitList(collections)
    }

    fun setupBind(){
        binding.apply {
            butonUncheked.setOnClickListener(){
                butonUncheked.visibility = View.GONE
                butonChecked.visibility = View.VISIBLE
                viewModel.loadCollections()
            }

            butonChecked.setOnClickListener(){
                butonUncheked.visibility = View.VISIBLE
                butonChecked.visibility = View.GONE
                viewModel.loadFavoritesCollections()

            }
           list.layoutManager = LinearLayoutManager(requireContext())
           list.adapter = adapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}