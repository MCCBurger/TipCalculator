package com.example.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import java.text.DecimalFormat
import kotlin.math.cos

class MainActivity : AppCompatActivity() {

    var costOfBill = 0.0
    var tipPercentage = 0.0
    var tipChoice = ""
    var totalTip = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tip: EditText = findViewById(R.id.billInput)
        val group: Spinner = findViewById(R.id.spnGroup)
        val calculate: Button = findViewById(R.id.btnCalculate)
        val result:TextView = findViewById(R.id.btnCalculate)

        calculate.setOnClickListener{

           costOfBill = tip.text.toString().toDouble()
            tipChoice = group.selectedItem.toString()
            tipPercentage = (tipChoice.substring(0,tipChoice.length-1).toDouble())/100
            val currency = DecimalFormat("$###,###.00")
            totalTip = costOfBill*tipPercentage
            val totalTipFormatted = currency.format(totalTip)
            val costOfBillFormatted = currency.format(costOfBill)

            result.text  = "Total tip of a $costOfBillFormatted with a $tipChoice tip is $totalTipFormatted"

        }


    }
}
