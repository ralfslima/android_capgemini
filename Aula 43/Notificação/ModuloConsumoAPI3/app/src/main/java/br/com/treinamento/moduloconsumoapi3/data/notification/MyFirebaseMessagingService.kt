package br.com.treinamento.moduloconsumoapi3.data.notification

import android.os.Build
import androidx.annotation.RequiresApi
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onMessageReceived(
        remoteMessage: RemoteMessage
    ) {

        val title =
            remoteMessage.notification?.title
                ?: "Nova notificação"


        val message =
            remoteMessage.notification?.body
                ?: "Você recebeu uma mensagem"


        NotificationHelper.showNotification(
            context = applicationContext,
            title = title,
            message = message
        )
    }


    override fun onNewToken(token: String) {
        super.onNewToken(token)

        // Esse método é chamado quando o Firebase
        // gera um novo token para o dispositivo.

        println("Novo token FCM: $token")
    }
}
