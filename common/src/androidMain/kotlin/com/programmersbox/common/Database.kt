package com.programmersbox.common

import android.content.Context
import com.programmersbox.reminders.GDQReminderDatabase
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

internal actual class DriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(GDQReminderDatabase.Schema, context, "test.db")
    }
}