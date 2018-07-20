package br.unifor.alunor17.agenda.activity.Business

import br.unifor.alunor17.agenda.R
import br.unifor.alunor17.agenda.activity.Module.Usuario
import br.unifor.alunor17.agenda.activity.Network.Network

//camada de regra de negocios faz chamada para o network, que e responsavel pelos servicos

object Business {



    fun entrar(usuario: Usuario, onSucess: () -> Unit, onError: (message: Int) -> Unit) {

        Network.entrar(usuario, {
            it
        }, {
            onError(R.string.erro_entrar)
        })
    }

    fun criarConta(usuario: Usuario, onSucess: () -> Unit, onError: (message: Int) -> Unit) {
        Network.criarConta(usuario, {
            it
        }, {
            onError(R.string.erro_criar_conta)
        })
    }
}