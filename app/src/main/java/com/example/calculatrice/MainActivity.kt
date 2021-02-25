package com.example.calculatrice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    var isNewOperation = true
    fun buNumberEvent(view: View)
    {
        var tvNumber: TextView = findViewById<TextView>(R.id.tvShowNumber)
        var acButton:Button = findViewById<Button>(R.id.buAC)
        var pdmButton:Button = findViewById<Button>(R.id.buPDM)
        var moduloButton:Button = findViewById<Button>(R.id.buModulo)

        var divButton:Button = findViewById<Button>(R.id.buDivide)
        var sevenButton:Button = findViewById<Button>(R.id.bu7)
        var eightButton:Button = findViewById<Button>(R.id.bu8)
        var nineButton:Button = findViewById<Button>(R.id.bu9)

        var multiButton:Button = findViewById<Button>(R.id.buMult)
        var fourButton:Button = findViewById<Button>(R.id.bu4)
        var fiveButton:Button = findViewById<Button>(R.id.bu5)
        var sixButton:Button = findViewById<Button>(R.id.bu6)

        var minusButton:Button = findViewById<Button>(R.id.buMinus)
        var oneButton:Button = findViewById<Button>(R.id.bu1)
        var twoButton:Button = findViewById<Button>(R.id.bu2)
        var threeButton:Button = findViewById<Button>(R.id.bu3)

        var plusButton:Button = findViewById<Button>(R.id.buPlus)
        var zeroButton:Button = findViewById<Button>(R.id.bu0)
        var dotButton:Button = findViewById<Button>(R.id.buDot)
        var equalButton:Button = findViewById<Button>(R.id.buEqual)

        var tvNumberToString : String = tvNumber.text.toString()
        var buSelect = view as Button



        if(isNewOperation)
        {
            tvNumberToString = ""
        }
        isNewOperation = false

        when(buSelect.id)
        {
            zeroButton.id->{
                tvNumberToString += "0"
            }

            oneButton.id->{
                tvNumberToString += "1"
            }
            twoButton.id->{
                tvNumberToString += "2"
            }
            threeButton.id->{
                tvNumberToString += "3"
            }
            fourButton.id->{
                tvNumberToString += "4"
            }
            fiveButton.id->{
                tvNumberToString += "5"
            }
            sixButton.id->{
                tvNumberToString += "6"
            }
            sevenButton.id->{
                tvNumberToString += "7"
            }
            eightButton.id->{
                tvNumberToString += "8"
            }
            nineButton.id->{
                tvNumberToString += "9"
            }

            pdmButton.id->{
                tvNumberToString = "-" +tvNumberToString
            }

            moduloButton.id->{
                tvNumberToString += ""
            }

            dotButton.id->{
                tvNumberToString += "."
            }
        }
        tvNumber.text = tvNumberToString

    }

    var lastNumber = ""
    var operation = "+"
    fun buOpEvent(view:View)
    {
        var tvNumber: TextView = findViewById<TextView>(R.id.tvShowNumber)
        var moduloButton:Button = findViewById<Button>(R.id.buModulo)
        var divButton:Button = findViewById<Button>(R.id.buDivide)
        var multiButton:Button = findViewById<Button>(R.id.buMult)
        var minusButton:Button = findViewById<Button>(R.id.buMinus)
        var plusButton:Button = findViewById<Button>(R.id.buPlus)

        lastNumber = tvNumber.text.toString()

        var buSelect = view as Button
        isNewOperation = true
        when(buSelect.id)
        {
            moduloButton.id->
            {
                operation = "%"
            }
            divButton.id->
            {
                operation = "/"
            }
            multiButton.id->
            {
                operation = "*"
            }
            minusButton.id->
            {
                operation = "-"
            }
            plusButton.id->
            {
                operation = "+"
            }
        }
    }

    fun buEqualEvent(view: View)
    {
        var tvNumber: TextView = findViewById<TextView>(R.id.tvShowNumber)
        var equalButton:Button = findViewById<Button>(R.id.buEqual)
        val newNumber = tvNumber.text.toString()
        var finalNumber:Double? = null

        when(operation)
        {
            "%"->{
                finalNumber = lastNumber.toDouble() % newNumber.toDouble()
            }

            "/"->{
                finalNumber = lastNumber.toDouble() / newNumber.toDouble()
            }

            "*"->{
                finalNumber = lastNumber.toDouble() * newNumber.toDouble()
            }

            "-"->{
                finalNumber = lastNumber.toDouble() - newNumber.toDouble()
            }

            "+"->{
                finalNumber = lastNumber.toDouble() + newNumber.toDouble()
            }
        }
        tvNumber.text = finalNumber.toString()
        isNewOperation = true
    }

    fun buClear(view:View)
    {
        isNewOperation = true
        var tvNumber: TextView = findViewById<TextView>(R.id.tvShowNumber)
        tvNumber.text = "0"
    }
}