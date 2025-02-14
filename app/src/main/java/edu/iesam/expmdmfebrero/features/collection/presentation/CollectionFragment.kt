package edu.iesam.expmdmfebrero.features.collection.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import edu.iesam.expmdmfebrero.R
import edu.iesam.expmdmfebrero.databinding.FragmentCollectionBinding
import edu.iesam.expmdmfebrero.features.collection.data.CollectionDataRepository
import edu.iesam.expmdmfebrero.features.collection.data.LocalCollectionDataSource
import edu.iesam.expmdmfebrero.features.collection.domain.Collection
import edu.iesam.expmdmfebrero.features.collection.presentation.adapter.CollectionAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

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
        val local= LocalCollectionDataSource(requireContext())
        val defaultList = listOf(
            Collection("Setas Comestibles", "2024-01-01", "Setas seguras para el consumo.", "https://example.com/comestibles.jpg", true),
            Collection("Setas Venenosas", "2024-01-05", "Lista de setas tóxicas y peligrosas.", "https://example.com/venenosas.jpg", false),
            Collection("Hongos Medicinales", "2024-01-10", "Setas usadas en medicina tradicional.", "https://example.com/medicinales.jpg", false),
            Collection("Setas Bioluminiscentes", "2024-01-15", "Hongos que brillan en la oscuridad.", "https://example.com/bioluminiscentes.jpg", false),
            Collection("Micología General", "2024-01-20", "Guía completa sobre setas y hongos.", "https://example.com/micologia.jpg", false),
            Collection("Cultivo de Setas", "2024-01-25", "Métodos para cultivar setas en casa.", "https://example.com/cultivo.jpg", false),
            Collection("Setas en la Gastronomía", "2024-02-01", "Platos famosos con setas.", "https://example.com/gastronomia.jpg", true),
            Collection("Setas Raras", "2024-02-05", "Hongos exóticos y poco comunes.", "https://example.com/raras.jpg", false),
            Collection("Setas en la Historia", "2024-02-10", "El uso de hongos a lo largo del tiempo.", "https://example.com/historia.jpg", false),
            Collection("Setas Psicodélicas", "2024-02-15", "Hongos con propiedades alucinógenas.", "https://example.com/psicodelicas.jpg", false)
        )
        local.saveCollections(defaultList)
       // setupObserver()
        //setupBind()

    }


    fun setupObserver(){
        val observer= Observer<CollectionViewModel.UiState>{ uiState ->
            //uiState.collections?.let { setupView(it) }
        }
        viewModel.uiState.observe(viewLifecycleOwner, observer)
    }

    fun setupView(collections:List<Collection>){
        adapter.submitList(collections)
    }

    fun setupBind(){
        binding.apply {
           //list.layoutManager = LinearLayoutManager(requireContext())
          //  list.adapter = adapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}