package br.unifor.alunor17.agenda.activity.API

import br.unifor.alunor17.agenda.activity.Module.Usuario
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

//api para requisicoes sempre sera uma interface

interface AgendaAPI {

    @POST("/auth/sign_in")
    fun entrar(@Body user: Usuario): Observable<Usuario>

    @POST ("/auth")
    fun criarConta(@Body usuario: Usuario): Observable<Usuario>

    @POST()
    fun criarContato()

    @GET("/contacts")
    fun listarContatos()

}