package com.luizafmartinez.m20_maiscomponentesinterface

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.luizafmartinez.m20_maiscomponentesinterface.databinding.ActivityFormularioBinding

class FormularioActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityFormularioBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        with ( binding ) {

            btnEnviar.setOnClickListener {
                //checkbox()
                radioButton()
            }
            
           /*
            rbMasculino.setOnClickListener {
                
            }
            rbMasculino.setOnCheckedChangeListener { buttonView, isChecked ->

            }
            */

            /*
            cbConfirmacao.setOnCheckedChangeListener { _, isChecked ->
                val resultado = if ( isChecked ) "SIM" else "NÃO"
                binding.textResultado.text = "Valor selecionado: $resultado"
            }
            */

            /*
            cbConfirmacao.setOnClickListener {
                val selecionado = cbConfirmacao.isChecked
                val resultado = if ( selecionado ) "SIM" else "NÃO"
                binding.textResultado.text = "Valor selecionado: $resultado"
            }
            */
        }
    }

    private fun radioButton() {
        val masculino = binding.rbMasculino.isChecked
        //binding.textResultado.text = if (masculino) "Masculino" else "Feminino"

        val idItemSelecionado = binding.rgSexo.checkedRadioButtonId
        binding.textResultado.text = when( idItemSelecionado ) {
            R.id.rbMasculino -> "Masculino"
            R.id.rbFeminino -> "Feminino"
            else -> "Nada selecionado"
        }

        binding.rgSexo.clearCheck()



    }



   /*
    private fun radioButton() {
        val selecionadoMasculino = binding.rbMasculino.isChecked
        if ( selecionadoMasculino ) {
            //
        } else {
           //
        }
    }
    */

    //private fun checkbox() {
}