package com.luizafmartinez.m20_maiscomponentesinterface

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.luizafmartinez.m20_maiscomponentesinterface.databinding.ActivityMainBinding
import com.luizafmartinez.m20_maiscomponentesinterface.databinding.ActivityNovaBinding

class NovaActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityNovaBinding.inflate( layoutInflater )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView( binding.root )

        inicializarToolbar()
    }

    private fun inicializarToolbar() {
        binding.includeToolbar.clLogo.visibility = View.GONE
        binding.includeToolbar.tbPrincipal.title = "Upload de Vídeo"
        setSupportActionBar( binding.includeToolbar.tbPrincipal )


    }


}