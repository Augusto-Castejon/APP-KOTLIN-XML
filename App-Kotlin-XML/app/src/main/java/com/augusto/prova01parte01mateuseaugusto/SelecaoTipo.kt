package com.augusto.prova01parte01mateuseaugusto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts


class SelecaoTipo : AppCompatActivity() {

    lateinit var btnSupermercado: Button
    lateinit var btnCinema: Button
    lateinit var btnPostoGasolina: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selecao_tipo)

        btnSupermercado = findViewById(R.id.btn_Supermercado)
        btnCinema = findViewById(R.id.btn_Cinema)
        btnPostoGasolina = findViewById(R.id.btn_PostoGasolina)

        btnSupermercado.setOnClickListener(){
            Listas.tipoLista = 1

            if(Listas.tipoMovimento == 2){
                Intent(this, Mostrar::class.java).let {
                    register.launch(it)
                }
            }else{
                Intent(this, InserirSupermercado::class.java).let {
                    register.launch(it)
                }
            }


        }
        btnCinema.setOnClickListener(){
            Listas.tipoLista = 2

            if(Listas.tipoMovimento == 2){
                Intent(this, Mostrar::class.java).let {
                    register.launch(it)
                }
            }else{
                Intent(this, InserirCinema::class.java).let {
                    register.launch(it)
                }
            }


        }
        btnPostoGasolina.setOnClickListener(){
            Listas.tipoLista = 3

            if(Listas.tipoMovimento == 2){
                Intent(this, Mostrar::class.java).let {
                    register.launch(it)
                }
            }else{
                Intent(this, InserirPostoGasolina::class.java).let {
                    register.launch(it)
                }
            }


        }

    }

    val register = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
        if (result.resultCode == RESULT_OK) {
            result.data?.let {

            }
        }
    }
}