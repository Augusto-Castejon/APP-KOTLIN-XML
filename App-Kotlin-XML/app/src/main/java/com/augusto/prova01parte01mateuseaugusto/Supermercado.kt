package com.augusto.prova01parte01mateuseaugusto
import android.os.Parcelable


class Supermercado(nome: String, cnpj: String, caixa : Float, arcondicionado : Boolean) : Empresa(nome, cnpj, caixa), Parcelable
{

    var arcondicionado : Boolean = false

    init {
        this.arcondicionado = arcondicionado
    }

    override fun toString(): String {
        return "Supermercado Nome: $nome CNPJ: $cnpj Caixa: $caixa Ar condicionado: $arcondicionado \n"
    }


}