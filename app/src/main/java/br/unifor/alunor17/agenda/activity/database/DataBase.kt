package br.unifor.alunor17.agenda.activity.database

import br.unifor.alunor17.agenda.activity.Module.Usuario
import io.realm.Realm

object DataBase {

    fun salvaUsuario(usuario: Usuario, onSuccess: () -> Unit){
            Realm.getDefaultInstance().use { realm ->
                realm.beginTransaction()
                realm.copyToRealm(usuario)
                realm.commitTransaction()
                onSuccess()
            }
    }


}