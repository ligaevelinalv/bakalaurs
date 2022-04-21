package com.example.bakis

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.bakis.databinding.FragmentHapBinding
import com.example.bakis.databinding.FragmentHapTaskBinding

class HapFragment : Fragment() {
    private var _binding: FragmentHapBinding? = null

    private val binding get() = _binding!!

    private var counter = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHapBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val vibrator:Vibrator
        vibrator = context?.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator


        binding.buttonHSpies.setOnClickListener {
            vibrator.vibrate(100)
            if (counter == 4) {
                findNavController().navigate(R.id.action_hapFragment_to_hapEndFragment)

            } else {
                counter ++

            }
        }
    }

}