package com.luizafmartinez.m20_maiscomponentesinterface

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import com.luizafmartinez.m20_maiscomponentesinterface.databinding.ActivityFloatingActionButtonBinding

class FloatingActionButtonActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityFloatingActionButtonBinding.inflate(layoutInflater)
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

        with(binding) {
            fabBotao.setOnClickListener() {
                /*
                if( groupMenu.isVisible ) {
                    groupMenu.visibility = View.INVISIBLE
                } else {
                    groupMenu.visibility = View.VISIBLE
                }
                */
                groupMenu.visibility = if( groupMenu.isVisible) {
                    View.INVISIBLE
                } else {
                    View.VISIBLE
                }
            }
        }

    }
}