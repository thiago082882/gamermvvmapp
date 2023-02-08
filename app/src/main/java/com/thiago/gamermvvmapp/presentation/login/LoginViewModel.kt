package com.thiago.gamermvvmapp.presentation.login

import android.util.Patterns
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {

//Email
    var email: MutableState<String> = mutableStateOf("")
    var isEmailValid: MutableState<Boolean> = mutableStateOf(false)
    var emailErrorMsg : MutableState<String> = mutableStateOf("")


    var senha: MutableState<String> = mutableStateOf("")
    var isSenhaValid: MutableState<Boolean> = mutableStateOf(false)
    var senhaErrorMsg : MutableState<String> = mutableStateOf("")

//Button
    var isEnableLoginButton = false
    fun enableLoginButton(){
         isEnableLoginButton = isEmailValid.value && isSenhaValid.value
    }

    fun validateEmail() {

        //Validar o email
        if(Patterns.EMAIL_ADDRESS.matcher(email.value).matches()) {
            isEmailValid.value=true
            emailErrorMsg.value=""
        }else{
            isEmailValid.value=false
            emailErrorMsg.value="Email inválido"
        }
        enableLoginButton()
    }
 fun validateSenha() {
     if(senha.value.length >=6) {
         isSenhaValid.value=true
         senhaErrorMsg.value=""
     }else{
         isSenhaValid.value=false
         senhaErrorMsg.value="A senha deverá ter 6 caracteres"
     }
     enableLoginButton()
 }


}
