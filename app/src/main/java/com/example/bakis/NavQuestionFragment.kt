package com.example.bakis

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.bakis.databinding.FragmentElemQuestionBinding
import com.example.bakis.databinding.FragmentNavQuestionBinding
import com.example.bakis.model.ExpViewModel

class NavQuestionFragment : Fragment() {
    private var _binding: FragmentNavQuestionBinding? = null

    private val binding get() = _binding!!

    private val viewModel: ExpViewModel by activityViewModels()

    private var isCatChecked = false
    private var isSpecChecked = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentNavQuestionBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var text = viewModel.getcurrentQuestion().toString()
        text = "Jautājumi par $text.elementu"

        binding.textNqTitle.text = text

        //category
        binding.textNqCatq.text = resources.getText(viewModel.getQuestion(true))
        binding.radioNqCat1.text = resources.getText(viewModel.getAnswer(true, 1))
        binding.radioNqCat2.text = resources.getText(viewModel.getAnswer(true, 2))
        binding.radioNqCat3.text = resources.getText(viewModel.getAnswer(true, 3))
        binding.radioNqCat4.text = resources.getText(viewModel.getAnswer(true, 4))
        binding.radioNqCat5.text = resources.getText(viewModel.getAnswer(true, 5))

        //specific
        binding.textNqSpecq.text = resources.getText(viewModel.getQuestion(false))
        binding.radioNqSpec1.text = resources.getText(viewModel.getAnswer(false, 1))
        binding.radioNqSpec2.text = resources.getText(viewModel.getAnswer(false, 2))
        binding.radioNqSpec3.text = resources.getText(viewModel.getAnswer(false, 3))
        binding.radioNqSpec4.text = resources.getText(viewModel.getAnswer(false, 4))
        binding.radioNqSpec5.text = resources.getText(viewModel.getAnswer(false, 5))

        binding.buttonEqNext.setOnClickListener {
            onButtonClick()
        }

        binding.radioGroupNqCat.setOnCheckedChangeListener { _, _ ->
            isCatChecked = true

            binding.textNqCatWarn.visibility = View.GONE
            binding.radioGroupNqCat.background = getResources().getDrawable(R.drawable.cardview__no_background)
        }

        binding.radioGroupNqSpec.setOnCheckedChangeListener { _, _ ->
            isSpecChecked = true

            binding.textNqSpecWarn.visibility = View.GONE
            binding.radioGroupNqSpec.background = getResources().getDrawable(R.drawable.cardview__no_background)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun onButtonClick() {

        var selectedCatRadio = 0
        var selectedSpecRadio = 0
        val selectedCat = binding.radioGroupNqCat.checkedRadioButtonId
        val selectedSpec = binding.radioGroupNqSpec.checkedRadioButtonId

        if (selectedCat != -1) {
            when (selectedCat) {
                R.id.radio_eq_cat1 -> selectedCatRadio = 1
                R.id.radio_eq_cat2 -> selectedCatRadio = 2
                R.id.radio_eq_cat3 -> selectedCatRadio = 3
                R.id.radio_eq_cat4 -> selectedCatRadio = 4
                R.id.radio_eq_cat5 -> selectedCatRadio = 5
            }
        } else {
            binding.textNqCatWarn.visibility = View.VISIBLE
            binding.radioGroupNqCat.background = getResources().getDrawable(R.drawable.cardview_background)
        }

        if (selectedSpec != -1) {
            when (selectedSpec) {
                R.id.radio_eq_spec1 -> selectedSpecRadio = 1
                R.id.radio_eq_spec2 -> selectedSpecRadio = 2
                R.id.radio_eq_spec3 -> selectedSpecRadio = 3
                R.id.radio_eq_spec4 -> selectedSpecRadio = 4
                R.id.radio_eq_spec5 -> selectedSpecRadio = 5
            }
        } else {
            binding.textNqSpecWarn.visibility = View.VISIBLE
            binding.radioGroupNqSpec.background = getResources().getDrawable(R.drawable.cardview_background)
        }

        if (isCatChecked && isSpecChecked) {
            navigateToNext(selectedCatRadio, selectedSpecRadio)
        }
    }

    fun navigateToNext(cat: Int, spec: Int) {
        viewModel.setAnswers(Answer(true, cat, spec))

//        if (viewModel.getcurrentQuestion() == 7) {
//            findNavController().navigate(R.id.action_ElemQuestionFragment_to_navTaskFragment)
//        } else {
            findNavController().navigate(R.id.action_navQuestionFragment_to_navTaskFragment)
//        }
    }
}