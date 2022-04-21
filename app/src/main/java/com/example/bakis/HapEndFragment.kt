package com.example.bakis

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.bakis.databinding.FragmentHapEndBinding
import com.example.bakis.databinding.FragmentNavEndBinding
import com.example.bakis.model.ExpViewModel

class HapEndFragment : Fragment() {
    private var _binding: FragmentHapEndBinding? = null

    private val binding get() = _binding!!

    private val viewModel: ExpViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHapEndBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.titleHe.text = "Uzdevums izpildīts."

        binding.buttonHe.setOnClickListener {
            findNavController().navigate(R.id.action_hapEndFragment_to_hapQuestionFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}