package com.augusto.prova01parte01mateuseaugusto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts

class InserirCinema : AppCompatActivity() {
    lateinit var etNome : EditText
    lateinit var etCNPJ : EditText
    lateinit var ndCaixa : EditText
    lateinit var ndCadeiras : EditText
    lateinit var btInserir : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inserir_cinema)

        etNome = findViewById(R.id.et_nome_cinema)
        etCNPJ = findViewById(R.id.et_cnpj_cinema)
        ndCaixa = findViewById(R.id.nd_caixa_cinema)
        ndCadeiras = findViewById(R.id.nd_quantidade)
        btInserir = findViewById(R.id.bt_inserir_cinema)

        if(Listas.tipoMovimento == 2){

            etNome.setText(Listas.listaC.get(Listas.indice).nome)
            etCNPJ.setText(Listas.listaC.get(Listas.indice).cnpj)
            ndCaixa.setText(Listas.listaC.get(Listas.indice).caixa.toString())
            ndCadeiras.setText(Listas.listaC.get(Listas.indice).numCadeiras.toString())
            btInserir.setText("Alterar")
        }

        btInserir.setOnClickListener(){
            if(Listas.tipoMovimento == 2)
                Listas.listaC.removeAt(Listas.indice)

            if(!etCNPJ.text.toString().isEmpty() && !etNome.text.toString().isEmpty() && !ndCaixa.text.toString().isEmpty() && !ndCadeiras.text.toString().isEmpty() != null && Listas.verificarCnpj(etCNPJ.text.toString())){
                Listas.listaC.add(Cinema(etNome.text.toString(), etCNPJ.text.toString(), ndCaixa.text.toString().toFloat(), ndCadeiras.text.toString().toInt()))
                Intent(this, Mostrar::class.java).let {
                    register.launch(it)
                }
            }
            else{
                Toast.makeText(this, "Preencha todos os campos e coloque um CNPJ único!!!", Toast.LENGTH_SHORT).show()
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