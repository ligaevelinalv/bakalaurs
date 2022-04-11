package com.example.bakis

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.bakis.R.color.warning
import com.example.bakis.databinding.FragmentElemQuestionBinding
import com.example.bakis.model.ExpViewModel


class ElemQuestionFragment : Fragment() {

    private var _binding: FragmentElemQuestionBinding? = null

    private val binding get() = _binding!!

    private val viewModel: ExpViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentElemQuestionBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var text = viewModel.getcurrentQuestion().toString()
        text = "Jautājumi par $text.elementu"

        binding.textEqTitle.text = text

        //category
        binding.textEqCatq.text = resources.getText(viewModel.getQuestion(true))
        binding.radioEqCat1.text = resources.getText(viewModel.getAnswer(true, 1))
        binding.radioEqCat2.text = resources.getText(viewModel.getAnswer(true, 2))
        binding.radioEqCat3.text = resources.getText(viewModel.getAnswer(true, 3))
        binding.radioEqCat4.text = resources.getText(viewModel.getAnswer(true, 4))
        binding.radioEqCat5.text = resources.getText(viewModel.getAnswer(true, 5))

        //specific
        binding.textEqSpecq.text = resources.getText(viewModel.getQuestion(false))
        binding.radioEqSpec1.text = resources.getText(viewModel.getAnswer(false, 1))
        binding.radioEqSpec2.text = resources.getText(viewModel.getAnswer(false, 2))
        binding.radioEqSpec3.text = resources.getText(viewModel.getAnswer(false, 3))
        binding.radioEqSpec4.text = resources.getText(viewModel.getAnswer(false, 4))
        binding.radioEqSpec5.text = resources.getText(viewModel.getAnswer(false, 5))

        binding.buttonEqNext.setOnClickListener {
            onButtonClick()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun onButtonClick() {

        var selectedCatRadio = 0
        var selectedSpecRadio = 0
        val selectedCat = binding.radioGroupEqCat.checkedRadioButtonId
        val selectedSpec = binding.radioGroupEqSpec.checkedRadioButtonId

        if (selectedCat!= -1) {
            when (selectedCat) {
                R.id.radio_eq_cat1 -> selectedCatRadio = 1
                R.id.radio_eq_cat2 -> selectedCatRadio = 2
                R.id.radio_eq_cat3 -> selectedCatRadio = 3
                R.id.radio_eq_cat4 -> selectedCatRadio = 4
                R.id.radio_eq_cat5 -> selectedCatRadio = 5
            }
        }

        if (binding.textEqCatWarn.visibility == View.INVISIBLE) {
        binding.cardViewEqCat.setBackgroundColor(resources.getColor(warning))
        binding.textEqCatWarn.text = "Lūdzu izvēlieties atbilžu variantu!"
        binding.textEqCatWarn.visibility = View.VISIBLE
        } else {
            binding.cardViewEqCat.setBackgroundColor(resources.getColor(R.color.white))
            binding.textEqCatWarn.visibility = View.INVISIBLE
        }

        if (selectedSpec!= -1) {
            when (selectedSpec) {
                R.id.radio_eq_spec1 ->  selectedSpecRadio = 1
                R.id.radio_eq_spec2 ->  selectedSpecRadio = 2
                R.id.radio_eq_spec3 ->  selectedSpecRadio = 3
                R.id.radio_eq_spec4 ->  selectedSpecRadio = 4
                R.id.radio_eq_spec5 ->  selectedSpecRadio = 5
            }

            viewModel.setAnswers(Answer(true, selectedCatRadio, selectedSpecRadio))
            findNavController().navigate(R.id.action_ElemQuestionFragment_to_ElemFragment)

        }

        if (binding.textEqSpecWarn.visibility == View.INVISIBLE) {
            binding.cardViewEqSpec.setBackgroundColor(resources.getColor(warning))
            binding.textEqSpecWarn.text = "Lūdzu izvēlieties atbilžu variantu!"
            binding.textEqSpecWarn.visibility = View.VISIBLE
        } else {
            binding.cardViewEqSpec.setBackgroundColor(resources.getColor(R.color.white))
            binding.textEqSpecWarn.visibility = View.INVISIBLE
        }
    }
}