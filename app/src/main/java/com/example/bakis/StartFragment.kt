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
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class StartFragment : Fragment() {

    private var _binding: FragmentStartBinding? = null

    private val binding get() = _binding!!

    private val viewModel: ExpViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentStartBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSNext.setOnClickListener {

            // Write a message to the database
            val database = Firebase.database
            val myRef = database.getReference("message")

            myRef.setValue("kms")
            findNavController().navigate(R.id.action_StartFragment_to_ElemFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}