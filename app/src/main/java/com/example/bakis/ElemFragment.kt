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

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class ElemFragment : Fragment() {

    private var _binding: FragmentElemBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val viewModel: ExpViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentElemBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //binding.textviewSecond.text = viewModel.getQ()

        binding.buttonENext.setOnClickListener {
            getList()
            //findNavController().navigate(R.id.action_ElemFragment_to_ElemQuestionFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun getList() {
        val list = viewModel.getAnswers()

        if (list != null) {
            for (item in list) {
                Log.i("aa", "${item.withOrWithout} + ${item.answer1} + ${item.answer2} ")
            }
        }
    }
}