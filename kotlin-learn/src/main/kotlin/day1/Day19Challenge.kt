package org.example.day1

fun String.isValidEmail(): Boolean {
    return contains("@") && contains(".")
}

fun Double.toKsh(): String {
    return "KSh ${"%.2f".format(this)}"
}

fun <T> List<T>.secondOrNullCustom(): T? {
    return if (size > 1) this[1] else null
}

fun <T : Number> List<T>.sumAsDouble(): Double {
    return sumOf { it.toDouble() }
}

interface Astronout {
    fun performSpaceWalk(): String
    fun pilotAircraft(): String
}

class Engineer(val name: String) : Astronout {
    override fun performSpaceWalk() = "$name is repairing the solar system"
    override fun pilotAircraft() = "$name is flying the spaceship manually"
}

class Doctor(val name: String) : Astronout {
    override fun performSpaceWalk() = "$name is repairing retrieving a medical experience"
    override fun pilotAircraft() = "$name is navigating to the space station"
}

class MissionRoster<T : Astronout>(val crew: List<T>) {
    fun runSimulation(): String {
        return crew.joinToString("\n") {"${it.pilotAircraft()} then ${it.performSpaceWalk()}" }
    }
    fun deployMember(index: Int): T = crew[index]
}

fun main() {
    println("--- Email Validation ---")
    println("alice@gmail.com".isValidEmail())
    println("bad-email".isValidEmail())

    println("\n--- Currency Formatting ---")
    println(500.0.toKsh())
    println(1234.5.toKsh())

    println("\n--- Second Item ---")
    println(listOf("Alice", "Bob", "Charlie").secondOrNullCustom())
    println(listOf(10).secondOrNullCustom())
    println(listOf(5.5, 7.7).secondOrNullCustom())

    println("\n--- Sum As Double ---")
    println(listOf(1, 2, 3).sumAsDouble())
    println(listOf(1.5, 2.5, 3.0).sumAsDouble())

    val engineers = MissionRoster(listOf(Engineer("Valentina"), Engineer("Yuri")))
    println(engineers.runSimulation())

    val doctors = MissionRoster(listOf(Doctor("Mae"), Doctor("Serena")))
    val deployedDoctor: Doctor = doctors.deployMember(0)
    println(deployedDoctor)

}