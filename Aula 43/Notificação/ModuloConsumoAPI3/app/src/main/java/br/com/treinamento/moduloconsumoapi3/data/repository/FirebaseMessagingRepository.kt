package br.com.treinamento.moduloconsumoapi3.data.repository

import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.coroutines.tasks.await

class FirebaseMessagingRepository {

    suspend fun getToken(): String {

        return FirebaseMessaging
            .getInstance()
            .getToken()
            .await()
    }
}
