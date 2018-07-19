package br.unifor.alunor17.agenda.activity.Module

import com.google.gson.annotations.SerializedName

open class Usuario {

    var email:String = ""
    @SerializedName("password") var senha:String = ""

}