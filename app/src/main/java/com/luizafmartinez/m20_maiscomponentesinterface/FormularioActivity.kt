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
            }

            cbConfirmacao.setOnCheckedChangeListener { _, isChecked ->
                val resultado = if ( isChecked ) "SIM" else "NÃO"
                binding.textResultado.text = "Valor selecionado: $resultado"
            }

            /*
            cbConfirmacao.setOnClickListener {
                val selecionado = cbConfirmacao.isChecked
                val resultado = if ( selecionado ) "SIM" else "NÃO"
                binding.textResultado.text = "Valor selecionado: $resultado"
            }
            */
        }

    }

    //private fun checkbox() {




}











