package br.unifor.alunor17.agenda.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import br.unifor.alunor17.agenda.R
import kotlinx.android.synthetic.main.activity_inicial.*

class InicialActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicial)


        var emailVar=email.text.toString()
        var senhaVar=senha.text.toString()

        entrar.setOnClickListener{
            val intent = Intent(this@InicialActivity, ContatosActivity::class.java)
            intent.putExtra("email", emailVar)
            startActivity(intent)
        }

    }

}
