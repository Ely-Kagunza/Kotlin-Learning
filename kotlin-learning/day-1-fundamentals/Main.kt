// CONCEPT 1: Immutable vs Mutable variables

// val = Immutable (can't change after assignment)
val name = "Kitchen Command"
val age: Int = 25

// var = mutable (can change)
var count = 0
count = 5

// Type inference (Kotlin figures out the type)
val price = 19.99  // Double inferred
val isAvailable = true  // Boolean inferred

// EXplicit types
val revenue: Double = 5000.50
val orderId: String = "ORD-001"

printIn("Name: $name")
printIn("Count: $count")
printIn("Price: $price")