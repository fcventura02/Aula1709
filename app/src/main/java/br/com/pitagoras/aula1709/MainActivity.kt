package br.com.pitagoras.aula1709

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val TAG = "FGV"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        confirme.setOnClickListener {
            val altura: String = et_altura.text.toString()
            val peso: String = et_peso.text.toString()
            val idoso = check_idoso.isChecked

            if (altura.isNotEmpty()) {
                if (peso.isNotEmpty()) {
                    val intent = Intent(this, SecondView::class.java)
                    intent.putExtra("altura", altura.toDouble())
                    intent.putExtra("peso", peso.toDouble())
                    intent.putExtra("idoso", idoso)
                    startActivity(intent)
                } else {
                    Toast.makeText(
                        this,
                        "Insira um peso válido",
                        Toast.LENGTH_LONG
                    ).show()
                }
            } else {
                Toast.makeText(
                    this,
                    "Insira uma altura válida",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

        btm_clean.setOnClickListener {
            et_altura.setText("")
            et_peso.setText("")
        }

    }


}