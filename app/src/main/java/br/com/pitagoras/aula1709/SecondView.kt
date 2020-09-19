package br.com.pitagoras.aula1709

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.second_view.*

/*          Adultos
    IMC             CLASSIFICAÇÃO
<18,5               Baixo peso
18,5 a 24,9         Peso normal
25,0 a 29,9         Excesso de peso
30,0 a 34,9         Obesidade de Classe 1
35,0 a 39,9         Obesidade de Classe 2
≥ 40,0              Obesidade de Classe 3

            Idosos
    IMC             CLASSIFICAÇÃO
≤ 22                Baixo peso
> 22 e < 27         Adequado ou eutrófico
≥ 27                Sobrepeso

* */

class SecondView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_view)

        btm_back.setOnClickListener {
            finish()
        }

        val altura: Double = intent.getDoubleExtra("altura", 0.00)
        val peso: Double = intent.getDoubleExtra("peso", 0.00)
        val idoso: Boolean = intent.getBooleanExtra("idoso", false)
        val result = calImc(altura, peso)
        resultImc(result, idoso)
    }

    private fun calImc(altura: Double, peso: Double): Double {
        return peso / (altura * altura)
    }

    private fun resultImc(imc: Double, idoso: Boolean) {
        when {
            idoso -> when {
                imc <= 22 -> doctor_result.text = getString(R.string.info_doctor)
                    .plus(" %.2f".format(imc))
                    .plus(getString(R.string.complement_result) + " ")
                    .plus(getString(R.string.abaixo_peso))
                imc > 22 && imc <= 27 -> doctor_result.text = getString(R.string.info_doctor)
                    .plus(" %.2f".format(imc))
                    .plus(getString(R.string.complement_result) + " ")
                    .plus(getString(R.string.adequado_peso))
                else -> doctor_result.text = getString(R.string.info_doctor)
                    .plus(" %.2f".format(imc))
                    .plus(getString(R.string.complement_result) + " ")
                    .plus(getString(R.string.sobrepeso_peso))
            }
            imc < 18.5 -> doctor_result.text = getString(R.string.info_doctor)
                .plus(" %.2f".format(imc))
                .plus(getString(R.string.complement_result) + " ")
                .plus(getString(R.string.abaixo_peso))
            imc >= 18.5 && imc < 25 -> doctor_result.text = getString(R.string.info_doctor)
                .plus(" %.2f".format(imc))
                .plus(getString(R.string.complement_result) + " ")
                .plus(getString(R.string.adequado_peso))
            imc >= 25 && imc < 30 -> doctor_result.text = getString(R.string.info_doctor)
                .plus(" %.2f".format(imc))
                .plus(getString(R.string.complement_result) + " ")
                .plus(getString(R.string.sobrepeso_peso))
            imc >= 30 && imc < 35 -> doctor_result.text = getString(R.string.info_doctor)
                .plus(" %.2f".format(imc))
                .plus(getString(R.string.complement_result) + " ")
                .plus( getString(R.string.obesidade1))
            imc >= 35 && imc < 40 -> doctor_result.text = getString(R.string.info_doctor)
                .plus(" %.2f".format(imc))
                .plus(getString(R.string.complement_result) + " ")
                .plus( getString(R.string.obesidade2))
            imc >= 40 -> doctor_result.text = getString(R.string.info_doctor)
                .plus(" %.2f".format(imc))
                .plus(getString(R.string.complement_result) + " ")
                .plus( getString(R.string.obesidade3))

        }
    }
}