package com.example.bakis

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.bakis.databinding.FragmentNavClutterBinding
import com.example.bakis.databinding.FragmentNavIconBinding
import com.example.bakis.model.ExpViewModel

class NavIconFragment : Fragment() {
    private var _binding: FragmentNavIconBinding? = null

    private val binding get() = _binding!!

    private val viewModel: ExpViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentNavIconBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val currQuest = viewModel.getcurrentQuestion()
        var uzdevums = ".Uzdevums"

        when(currQuest) {
            7 -> uzdevums = "1.Uzdevums"
            8 -> uzdevums = "2.Uzdevums"
            9 -> uzdevums = "3.Uzdevums"
        }

        binding.iconNiPerson.setOnClickListener {
            findNavController().navigate(R.id.action_navIconFragment_to_navEndFragment)
        }
        binding.textNiUser.setOnClickListener {
            findNavController().navigate(R.id.action_navIconFragment_to_navEndFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}