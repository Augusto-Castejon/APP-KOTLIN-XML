package com.augusto.prova01parte01mateuseaugusto

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
open class Empresa (val nome: String, val cnpj: String, var caixa : Float) : Parcelable
{

    override fun toString(): String {
        return "Empresa(nome='$nome', cnpj='$cnpj')"
    }
}