package com.programmersbox.common

import com.programmersbox.reminders.GDQReminderDatabase
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

internal actual class DriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(GDQReminderDatabase.Schema, "test.db")
    }
}