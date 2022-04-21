package com.example.bakis

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.bakis.databinding.FragmentHapTaskBinding
import com.example.bakis.databinding.FragmentNavTaskBinding
import com.example.bakis.model.ExpViewModel

class HapTaskFragment : Fragment() {
    private var _binding: FragmentHapTaskBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHapTaskBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.titleH.text = getString(R.string.uzdevums)
        binding.textH.text = "Nospiediet pogu ar uzrakstu \"Spiest\" piecas reizes."

        binding.buttonHNext.setOnClickListener {
            findNavController().navigate(R.id.action_hapTaskFragment_to_hapFragment)
        }
    }
}