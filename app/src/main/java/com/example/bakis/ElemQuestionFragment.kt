package com.example.bakis

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.bakis.databinding.FragmentElemQuestionBinding
import com.example.bakis.model.ExpViewModel


class ElemQuestionFragment : Fragment() {

    private var _binding: FragmentElemQuestionBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val viewModel: ExpViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentElemQuestionBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var text = viewModel.getcurrentQuestion().toString()
        text = "Jautājumi par $text.elementu"
        binding.textEqTitle.text = text

        binding.buttonEqNext.setOnClickListener {
            viewModel.setAnswers(generateData())
            findNavController().navigate(R.id.action_ElemQuestionFragment_to_ElemFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

        fun generateData(): MutableList<Answer> {
        val answer1 = Answer(true, 2, 3 )
        val list = mutableListOf<Answer>(answer1)

        return list
    }
}