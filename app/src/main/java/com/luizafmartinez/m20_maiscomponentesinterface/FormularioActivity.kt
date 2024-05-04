package com.luizafmartinez.m20_maiscomponentesinterface

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
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

        spinnerExibicao()

        with(binding) {
            btnEnviar.setOnClickListener { view ->
                //checkbox()
                //radioButton()
                //switchToggle()
                //exibirSnackBar(view)
                //caixaDialogoAlerta()
                spinnerSelecionarItem()

                /*Snackbar.make(
                    view,
                    "Alteração feita com Sucesso",
                    Snackbar.LENGTH_LONG
                ).show()*/
            }

            /*
            toggleAtivo.setOnClickListener {

            }
            toggleAtivo.setOnCheckedChangeListener { buttonView, isChecked ->

            }
            */

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

    private fun spinnerSelecionarItem() {

        val itemSelecionado = binding.spinnerCategorias.selectedItem
        val itemPosicao = binding.spinnerCategorias.selectedItemPosition

        if (itemPosicao == 0) {
            binding.textResultado.text = "Selecione um item"
        } else {
            binding.textResultado.text = "Selecionado: $itemSelecionado, posição: $itemPosicao"
        }

        //binding.textResultado.text = "Selecionado: $itemSelecionado, posição: $itemPosicao"
    }

    private fun spinnerExibicao() {

       /* val categorias = listOf(
            "Selecione uma categoria",
            "Eletrônicos",
            "Roupas",
            "Móveis",
            "Sapatos"
        )*/

        /*val categorias = resources.getStringArray(R.array.categorias)

        binding.spinnerCategorias.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            categorias
        )*/

        binding.spinnerCategorias.adapter = ArrayAdapter.createFromResource(
            this,
            R.array.categorias,
            android.R.layout.simple_spinner_dropdown_item
        )

        binding.spinnerCategorias.onItemSelectedListener = object : OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                // val itemSelecionado = parent?.getItemAtPosition(position)
                val itemSelecionado = parent?.selectedItem
                binding.textResultado.text = itemSelecionado.toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }
    }

    private fun caixaDialogoAlerta() {

        AlertDialog.Builder(this)

            .setTitle("Confirmar exclusão do item ?")
            .setMessage("Tem certeza que quer remover ?")
            .setNegativeButton("CANCELAR") { dialog, posicao ->
                //dialog.dismiss()
                Toast.makeText(
                    this,
                    "Cancelar clicado",
                    Toast.LENGTH_LONG
                ).show()
            }
            .setPositiveButton("REMOVER") { dialog, posicao ->
                Toast.makeText(
                    this,
                    "Remover", Toast.LENGTH_SHORT
                ).show()
            }
            .setCancelable(false)
            .setNeutralButton("Ajuda") { dialog, posicao ->
                Toast.makeText(
                    this,
                    "Ajuda", Toast.LENGTH_SHORT
                ).show()
            }
            .setIcon(R.drawable.ic_alerta_24)
            .create()
            .show()

        // Usa 2classes - Builder e AlertDialog
        /*val alertBuilder = AlertDialog.Builder(this)

        alertBuilder.setTitle("Confirmar exclusão do item ?")

        alertBuilder.setMessage("Tem certeza que quer remover ?")

        alertBuilder.setNegativeButton("CANCELAR") { dialog, posicao ->
            //dialog.dismiss()
            Toast.makeText(
                this,
                "Cancelar clicado",
                Toast.LENGTH_LONG
            ).show()
        }

        alertBuilder.setPositiveButton("REMOVER") { dialog, posicao ->
            Toast.makeText(
                this,
                "Remover", Toast.LENGTH_SHORT
            ).show()
        }

        alertBuilder.setCancelable(false)

        alertBuilder.setNeutralButton("Ajuda") { dialog, posicao ->
            Toast.makeText(
                this,
                "Ajuda", Toast.LENGTH_SHORT
            ).show()
        }

        alertBuilder.setIcon(R.drawable.ic_alerta_24)

        val alertDialog = alertBuilder.create()
        alertDialog.show()*/

    }

    private fun exibirSnackBar(view: View) {

        val snackBar = Snackbar.make(
            view,
            "Alteração feita com Sucesso",
            Snackbar.LENGTH_LONG
        )

        snackBar.setAction("Confirmar") {
            Toast.makeText(this, "DESFAZER", Toast.LENGTH_LONG).show()
        }

        /*
        snackBar.setTextColor(
            //resources.getColor(R.color.purple_200) DEPRECATED
            ContextCompat.getColor(this,R.color.deep_purple)
            //android.R.color.holo_orange_dark
        )

        snackBar.setActionTextColor(
            ContextCompat.getColor(
            this,
            R.color.deep_orange)
        )

        snackBar.setBackgroundTint(
            ContextCompat.getColor(
            this,
            R.color.gray_green)
        )
        */

        snackBar.show()
    }

    /*private fun exibirSnackBar(view: View) {

            val snackBar = Snacbar.make(
                view,
                "Alteração feita com Sucesso",
                Snackbar.LENGTH_LONG
            ).show()
        }*/
    private fun switchToggle() {
        val switchMarcado = binding.switchNotificacoes.isChecked
        val toggleMarcado = binding.toggleAtivo.isChecked

        val texto = "Switch: $switchMarcado toggle: $toggleMarcado"
        binding.textResultado.text = texto
    }

    private fun radioButton() {
        val masculino = binding.rbMasculino.isChecked
        //binding.textResultado.text = if (masculino) "Masculino" else "Feminino"

        val idItemSelecionado = binding.rgSexo.checkedRadioButtonId
        binding.textResultado.text = when (idItemSelecionado) {
            R.id.rbMasculino -> "Masculino"
            R.id.rbFeminino -> "Feminino"
            else -> "Nada selecionado"
        }

        binding.rgSexo.clearCheck()
    }

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
