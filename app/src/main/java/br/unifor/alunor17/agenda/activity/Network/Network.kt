package br.unifor.alunor17.agenda.activity.Network

import br.unifor.alunor17.agenda.activity.API.AgendaAPI
import br.unifor.alunor17.agenda.activity.Module.Usuario
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object Network {

    val AgendaAPI by lazy {
        configuraRetrofit().create(AgendaAPI::class.java)
    }

    private fun configuraRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl("https://api-agenda-unifor.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

    fun entrar(usuario: Usuario, onSuccess: (user: Usuario) -> Unit, onError: () -> Unit) {
        AgendaAPI.entrar(usuario)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ user ->
                    user?.let { onSuccess(it) }
                }
                        , {
                    onError()
                })
    }

    fun criarConta(usuario: Usuario, onSuccess: (usuario: Usuario) -> Unit, onError: () -> Unit) {
        AgendaAPI.criarConta(usuario)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ usuario ->
                    usuario?.let { onSuccess(it) }
                }
                        , {
                    onError()
                })
    }


}