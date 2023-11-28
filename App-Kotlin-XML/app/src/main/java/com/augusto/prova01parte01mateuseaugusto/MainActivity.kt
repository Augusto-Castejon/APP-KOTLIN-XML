package com.augusto.prova01parte01mateuseaugusto

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStreamReader


class MainActivity : AppCompatActivity() {

    private var arquivoExterno: File?=null
    private val armazenamentoExternoSomenteLeitura: Boolean get() {
        var armazSomLeitRet = false
        val armazenamentoExterno = Environment.getExternalStorageState()
        if (Environment.MEDIA_MOUNTED_READ_ONLY == armazenamentoExterno) {
            armazSomLeitRet = true
        }
        return (armazSomLeitRet)
    }
    private val armazenamentoExternoDisponivel: Boolean get() {
        var armazExtDispRet = false
        val extStorageState = Environment.getExternalStorageState()
        if (Environment.MEDIA_MOUNTED == extStorageState) {
            armazExtDispRet = true
        }
        return(armazExtDispRet)
    }


    lateinit var btnInserir : Button
    lateinit var btnAlterar : Button
    lateinit var btnRemover : Button
    lateinit var btnMostrar : Button
    lateinit var btnValorTotal : Button
    lateinit var btnSalvarArquivo : Button
    lateinit var btnMostrarDados : Button
    lateinit var tvValorTotal : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnInserir = findViewById(R.id.btn_Inserir)
        btnAlterar = findViewById(R.id.btn_Alterar)
        btnRemover = findViewById(R.id.btn_Remover)
        btnMostrar = findViewById(R.id.btn_Mostrar)
        btnValorTotal = findViewById(R.id.btn_ValorTotal)
        btnSalvarArquivo = findViewById(R.id.btn_salvar_arquivos)
        btnMostrarDados = findViewById(R.id.btn_mostrar_dados)
        tvValorTotal = findViewById(R.id.tv_valor_total)



        btnInserir.setOnClickListener(){
            Listas.tipoMovimento = 1
            Intent(this, SelecaoTipo::class.java).let {
                register.launch(it)
            }
        }

        btnAlterar.setOnClickListener(){
            Listas.tipoMovimento = 2
            Intent(this, SelecaoTipo::class.java).let {
                register.launch(it)
            }
        }

        btnRemover.setOnClickListener(){
            Listas.tipoMovimento = 2
            Intent(this, SelecaoTipo::class.java).let {
                register.launch(it)
            }
        }

        btnMostrar.setOnClickListener(){
            Listas.tipoMovimento = 2
            Intent(this, SelecaoTipo::class.java).let {
                register.launch(it)
            }
        }

        btnSalvarArquivo.setOnClickListener(){

            arquivoExterno = File(getExternalFilesDir("ArquivoGerencial"), "DadosEmpresas")
            try {
                Listas.tipoLista = 0
                val fileOutPutStream = FileOutputStream(arquivoExterno)
                for(linha in Listas.retorna_lista()){
                    fileOutPutStream.write(linha.toByteArray())
                }
                fileOutPutStream.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
            Toast.makeText(applicationContext,"Texto salvo com sucesso!",Toast.LENGTH_SHORT).show()

        }

        btnMostrarDados.setOnClickListener(){

            arquivoExterno = File(getExternalFilesDir("ArquivoGerencial"),"DadosEmpresas")
            if("DadosEmpresas".trim()!=""){
                val fileInputStream = FileInputStream(arquivoExterno)
                val inputStreamReader: InputStreamReader = InputStreamReader(fileInputStream)
                val bufferedReader: BufferedReader = BufferedReader(inputStreamReader)
                val stringBuilder: StringBuilder = StringBuilder()
                var text: String? = null

                //while ((linha = br.readLine()) != null) - Java
                while ((bufferedReader.readLine().also { text = it }) != null)
                {
                    stringBuilder.append(text)
                }
                fileInputStream.close()
                Toast.makeText(applicationContext,"O resultado é apresentado no log",Toast.LENGTH_SHORT).show()
                Log.i("Dados empresariais", stringBuilder.toString())
            }
        }

        btnValorTotal.setOnClickListener(){

            tvValorTotal.setText("Valor total: "+Listas.valortotal().toString())

        }



    }

    val register = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
        if (result.resultCode == RESULT_OK) {
            result.data?.let {

            }
        }
    }

}
