package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_calculator.*


class CalculatorActivity : AppCompatActivity(), View.OnClickListener {
    private var variableOne = 0.0
    private var variableSecond = 0.0
    private var operation = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        init()
    }

    private fun init() {
        button0.setOnClickListener(this)
        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)
        dotButton.setOnClickListener {
            if (resultTV.text.isNotEmpty() && "." !in resultTV.text.toString()) {
                resultTV.text = resultTV.text.toString() + "."
            }
        }
        deleteButton.setOnLongClickListener {
            if (resultTV.text.isNotEmpty())
                resultTV.text = ""
            true
        }

    }

    fun equal(view: View) {
        val value: String = resultTV.text.toString()
        if (value.isNotEmpty()) {
            variableSecond = value.toDouble()
            operation()
        }
    }

    private fun operation() {
        var result = 0.0
        if (operation == ":" && variableSecond == 0.0) {
            Toast.makeText(this, "Can't divide by Zero !", Toast.LENGTH_SHORT).show()
            resultTV.text = ""
        } else if (operation == ":") {
            result = variableOne / variableSecond
            resultTV.text = result.toString()
        } else if (operation == "+") {
            result = variableOne + variableSecond
            resultTV.text = result.toString()
        } else if (operation == "x") {
            result = variableOne * variableSecond
            resultTV.text = result.toString()
        } else if (operation == "-") {
            result = variableOne - variableSecond
            resultTV.text = result.toString()
        }
    }

    fun plus(view: View) {
        val value: String = resultTV.text.toString()
        if (value.isNotEmpty()) {
            variableOne = value.toDouble()
            operation = "+"
            resultTV.text = ""
        }
    }

    fun minus(view: View) {
        val value: String = resultTV.text.toString()
        if (value.isNotEmpty()) {
            variableOne = value.toDouble()
            operation = "-"
            resultTV.text = ""
        }
    }


    fun multiply(view: View) {
        val value: String = resultTV.text.toString()
        if (value.isNotEmpty()) {
            variableOne = value.toDouble()
            operation = "x"
            resultTV.text = ""
        }
    }

    fun divide(view: View) {
        val value: String = resultTV.text.toString()
        if (value.isNotEmpty()) {
            variableOne = value.toDouble()
            operation = ":"
            resultTV.text = ""
        }
    }

    fun delete(view: View) {
        val value: String = resultTV.text.toString()
        if (value.isNotEmpty()) {
            resultTV.text = value.substring(0, value.length - 1)
        }
    }

    override fun onClick(v: View?) {
        val button: Button = v as Button
        resultTV.text = resultTV.text.toString() + button.text.toString()
    }

}

