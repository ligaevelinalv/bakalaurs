package com.example.bakis

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.bakis.databinding.FragmentStartBinding
import com.example.bakis.model.ExpViewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class StartFragment : Fragment() {

    private var _binding: FragmentStartBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val viewModel: ExpViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentStartBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSNext.setOnClickListener {
            viewModel.setAnswers(generateData())
            Log.i("aa", "Data generated")
            findNavController().navigate(R.id.action_StartFragment_to_ElemFragment)
            //Log.i("aa", binding.questionbox.text.toString())
//            viewModel.setQ(binding.questionbox.text.toString())
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