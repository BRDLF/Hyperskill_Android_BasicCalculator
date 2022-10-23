package org.hyperskill.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textBox = findViewById<EditText>(R.id.editText)
        val historyList: MutableList<String> = mutableListOf<String>()


        findViewById<Button>(R.id.clearButton).setOnClickListener {
            textBox.clearText()
            historyList.clearText()
        }
        for (butID in listOf(R.id.button0, R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6,
            R.id.button7, R.id.button8, R.id.button9, R.id.dotButton)) {
            val b = findViewById<Button>(butID)
            b.setOnClickListener {
                textBox.send(b.text)
            }
        }

        for (butID in listOf(R.id.subtractButton, R.id.addButton, R.id.divideButton, R.id.multiplyButton)) {
            val b = findViewById<Button>(butID)
            b.setOnClickListener { historyList.operation(textBox, b.text.toString()) }
        }

        findViewById<Button>(R.id.equalButton).setOnClickListener { textBox.solve(historyList) }

    }

    private fun EditText.solve(history: MutableList<String>) {
        if (history.isEmpty()) return
        val op1 = history.first().toDouble()
        val op2 = this.text.toString().toDouble()
        val res = when (history[1]) {
            "+" -> op1 + op2
            "-" -> op1 - op2
            "x" -> op1 * op2
            "/" -> if (op2 == 0.0) Double.MAX_VALUE else op1 / op2
            else -> null
        } ?: return
        this.text.clear()
        this.text.append(res.toString())
        history.clear()
    }

    private fun String.cleanDecimal(): String = this.dropLastWhile { it == '0' }.dropLastWhile { it == '.' }

    private fun EditText.send(key: CharSequence) {
        when (key.first()) {
            '.' -> {
                if( this.text.toString() == "-") this.text.append("0.")
                if( !this.text.contains('.')) this.text.append(key)
            }
            else -> if( "-0".toRegex().matches(this.text.toString()) ) {
                this.text.replace(1, 2, key)
            } else if ( this.text.toString() == "0") {
                this.text.replace(0, 1, key)
            } else this.text.append(key)
        }
    }
    private fun MutableList<String>.clearText() = this.clear()
    private fun EditText.clearText() = this.text.replace(0, this.text.length, "0")

    private fun MutableList<String>.operation(operand: EditText, operator: String) {
        if (operator == "-" && operand.text.toString() == "0") operand.text.replace(0, 1, "-") // if input empty, pressing - to make negative
        operand.text.toString().toDoubleOrNull()?: return // if we don't have a number in the input, do nothing
        if (this.isNotEmpty() && "[-+x/]".toRegex().matches(this.last())) {
            operand.solve(this)
        }
        this.add(operand.text.toString())
        this.add(operator)
        operand.text.clear()
        operand.text.append("0")
    }
}