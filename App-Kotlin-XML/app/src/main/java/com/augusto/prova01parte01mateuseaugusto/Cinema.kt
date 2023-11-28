package com.augusto.prova01parte01mateuseaugusto

import android.os.Parcelable

class Cinema(nome: String, cnpj: String, caixa : Float, numCadeiras : Int) : Empresa(nome,cnpj,caixa), Parcelable
{

    var numCadeiras : Int = 0

    init {
        this.numCadeiras = numCadeiras
    }

    override fun toString(): String {
        return "Cinema Nome: $nome CNPJ: $cnpj Caixa: $caixa Quantidade de cadeiras: $numCadeiras \n"
    }


}