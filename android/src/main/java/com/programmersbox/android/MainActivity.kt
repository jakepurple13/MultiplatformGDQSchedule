package com.programmersbox.android

import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.core.content.getSystemService
import com.programmersbox.common.UIShow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationManager = getSystemService<NotificationManager>()
            val notificationName = "gdqschedule"
            val notificationChannel = NotificationChannel(
                "gdqschedule",
                notificationName,
                NotificationManager.IMPORTANCE_DEFAULT
            )
            notificationChannel.description = "gdq schedule"
            notificationManager?.createNotificationChannel(notificationChannel)
        }

        setContent {
            MaterialTheme(darkColorScheme()) {
                UIShow()
            }
        }
    }
}