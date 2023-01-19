package com.programmersbox.common

import com.programmersbox.reminders.GDQReminderDatabase
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.sqlite.driver.JdbcSqliteDriver

internal actual class DriverFactory {
    actual fun createDriver(): SqlDriver {
        val driver: SqlDriver = JdbcSqliteDriver(JdbcSqliteDriver.IN_MEMORY)
        GDQReminderDatabase.Schema.create(driver)
        return driver
    }
}