package edu.iesam.expmdmfebrero.features.mushroom.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import edu.iesam.expmdmfebrero.R
import edu.iesam.expmdmfebrero.databinding.FragmentCollectionBinding
import edu.iesam.expmdmfebrero.databinding.FragmentMushroomBinding


class MushroomFragment : Fragment() {

    private var _binding: FragmentMushroomBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: MushroomAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMushroomBinding.inflate(inflater, container, false)
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = MushroomAdapter()
    }

    fun bind(){
        binding.apply {
            list.layoutManager = LinearLayoutManager(requireContext())
            list.adapter = adapter
        }

        val mushroomNames = listOf(
            "Amanita muscaria",
            "Boletus edulis",
            "Cantharellus cibarius",
            "Agaricus bisporus",
            "Clitocybe nebularis",
            "Russula emetica",
            "Coprinus comatus",
            "Morchella esculenta",
            "Lactarius deliciosus",
            "Armillaria mellea",
            "Paxillus involutus",
            "Grifola frondosa",
            "Pleurotus ostreatus",
            "Hypholoma fasciculare",
            "Gyromitra esculenta",
            "Inonotus obliquus",
            "Cortinarius violaceus",
            "Laetiporus sulphureus",
            "Boletus badius",
            "Scleroderma citrinum"
        )
        adapter.submitList(mushroomNames)
    }
}