package com.augusto.prova01parte01mateuseaugusto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts

class InserirSupermercado : AppCompatActivity() {
    lateinit var etNome : EditText
    lateinit var etCNPJ : EditText
    lateinit var ndCaixa : EditText
    lateinit var cbar : CheckBox
    lateinit var btInserir : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inserir_supermercado)

        etNome = findViewById(R.id.et_nome_supermercado)
        etCNPJ = findViewById(R.id.et_cnpj_supermercado)
        ndCaixa = findViewById(R.id.nd_caixa_supermercado)
        cbar = findViewById(R.id.cb_ar_supermercado)
        btInserir = findViewById(R.id.bt_inserir_supermercado)

        var ar = false

        cbar.setOnCheckedChangeListener{buttonView, isChecked ->
            if(isChecked){
                ar = true
            }
        }

        if(Listas.tipoMovimento == 2){
            etNome.setText(Listas.listaS.get(Listas.indice).nome)
            etCNPJ.setText(Listas.listaS.get(Listas.indice).cnpj)
            ndCaixa.setText(Listas.listaS.get(Listas.indice).caixa.toString())
            btInserir.setText("Alterar")
        }

        btInserir.setOnClickListener(){
            if(Listas.tipoMovimento == 2)
                Listas.listaS.removeAt(Listas.indice)

            if(!etCNPJ.text.toString().isEmpty() && !etNome.text.toString().isEmpty() && !ndCaixa.text.toString().isEmpty()  && Listas.verificarCnpj(etCNPJ.text.toString())){
                Listas.listaS.add(Supermercado(etNome.text.toString(), etCNPJ.text.toString(), ndCaixa.text.toString().toFloat(), ar))
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