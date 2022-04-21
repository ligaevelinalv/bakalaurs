package com.example.bakis

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.bakis.databinding.FragmentHapQuestionBinding
import com.example.bakis.databinding.FragmentNavQuestionBinding
import com.example.bakis.model.ExpViewModel

class HapQuestionFragment : Fragment() {
    private var _binding: FragmentHapQuestionBinding? = null

    private val binding get() = _binding!!

    private val viewModel: ExpViewModel by activityViewModels()

    private var isCatChecked = false
    private var isSpecChecked = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHapQuestionBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textHqTitle.text = "Jautājumi par uzdevumu"

        //category
        binding.textHqCatq.text = resources.getText(viewModel.getQuestion(true))
        binding.radioHqCat1.text = resources.getText(viewModel.getAnswer(true, 1))
        binding.radioHqCat2.text = resources.getText(viewModel.getAnswer(true, 2))
        binding.radioHqCat3.text = resources.getText(viewModel.getAnswer(true, 3))
        binding.radioHqCat4.text = resources.getText(viewModel.getAnswer(true, 4))
        binding.radioHqCat5.text = resources.getText(viewModel.getAnswer(true, 5))

        //specific
        binding.textHqSpecq.text = resources.getText(viewModel.getQuestion(false))
        binding.radioHqSpec1.text = resources.getText(viewModel.getAnswer(false, 1))
        binding.radioHqSpec2.text = resources.getText(viewModel.getAnswer(false, 2))
        binding.radioHqSpec3.text = resources.getText(viewModel.getAnswer(false, 3))
        binding.radioHqSpec4.text = resources.getText(viewModel.getAnswer(false, 4))
        binding.radioHqSpec5.text = resources.getText(viewModel.getAnswer(false, 5))

        binding.buttonHqNext.setOnClickListener {
            onButtonClick()
        }

        binding.radioGroupHqCat.setOnCheckedChangeListener { _, _ ->
            isCatChecked = true

            binding.textHqCatWarn.visibility = View.GONE
            binding.radioGroupHqCat.background =
                getResources().getDrawable(R.drawable.cardview__no_background)
        }

        binding.radioGroupHqSpec.setOnCheckedChangeListener { _, _ ->
            isSpecChecked = true

            binding.textHqSpecWarn.visibility = View.GONE
            binding.radioGroupHqSpec.background =
                getResources().getDrawable(R.drawable.cardview__no_background)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun onButtonClick() {

        var selectedCatRadio = 0
        var selectedSpecRadio = 0
        val selectedCat = binding.radioGroupHqCat.checkedRadioButtonId
        val selectedSpec = binding.radioGroupHqSpec.checkedRadioButtonId

        if (selectedCat != -1) {
            when (selectedCat) {
                R.id.radio_nq_cat1 -> selectedCatRadio = 1
                R.id.radio_nq_cat2 -> selectedCatRadio = 2
                R.id.radio_nq_cat3 -> selectedCatRadio = 3
                R.id.radio_nq_cat4 -> selectedCatRadio = 4
                R.id.radio_nq_cat5 -> selectedCatRadio = 5
            }
        } else {
            binding.textHqCatWarn.visibility = View.VISIBLE
            binding.radioGroupHqCat.background =
                getResources().getDrawable(R.drawable.cardview_background)
        }

        if (selectedSpec != -1) {
            when (selectedSpec) {
                R.id.radio_nq_spec1 -> selectedSpecRadio = 1
                R.id.radio_nq_spec2 -> selectedSpecRadio = 2
                R.id.radio_nq_spec3 -> selectedSpecRadio = 3
                R.id.radio_nq_spec4 -> selectedSpecRadio = 4
                R.id.radio_nq_spec5 -> selectedSpecRadio = 5
            }
        } else {
            binding.textHqSpecWarn.visibility = View.VISIBLE
            binding.radioGroupHqSpec.background =
                getResources().getDrawable(R.drawable.cardview_background)
        }

        if (isCatChecked && isSpecChecked) {
            navigateToNext(selectedCatRadio, selectedSpecRadio)
        }
    }

    fun navigateToNext(cat: Int, spec: Int) {
        viewModel.setAnswers(Answer(true, cat, spec))
        findNavController().navigate(R.id.action_hapQuestionFragment_to_endFragment)
    }
}