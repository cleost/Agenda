package br.unifor.alunor17.agenda.activity.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import br.unifor.alunor17.agenda.R
import br.unifor.alunor17.agenda.activity.Business.Business
import br.unifor.alunor17.agenda.activity.Module.Usuario
import kotlinx.android.synthetic.main.activity_criar.*
import kotlinx.android.synthetic.main.activity_inicial.*

class CriarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_criar)

        criarConta()
    }

    fun criarConta() {
        criar_usuario.setOnClickListener {

            var usuario = Usuario()

            var autenticar: Boolean = true
            var emailVar: String = criar_email.text.toString()
            var senhaVar: String = criar_senha.text.toString()
            var senhaNovamenteVar = criar_senha_confirmacao.text.toString()

            if (emailVar.isEmpty() || senhaVar.isEmpty() || senhaNovamenteVar.isEmpty() || !senhaVar.equals(senhaNovamenteVar)) {
                autenticar = false
            }

            if (autenticar) {

                usuario.email = emailVar
                usuario.senha = senhaVar
                usuario.senha_confirmacao = senhaNovamenteVar

                Business.criarConta(usuario,
                        {
                           //
                        }, {
                            (Snackbar.make(findViewById(R.id.criar), "Falha ao criar usuario", Snackbar.LENGTH_SHORT).show())
                        })

            } else {
                Snackbar.make(findViewById(R.id.inicial), "Preencha os campos corretamente!", Snackbar.LENGTH_SHORT).show()
            }


        }
    }



}
