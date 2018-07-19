package br.unifor.alunor17.agenda.activity

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import br.unifor.alunor17.agenda.R
import br.unifor.alunor17.agenda.activity.Business.Business
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_inicial.*

class InicialActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicial)
        Realm.init(this)

        entrar()
        criarConta()
    }

    private fun entrar() {


        entrar.setOnClickListener {

            Business.entrar(
                    email.text.toString(),
                    senha.text.toString(),
                    {
                         Snackbar.make(findViewById(R.id.inicial), "Deu tudo certo!", Snackbar.LENGTH_SHORT).show()
//                        val intent = Intent(this@InicialActivity, ContatosActivity::class.java)
//                        startActivity(intent)
                    },
                    {
                        messageResource -> (Snackbar.make(findViewById(R.id.inicial), messageResource, Snackbar.LENGTH_SHORT).show())
                    })
        }

    }

    private fun criarConta() {

    }

}
