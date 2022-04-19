package com.example.bakis

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.bakis.databinding.FragmentElemBinding
import com.example.bakis.databinding.FragmentNavTaskBinding
import com.example.bakis.model.ExpViewModel

class NavTaskFragment : Fragment() {
    private var _binding: FragmentNavTaskBinding? = null

    private val binding get() = _binding!!

    private val viewModel: ExpViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentNavTaskBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val currQuest = viewModel.getcurrentQuestion()
        when(currQuest) {
            7 ->
            {
                binding.titleNt.text = "1.Uzdevums"
                binding.textNt.text = resources.getText(R.string.nav_uzd_1)
            }

            8 ->
            {
                binding.titleNt.text = "2.Uzdevums"
                binding.textNt.text = resources.getText(R.string.nav_uzd_2)
            }
            9 ->
            {
                binding.titleNt.text = "3.Uzdevums"
                binding.textNt.text = resources.getText(R.string.nav_uzd_3)
            }
        }

        binding.buttonNtNext.setOnClickListener {
            findNavController().navigate(R.id.action_navTaskFragment_to_navClutterFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}