package com.example.bakis

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.bakis.databinding.FragmentNavScrollBinding
import com.example.bakis.model.ExpViewModel

class NavScrollFragment : Fragment() {
    private var _binding: FragmentNavScrollBinding? = null

    private val binding get() = _binding!!

    private val viewModel: ExpViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentNavScrollBinding.inflate(inflater, container, false)

        val navObserver = Observer<Boolean> {
            if (viewModel.wasFabPressed.value == true) {
                navigateToNext()
            }
        }
        viewModel.wasFabPressed.observe(viewLifecycleOwner, navObserver)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as MainActivity?)?.showFab()


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun navigateToNext() {
        (activity as MainActivity?)?.hideFab()
        findNavController().navigate(R.id.action_navScrollFragment_to_navEndFragment)
    }
}