package br.com.treinamento.moduloconsumoapi3.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.treinamento.moduloconsumoapi3.data.repository.FirebaseMessagingRepository
import br.com.treinamento.moduloconsumoapi3.modelo.PushNotification
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class NotificationViewModel : ViewModel() {

    private val repository = FirebaseMessagingRepository()

    private val _token = MutableStateFlow("")

    val token: StateFlow<String> =
        _token


    private val _notification =
        MutableStateFlow<PushNotification?>(null)

    val notification: StateFlow<PushNotification?> =
        _notification



    fun loadToken() {

        viewModelScope.launch {

            try {

                _token.value =
                    repository.getToken()

            } catch (e: Exception) {

                _token.value =
                    "Erro: ${e.message}"

                e.printStackTrace()
            }
        }
    }


    fun onNotificationReceived(
        notification: PushNotification
    ) {

        _notification.value =
            notification
    }
}
