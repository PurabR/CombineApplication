package com.example.combineapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.combineapplication.databinding.CalculatorFragmentBinding
import java.text.DecimalFormat

class FragmentCalculator: Fragment() {


    private lateinit var binding: CalculatorFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = CalculatorFragmentBinding.inflate(layoutInflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var i = 0



        binding.btnPlus.setOnClickListener {
            //Runs when + btn is clicked
            calculate("+")
        }

        binding.btnMinus.setOnClickListener {
            //Runs when - btn is clicked
            calculate("-")
        }

        binding.btnMultiplication.setOnClickListener {
            //Runs when * btn is clicked
            calculate("*")
        }

        binding.btnDivide.setOnClickListener {
            //Runs when / btn is clicked
            calculate("/")
        }

    }

    private fun showMsg(value: String) {
        Toast.makeText(
            requireContext(),
            value,
            Toast.LENGTH_SHORT
        ).show()
    }

    private fun calculate(sign: String) {
        val n1 = binding.et1.text.toString().toFloatOrNull()
        val n2 = binding.et2.text.toString().toFloatOrNull()

        if (n1 == null || n2 == null) {
            showMsg("Please enter a valid number")
            return
        }

        if (n2 == 0f && sign == "/") {
            showMsg("Can't divide with 0")
            return
        }


        val formatter = DecimalFormat("#.##")
        val result = when (sign) {
            "+" -> n1 + n2
            "-" -> n1 - n2
            "*" -> n1 * n2
            "/" -> n1 / n2
            else -> 0
        }
        binding.tv.text = formatter.format(result)

    }



}