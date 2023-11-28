package com.augusto.prova01parte01mateuseaugusto

import android.os.Parcelable

class PostoGasolina(nome: String, cnpj: String, caixa : Float, capacidadeTanque : Float) : Empresa(nome, cnpj, caixa){

    var capacidadeTanque : Float = 0.0f

    init {
        this.capacidadeTanque = capacidadeTanque
    }

    override fun toString(): String {
        return "PostoGasolina Nome: $nome CNPJ: $cnpj Caixa: $caixa capacidadeTanque:$capacidadeTanque \n"
    }


}