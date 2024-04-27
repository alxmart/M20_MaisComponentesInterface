package com.luizafmartinez.m20_maiscomponentesinterface

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.luizafmartinez.m20_maiscomponentesinterface.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //private  lateinit var btnClique: Button
    //private lateinit var binding: ActivityMainBinding
    private val binding by lazy {
        ActivityMainBinding.inflate( layoutInflater )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView( binding.root )
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        with(binding) {
            btnClique?.setOnClickListener {  }
            btnExecutar?.setOnClickListener {  } // apace no layout -> land
        }

        // Usando método antigo para fazer vinculação (findViewById)
        /*
        btnClique = findViewById(R.id.btn_clique)
        btnClique.setOnClickListener {
            Toast.makeText(this, "Olá", Toast.LENGTH_SHORT).show()
        }
        */
    }
}