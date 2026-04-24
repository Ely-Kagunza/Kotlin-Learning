package org.example.day1

data class Exercise(val id: String, val name: String, val type: String, val reps: Int, val caloriesBurned: Double)
data class WorkoutSet(val exercise: Exercise, var sets: Int = 1) {
    fun totalReps(): Int = exercise.reps * sets
    fun totalCalories(): Double = exercise.caloriesBurned * sets
}
data class Workout(val id: String, var exercises: MutableList<WorkoutSet> = mutableListOf()) {
    fun totalCalories(): Double = exercises.sumOf { it.totalCalories() }
    fun totalReps(): Int = exercises.sumOf { it.totalReps() }
}

val exerciseLibrary = listOf(
    Exercise("EX1", "Push-ups", "chest", 20, 50.0),
    Exercise("EX2", "Squats", "legs", 15, 80.0),
    Exercise("EX3", "Burpees", "cardio", 10, 120.0)
)

fun createWorkout(id: String, exerciseList: List<Pair<Exercise, Int>>): Workout {
    return Workout(id).apply {
        exercises.addAll(
            exerciseList.map { (exercise, sets) -> WorkoutSet(exercise, sets)}
        )
    }
}

fun intensifyWorkout(workouts: List<Workout>, intensityMultiplier: Double): List<Workout> {
    return workouts
        .also { println("Intensifying ${it.size} workouts") }
        .map { workout ->
            Workout(workout.id).apply {
                workout.exercises.forEach { set ->
                    exercises.add(WorkoutSet(set.exercise, (set.sets * intensityMultiplier).toInt()))
                }
            }
        }
        .also { println(it) }
}

fun workoutSummary(workout: Workout): String {
    return workout.run {
        val header = "Workout $id"
        val lines = exercises.map { set ->
            with(set) {
                " - ${exercise.name} (${exercise.type}) x$sets sets: ${totalReps()} total reps, ${totalCalories()} calories"
            }
        }.joinToString("\n")
        val footer = "Total: ${totalReps()} reps, ${totalCalories()} calories burned"
        "$header\n$lines\n$footer"
    }
}

fun main() {
    val wo1 = createWorkout("WO-1", listOf(exerciseLibrary[0] to 3, exerciseLibrary[1] to 2))
    val wo2 = createWorkout("WO-2", listOf(exerciseLibrary[2] to 2, exerciseLibrary[0] to 1))

    val workouts = listOf(wo1, wo2)
    val intensified = intensifyWorkout(workouts, 1.5)

    intensified.forEach { workout ->
        println(workoutSummary(workout))
        println()
    }
}
