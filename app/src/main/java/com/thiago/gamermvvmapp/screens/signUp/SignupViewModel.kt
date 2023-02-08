package com.thiago.gamermvvmapp.screens.signUp

import android.util.Patterns
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignupViewModel @Inject constructor() : ViewModel() {

    //USER NAME
    var username: MutableState<String> = mutableStateOf("")
    var isUsernameValid: MutableState<Boolean> = mutableStateOf(false)
    var usernameErrMsg: MutableState<String> = mutableStateOf("")

    //EMAIL
    var email: MutableState<String> = mutableStateOf("")
    var isEmailValid: MutableState<Boolean> = mutableStateOf(false)
    var emailErrorMsg: MutableState<String> = mutableStateOf("")

    //PASSWORD
    var senha: MutableState<String> = mutableStateOf("")
    var isSenhaValid: MutableState<Boolean> = mutableStateOf(false)
    var senhaErrorMsg: MutableState<String> = mutableStateOf("")

    //CONFIRMED PASSWORD
    var confirmesenha: MutableState<String> = mutableStateOf("")
    var isConfirmPasswordValid: MutableState<Boolean> = mutableStateOf(false)
    var confirmPasswordErrMsg: MutableState<String> = mutableStateOf("")

    //BUTTON
    var isEnableLoginButton = false

    fun enableLoginButton(){
        isEnableLoginButton = isUsernameValid.value && isEmailValid.value && isSenhaValid.value && isConfirmPasswordValid.value
    }


    fun validateUserName() {
        if(username.value.length >=5){
            isUsernameValid.value = true
            usernameErrMsg.value = ""


        }else {
            isUsernameValid.value = false
            usernameErrMsg.value = "O nome deverá ter ao menos 5 caracteres"
        }
        enableLoginButton()
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
    fun validateConfirmeSenha() {
        if(senha.value == confirmesenha.value) {
            isConfirmPasswordValid.value=true
            confirmPasswordErrMsg.value=""
        }else{
            isConfirmPasswordValid.value=false
            confirmPasswordErrMsg.value="As senhas não coincidem"
        }
        enableLoginButton()
    }

}