package com.programmersbox.common

import com.programmersbox.reminders.GDQReminderDatabase
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.sqljs.initSqlDriver
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.asDeferred

internal actual class DriverFactory {
    @OptIn(ExperimentalCoroutinesApi::class)
    actual fun createDriver(): SqlDriver {
        return initSqlDriver(GDQReminderDatabase.Schema).asDeferred().getCompleted()
    }
}