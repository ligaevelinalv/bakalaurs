package com.example.bakis

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.bakis.databinding.FragmentNavClutterBinding
import com.example.bakis.databinding.FragmentNavEndBinding
import com.example.bakis.model.ExpViewModel

class NavEndFragment : Fragment() {
    private var _binding: FragmentNavEndBinding? = null

    private val binding get() = _binding!!

    private val viewModel: ExpViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentNavEndBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.titleNe.text = "Uzdevums pabeigts."

        binding.buttonNe.setOnClickListener {
            findNavController().navigate(R.id.action_navEndFragment_to_navQuestionFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}