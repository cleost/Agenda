package br.unifor.alunor17.agenda.activity.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.unifor.alunor17.agenda.R
import kotlinx.android.synthetic.main.activity_contatos.*

class ContatosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contatos)

        val ss:String = intent.getStringExtra("usuario")
        nome.text=ss

    }
}
