package com.augusto.prova01parte01mateuseaugusto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts

class Mostrar : AppCompatActivity() {
    lateinit var lvLista : ListView
    lateinit var etCNPJ : EditText
    lateinit var btnVoltar : Button
    lateinit var btnAlterar : Button
    lateinit var btnExcluir : Button
    var adaptador : ArrayAdapter<String>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar)

        lvLista = findViewById(R.id.lv_lista)
        etCNPJ = findViewById(R.id.et_cnpj)
        btnVoltar = findViewById(R.id.btn_voltar)
        btnExcluir = findViewById(R.id.btn_excluir)
        btnAlterar = findViewById(R.id.btn_alterar)

        adaptador = ArrayAdapter(this, android.R.layout.simple_list_item_1,Listas.retorna_lista())

        lvLista.adapter = adaptador

        btnAlterar.setOnClickListener(){

            Listas.tipoMovimento = 2

            if(!etCNPJ.text.toString().isEmpty()){
                if(!Listas.exiteCnpj(etCNPJ.text.toString())){

                    Listas.indice = Listas.buscaIndice(etCNPJ.text.toString())

                    if(Listas.tipoLista == 1){
                        Intent(this, InserirSupermercado::class.java).let {
                            register.launch(it)
                        }
                    }
                    else if(Listas.tipoLista == 2){
                        Intent(this, InserirCinema::class.java).let {
                            register.launch(it)
                        }
                    }
                    else{
                        Intent(this, InserirPostoGasolina::class.java).let {
                            register.launch(it)
                        }
                    }



                }else{
                    Toast.makeText(this, "CNPJ inexistente!!!", Toast.LENGTH_SHORT).show()
                }
            }else{

                Toast.makeText(this, "Preencha o campo CNPJ!!!", Toast.LENGTH_SHORT).show()

            }

        }

        btnExcluir.setOnClickListener(){

            if(!etCNPJ.text.toString().isEmpty()){
                if(!Listas.exiteCnpj(etCNPJ.text.toString())){

                    Listas.indice = Listas.buscaIndice(etCNPJ.text.toString())

                    if(Listas.tipoLista == 1){
                        Listas.listaS.removeAt(Listas.indice)
                    }
                    else if(Listas.tipoLista == 2){
                        Listas.listaC.removeAt(Listas.indice)
                    }
                    else{
                        Listas.listaP.removeAt(Listas.indice)
                    }

                    adaptador = ArrayAdapter(this, android.R.layout.simple_list_item_1,Listas.retorna_lista())

                    lvLista.adapter = adaptador

                    etCNPJ.text.clear()

                }else{
                    Toast.makeText(this, "CNPJ inexistente!!!", Toast.LENGTH_SHORT).show()
                }
            }else{

                Toast.makeText(this, "Preencha o campo CNPJ!!!", Toast.LENGTH_SHORT).show()

            }

        }



        btnVoltar.setOnClickListener(){

            Listas.tipoMovimento = 0
            Listas.tipoLista = 0
            Listas.indice = 0

            Intent(this, MainActivity::class.java).let {
                register.launch(it)
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