package com.example.bakis

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.bakis.databinding.FragmentElemBinding
import com.example.bakis.model.ExpViewModel

class ElemFragment : Fragment() {

    private var _binding: FragmentElemBinding? = null

    private val binding get() = _binding!!

    private val viewModel: ExpViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentElemBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var text = viewModel.getcurrentQuestion().toString()
        text = "$text.elements"
        binding.textETitle.text = text

        when (viewModel.getcurrentQuestion()) {
            1 -> binding.cardViewElem1.visibility = View.VISIBLE
            2 -> binding.cardViewElem2.visibility = View.VISIBLE
            3 -> binding.cardViewElem3.visibility = View.VISIBLE
        }

        binding.buttonENext.setOnClickListener {

            findNavController().navigate(R.id.action_ElemFragment_to_ElemQuestionFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}