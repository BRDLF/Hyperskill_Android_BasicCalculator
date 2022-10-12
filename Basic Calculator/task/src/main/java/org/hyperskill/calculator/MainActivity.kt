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

        findViewById<Button>(R.id.clearButton).setOnClickListener { textBox.clearText() }
        for (butID in listOf(R.id.button0, R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6,
            R.id.button7, R.id.button8, R.id.button9, R.id.dotButton)) {
            val b = findViewById<Button>(butID)
            b.setOnClickListener {
                textBox.send(b.text)
            }
        }
    }

    private fun EditText.send(key: CharSequence) {
        when (key.first()) {
            '.' -> if( !this.text.contains('.')) this.text.append(key)
            else -> if( this.text.toString() == "0" ) this.text.replace(0, 1, key) else this.text.append(key)
        }
    }

    private fun EditText.clearText() = this.text.replace(0, this.text.length, "0")
}