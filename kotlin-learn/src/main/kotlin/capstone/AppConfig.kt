package org.example.capstone

object AppConfig {
    val appName: String = "RideKE"
    val version: String = "1.0.0"
    val supportEmail: String = "support@rideke.co.ke"
    internal val apiBaseUrl: String = "https://api.rideke.co.ke"
    val maxDistance: Double = 100.0

    fun printInfo() {
        println("---- ${(AppConfig.appName).uppercase()} ----")
        println("Version: ${AppConfig.version}")
        println("Support Email: ${AppConfig.supportEmail}\n")
    }
}