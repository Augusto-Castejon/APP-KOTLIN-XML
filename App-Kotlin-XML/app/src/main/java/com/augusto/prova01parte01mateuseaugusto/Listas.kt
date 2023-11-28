package com.augusto.prova01parte01mateuseaugusto


class Listas(){

    companion object {
        var tipoMovimento : Int = 0
        var indice : Int = 0
        var tipoLista : Int = 0
        var listaC = ArrayList<Cinema>()
        var listaP = ArrayList<PostoGasolina>()
        var listaS = ArrayList<Supermercado>()

        fun verificarCnpj(cnpjTemp : String): Boolean {

            for(cinema in this.listaC){

                if(cinema.cnpj.equals(cnpjTemp)){
                    return false;
                }

            }

            for(postoGasolina in this.listaP){

                if(postoGasolina.cnpj.equals(cnpjTemp)){
                    return false;
                }

            }

            for(supermercado in this.listaS){

                if(supermercado.cnpj.equals(cnpjTemp)){
                    return false;
                }

            }

            return true;
        }

        fun exiteCnpj(cnpjTemp : String): Boolean {
            if(Listas.tipoLista == 1){
                for(supermercado in this.listaS){

                    if(supermercado.cnpj.equals(cnpjTemp)){
                        return false;
                    }

                }
            }
            else if(Listas.tipoLista == 2){
                for(cinema in this.listaC){

                    if(cinema.cnpj.equals(cnpjTemp)){
                        return false;
                    }

                }
            }
            else{
                for(postoGasolina in this.listaP){

                    if(postoGasolina.cnpj.equals(cnpjTemp)){
                        return false;
                    }

                }
            }
            return true;
        }

        fun buscaIndice(cnpjTemp : String) : Int{

            var i = 0

            if(Listas.tipoLista == 1){
                for (i in 0..this.listaS.size - 1){

                    if(this.listaS.get(i).cnpj.equals(cnpjTemp)){
                        return i
                    }

                }
            }
            else if(Listas.tipoLista == 2){
                for (i in 0..this.listaC.size - 1){

                    if(this.listaC.get(i).cnpj.equals(cnpjTemp)){
                        return i
                    }

                }
            }
            else{
                for(postoGasolina in this.listaP){

                    for (i in 0..this.listaP.size - 1){

                        if(this.listaP.get(i).cnpj.equals(cnpjTemp)){
                            return i
                        }

                    }

                }
            }
            return i
        }

        fun retorna_lista() : ArrayList<String> {

                var lista = ArrayList<String>()

                if(Listas.tipoLista == 1){

                    for(supermercado in this.listaS){

                        lista.add(supermercado.toString())

                    }
                }
                else if(Listas.tipoLista == 2){
                    for(cinema in this.listaC){

                        lista.add(cinema.toString())

                    }
                }
                else if(Listas.tipoLista == 3) {

                    for(posto in this.listaP){

                        lista.add(posto.toString())

                    }

                }else{
                    for(supermercado in this.listaS){

                        lista.add(supermercado.toString())

                    }
                    for(cinema in this.listaC){

                        lista.add(cinema.toString())

                    }
                    for(posto in this.listaP){

                        lista.add(posto.toString())

                    }
                }

                return lista;

        }

        fun valortotal() : Float{

            var total = 0.0f

            for(supermercado in this.listaS){

                total += supermercado.caixa

            }
            for(cinema in this.listaC){

                total += cinema.caixa

            }
            for(posto in this.listaP){

                total += posto.caixa

            }

            return total
        }
    }

}