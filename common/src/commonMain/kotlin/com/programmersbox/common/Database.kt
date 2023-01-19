package com.programmersbox.common

import com.programmersbox.reminders.GDQReminderDatabase
import com.squareup.sqldelight.db.SqlDriver

internal expect class DriverFactory {
    fun createDriver(): SqlDriver
}

internal fun createDatabase(driverFactory: DriverFactory): GDQReminderDatabase {
    val driver = driverFactory.createDriver()
    val database = GDQReminderDatabase(driver)
    // Do more work with the database (see below).

    return database
}

// in src/commonMain/kotlin
//internal expect suspend fun provideDbDriver(schema: SqlDriver.Schema): SqlDriver

/*
internal class SharedDatabase(
    private val driverProvider: suspend (SqlDriver.Schema) -> SqlDriver
) {
    private var database: GDQReminderDatabase? = null

    suspend fun initDatabase() {
        if (database == null) {
            database = driverProvider(GDQReminderDatabase.Schema).createDatabase()
        }
    }

    suspend operator fun <R> invoke(block: suspend (GDQReminderDatabase) -> R): R {
        initDatabase()
        return block(database!!)
    }

    private fun SqlDriver.createDatabase(): GDQReminderDatabase { */
/* ... *//*
 }
}

internal val sharedDb = SharedDatabase(::createTestDbDriver)
internal class DataRepository(
    private val withDatabase: SharedDatabase = sharedDb
) {
    suspend fun getData() = withDatabase { database ->
        */
/* Do something with the database *//*

    }
}*/
