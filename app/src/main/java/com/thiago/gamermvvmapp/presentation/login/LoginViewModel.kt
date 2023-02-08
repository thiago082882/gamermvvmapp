package com.thiago.gamermvvmapp.presentation.login

import android.util.Patterns
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseUser
import com.thiago.gamermvvmapp.domain.model.Response
import com.thiago.gamermvvmapp.domain.use_cases.auth.AuthUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val authUseCases: AuthUseCases) : ViewModel() {

    //Email
    var email: MutableState<String> = mutableStateOf("")
    var isEmailValid: MutableState<Boolean> = mutableStateOf(false)
    var emailErrorMsg: MutableState<String> = mutableStateOf("")


    var senha: MutableState<String> = mutableStateOf("")
    var isSenhaValid: MutableState<Boolean> = mutableStateOf(false)
    var senhaErrorMsg: MutableState<String> = mutableStateOf("")

    //Button
    var isEnableLoginButton = false

    //Usando Courotines

    private val _loginFlow = MutableStateFlow<Response<FirebaseUser>?>(null)
    val loginFlow: StateFlow<Response<FirebaseUser>?> = _loginFlow

    fun login() = viewModelScope.launch {
        _loginFlow.value =Response.Loading
        val result = authUseCases.login(email.value, senha.value)
        _loginFlow.value = result
    }


    fun enableLoginButton() {
        isEnableLoginButton = isEmailValid.value && isSenhaValid.value
    }

    fun validateEmail() {

        //Validar o email
        if (Patterns.EMAIL_ADDRESS.matcher(email.value).matches()) {
            isEmailValid.value = true
            emailErrorMsg.value = ""
        } else {
            isEmailValid.value = false
            emailErrorMsg.value = "Email inválido"
        }
        enableLoginButton()
    }

    fun validateSenha() {
        if (senha.value.length >= 6) {
            isSenhaValid.value = true
            senhaErrorMsg.value = ""
        } else {
            isSenhaValid.value = false
            senhaErrorMsg.value = "A senha deverá ter 6 caracteres"
        }
        enableLoginButton()
    }


}
