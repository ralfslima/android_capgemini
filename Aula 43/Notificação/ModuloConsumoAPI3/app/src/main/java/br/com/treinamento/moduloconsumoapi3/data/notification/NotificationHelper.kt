package br.com.treinamento.moduloconsumoapi3.data.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import br.com.treinamento.moduloconsumoapi3.R

object NotificationHelper {


    private const val CHANNEL_ID = "firebase_channel"


    @RequiresApi(Build.VERSION_CODES.O)
    fun showNotification(
        context: Context,
        title: String,
        message: String
    ) {


        val manager =
            context.getSystemService(
                Context.NOTIFICATION_SERVICE
            ) as NotificationManager



        val channel =
            NotificationChannel(
                CHANNEL_ID,
                "Firebase Notifications",
                NotificationManager.IMPORTANCE_HIGH
            )


        manager.createNotificationChannel(channel)



        val notification =
            NotificationCompat.Builder(
                context,
                CHANNEL_ID
            )
                .setSmallIcon(
                    R.drawable.ic_launcher_foreground
                )
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(
                    NotificationCompat.PRIORITY_HIGH
                )
                .build()



        manager.notify(
            1,
            notification
        )
    }
}
