package com.augusto.prova01parte01mateuseaugusto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts

class InserirPostoGasolina : AppCompatActivity() {
    lateinit var etNome : EditText
    lateinit var etCNPJ : EditText
    lateinit var ndCaixa : EditText
    lateinit var ndcapacidade : EditText
    lateinit var btInserir : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inserir_posto_gasolina)

        etNome = findViewById(R.id.et_nome_posto)
        etCNPJ = findViewById(R.id.et_cnpj_posto)
        ndCaixa = findViewById(R.id.nd_caixa_posto)
        ndcapacidade = findViewById(R.id.nd_capacidade)
        btInserir = findViewById(R.id.bt_inserir_posto)

        if(Listas.tipoMovimento == 2){

            etNome.setText(Listas.listaP.get(Listas.indice).nome)
            etCNPJ.setText(Listas.listaP.get(Listas.indice).cnpj)
            ndCaixa.setText(Listas.listaP.get(Listas.indice).caixa.toString())
            ndcapacidade.setText(Listas.listaP.get(Listas.indice).capacidadeTanque.toString())
            btInserir.setText("Alterar")
        }

        btInserir.setOnClickListener(){
            if(Listas.tipoMovimento == 2)
                Listas.listaP.removeAt(Listas.indice)

            if(!etCNPJ.text.toString().isEmpty() && !etNome.text.toString().isEmpty() && !ndCaixa.text.toString().isEmpty() && !ndcapacidade.text.toString().isEmpty() != null && Listas.verificarCnpj(etCNPJ.text.toString())){
                Listas.listaP.add(PostoGasolina(etNome.text.toString(), etCNPJ.text.toString(), ndCaixa.text.toString().toFloat(), ndcapacidade.text.toString().toFloat()))
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