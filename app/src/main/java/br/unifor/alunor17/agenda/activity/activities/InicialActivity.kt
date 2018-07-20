package br.unifor.alunor17.agenda.activity.activities

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.app.AppCompatActivity
import android.view.View
import br.unifor.alunor17.agenda.R
import br.unifor.alunor17.agenda.activity.Business.Business
import br.unifor.alunor17.agenda.activity.Module.Usuario
import br.unifor.alunor17.agenda.activity.database.DataBase
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_inicial.*

class InicialActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicial)
        Realm.init(this)

        criar_conta.setOnClickListener {
            val intent = Intent(this, CriarActivity::class.java)
            startActivity(intent)
        }

        entrar.setOnClickListener {
            var autenticar = true
            var emailVar = email.text.toString()
            var senhaVar = senha.text.toString()

            if (emailVar.isEmpty() || emailVar.length == 0 || senhaVar.isEmpty() || senhaVar.length == 0) {
                autenticar = false
            }

            if (autenticar) {

                var view: View
                var usuario = Usuario()
                usuario.email = emailVar
                usuario.senha = senhaVar

                Business.entrar(usuario, {
                    DataBase.salvaUsuario(usuario)
                }, { messageResource ->
                    (Snackbar.make(it, messageResource, Snackbar.LENGTH_SHORT).show())
                })


            } else {
                Snackbar.make(findViewById(R.id.inicial), "Preencha os campos corretamente!", Snackbar.LENGTH_SHORT).show()
            }
        }

    }

    private fun contatos(usuario: Usuario) {
        val intent = Intent(this, ContatosActivity::class.java)
        startActivity(intent)
    }
}
