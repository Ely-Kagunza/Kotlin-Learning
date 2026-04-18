# Kotlin Mastery & Mobile Development Roadmap (v2)
## Kitchen Command Mobile App - 5 Month Sustainable Learning Plan

**Duration:** 20 weeks (140 days)
**Weekly Commitment:** 12–15 hours (sustainable) / up to 18 hours on "push weeks"
**Goal:** Kotlin proficiency → Modern Android (Jetpack Compose) → Hardware integration → Production-ready
**Primary UI Framework:** Jetpack Compose (NOT XML layouts — XML is legacy-only)

**Target Toolchain (April 2026):**
- **Kotlin:** 2.3.20 (latest stable)
- **Compose BOM:** `2026.03.00`
- **compileSdk / targetSdk:** 36 (Android 16) — required by Google Play from Aug 31, 2026
- **minSdk:** 26 (Android 8.0, covers ~97% of devices — bump from v1's 24)
- **Gradle:** 9.3.x
- **KSP** (Kotlin Symbol Processing) over **KAPT** — faster, required by Room 3.0

---

## IDE Setup — IMPORTANT for IntelliJ IDEA Ultimate Users

If you're on IntelliJ IDEA Ultimate, read this carefully.

**The Android plugin is no longer bundled with IntelliJ IDEA** (since 2023.3+). You can still install it via `Settings → Plugins → Marketplace → "Android"`, but Android Studio is Google's official tool and has first-class support for:
- AVD Manager (emulator)
- Layout Inspector
- CPU/Memory Profiler
- Compose Preview (works in IDEA but more reliable in Studio)
- Android-specific lint + quick-fixes
- Tight integration with the latest Android Gradle Plugin (AGP)

IDEA Ultimate typically lags 6+ months behind Android Studio on these tools.

**Recommended split:**

| Weeks | IDE | Why |
|---|---|---|
| 1–8 (Kotlin only) | **IntelliJ IDEA Ultimate** | Best Kotlin experience + your Django backend in the same IDE |
| 9–20 (Android) | **Android Studio** (free, install alongside Ultimate) | Official Android tooling, emulator, profiler, Compose Preview |

Both IDEs share the same keyboard shortcuts, settings, and code style. Switching costs ~5 minutes. Install Android Studio from https://developer.android.com/studio when you hit Week 9.

**Pure Kotlin project setup in IDEA Ultimate (Weeks 1–8):**
`File → New → Project → Kotlin → Gradle (Kotlin DSL)` → select JDK 17+ → done.

---

## What Changed from v1 (and why)

If you're the learner: you followed v1 up to Day 5 (Collections). **Good news — you keep everything through Day 7.** Nothing you've learned is wasted. What changes is everything *after* Day 7.

| Problem in v1 | Fix in v2 |
|---|---|
| Phase 3+ was literally unfinished ("token limit" placeholder) | Every phase now has real teaching content or detailed outlines |
| Taught XML + ViewBinding (deprecated-in-practice) | Teaches Jetpack Compose from day one of Android |
| Coroutines never actually taught, only listed as a checkpoint | Dedicated Phase 4 (Weeks 7–8) with suspend, Flow, structured concurrency |
| Missing scope functions, sealed classes, generics, delegation, visibility modifiers | All added in Phases 2–3 |
| Testing started Week 15 (too late) | Introduced Week 5; woven through every subsequent phase |
| MVP scheduled Week 9 (fantasy) | Moved to Week 14 (realistic) |
| 25–28 hrs/week (burnout guaranteed) | 12–15 hrs/week (sustainable) |
| C parallel track (~100 hrs wasted on unrelated skill) | Dropped to optional 1 hr/week; focus goes to Kotlin/Android |
| Django "read your own code" Sundays (passive) | Active refactoring challenges with clear deliverables |
| No Gradle, no Hilt, no Retrofit, no Room depth | All have dedicated lessons in Phase 6 |

---

## Table of Contents
1. [Overall Strategy](#overall-strategy)
2. [Week-by-Week Breakdown](#week-by-week-breakdown)
3. Phase 1: Kotlin Fundamentals (Weeks 1–2) — *PRESERVED*
4. Phase 2: Kotlin Intermediate (Weeks 3–4) — *NEW*
5. Phase 3: OOP & Type System (Weeks 5–6) — *EXPANDED*
6. Phase 4: Advanced Kotlin — Coroutines & Flow (Weeks 7–8) — *NEW*
7. Phase 5: Android with Jetpack Compose (Weeks 9–10) — *REPLACED*
8. Phase 6: Architecture & Data (Weeks 11–12) — *NEW*
9. Phase 7: Real App Building (Weeks 13–16)
10. Phase 8: Hardware & Production (Weeks 17–20) — *EXPANDED*
11. [Optional C Sidebar](#optional-c-sidebar)
12. [Active Django Sundays](#active-django-sundays)
13. [Assessment Checkpoints](#assessment-checkpoints)
14. [Study Tips & Resources](#study-tips--resources)

---

## Overall Strategy

### Time Allocation (Weekly, sustainable)
- **Kotlin/Android focused sessions:** 10–12 hours (Mon, Wed, Fri, Sat)
- **Review + spaced repetition:** 1–2 hours (any day)
- **Active Django refactoring (optional):** 1 hour (Sunday)
- **C sidebar (optional):** 1 hour (Tuesday or Thursday)
- **Total core:** 12–15 hours/week

### Learning Methodology
- **Code-first approach:** Write code, then understand concepts
- **Bridging:** Compare Kotlin to JavaScript, TypeScript, Python syntax (where helpful)
- **Active recall over passive reading:** Every day ends with a 10-min "explain it to yourself" session
- **Spaced repetition:** Every Saturday = review Monday's notes
- **Testing first-class from Week 5:** No feature without a test

### Android Pedagogy (modern)
- Start with **Jetpack Compose** (declarative UI). You will rarely touch XML.
- Learn **state management before navigation**. State is the heart of Compose.
- Architecture (MVVM + Hilt) comes **after** you've felt the pain of not having it.
- **Real backend integration from Week 11**, not week 9.

### What's Explicitly Out of Scope (for now)
- Kotlin Multiplatform (KMP) — revisit after Week 20 if needed
- Jetpack Compose animations beyond basics — touch in Week 19
- Custom Gradle plugins / build logic — unnecessary for your goal

---

## Week-by-Week Breakdown

| Week | Phase | Focus | Hrs | Main Deliverable |
|------|-------|-------|-----|------------------|
| 1–2 | 1 | Kotlin Fundamentals | 12/wk | Restaurant Menu System (Day 7) |
| 3–4 | 2 | Kotlin Intermediate | 13/wk | Refactored system using scope functions + sealed states |
| 5–6 | 3 | OOP & Type System | 14/wk | Typed domain model with tests |
| 7–8 | 4 | Coroutines & Flow | 15/wk | Async order processor with Flow emissions |
| 9–10 | 5 | Jetpack Compose | 15/wk | 3-screen Compose app with state hoisting |
| 11–12 | 6 | Architecture & Data | 15/wk | Menu screen fetching real API, Room-cached |
| 13 | 7 | Auth & Login | 14/wk | Login + token refresh flow |
| 14 | 7 | MVP Skeleton | 16/wk | **Kitchen Command MVP v0.1** |
| 15 | 7 | WebSockets & Realtime | 15/wk | Live order feed |
| 16 | 7 | Offline & Error Handling | 15/wk | Robust MVP v0.2 |
| 17 | 8 | Bluetooth + Printers | 14/wk | Receipt printing works |
| 18 | 8 | Testing Deep Dive | 12/wk | 70%+ coverage on critical paths |
| 19 | 8 | Performance & Polish | 12/wk | Profiled, no leaks, smooth |
| 20 | 8 | Production Release | 14/wk | Play Store submission |

---

# Phase 1: Kotlin Fundamentals (Weeks 1–2)
*Goal: Comfortable with Kotlin syntax, feel like you own the language*

*Status: UNCHANGED from v1 — you've learned through Day 5 and it's good material.*

### Day 1–2: Variables, Types, and Null Safety

#### Concept 1: Variables and Basic Types

**Code First (Kotlin):**
```kotlin
val name = "Kitchen Command"
val age: Int = 25

var count = 0
count = 5

val price = 19.99
val isAvailable = true

val revenue: Double = 5000.50
val orderId: String = "ORD-001"
```

**Bridge to TypeScript:**
```typescript
const name = "Kitchen Command"  // val in Kotlin
let count = 0                    // var in Kotlin
count = 5
const name2: string = "Kitchen Command"
```

**Bridge to Python:**
```python
name = "Kitchen Command"
count = 0
count = 5
name2: str = "Kitchen Command"
```

**Key Difference:** Kotlin enforces types at compile time. Python/JavaScript don't.

---

#### Concept 2: Null Safety (THE Kotlin Superpower)

```kotlin
val name: String = "John"
// name = null  // COMPILE ERROR

val phoneNumber: String? = null
val email: String? = "john@kitchen.com"

if (phoneNumber != null) {
    println(phoneNumber.length)
}

val phone: String? = "5551234567"
if (phone != null) {
    println(phone.length)  // smart cast — no ?. needed
}

val length = phoneNumber?.length                  // safe call
val displayPhone = phoneNumber ?: "No phone"      // Elvis
val forced = phoneNumber!!.length                 // NPE if null — avoid
```

**Why This Matters:** Kotlin eliminates null pointer exceptions at compile time. This is HUGE for production apps.

---

#### Concept 3: String Templates

```kotlin
val name = "John"
val age = 30

val message = "Hello, $name"
val greeting = "Next year, $name will be ${age + 1} years old"

val json = """
    {
        "name": "$name",
        "age": $age
    }
""".trimIndent()
```

---

### Day 3–4: Functions and Lambdas

#### Concept 1: Functions

```kotlin
fun greet(name: String): String {
    return "Hello, $name"
}

fun add(a: Int, b: Int) = a + b                  // single-expression

fun printMessage(message: String) {              // Unit = void
    println(message)
}

fun createOrder(
    orderId: String,
    quantity: Int = 1,
    status: String = "pending"
) {
    println("Order $orderId: $quantity items, status: $status")
}

createOrder(orderId = "ORD-001", quantity = 5)   // named args
createOrder("ORD-002", status = "completed")
```

---

#### Concept 2: Lambda Functions

```kotlin
val double = { x: Int -> x * 2 }
println(double(5))                                // 10

val getMessage = { "Hello from Kitchen Command" }
val addNumbers = { a: Int, b: Int -> a + b }

fun processOrder(orders: List<String>, filter: (String) -> Boolean) {
    orders.forEach { order ->
        if (filter(order)) println("Processing: $order")
    }
}

val orders = listOf("ORD-001", "ORD-002", "ORD-003")
processOrder(orders) { it.contains("002") }       // trailing lambda + `it`

val prices = listOf(10, 20, 30)
val doubled = prices.map { it * 2 }               // [20, 40, 60]
val filtered = prices.filter { it > 15 }          // [20, 30]
```

---

### Day 5–6: Collections (List, Map, Set) — *YOU ARE HERE*

```kotlin
val numbers = listOf(1, 2, 3, 4, 5)
val mutableNumbers = mutableListOf(1, 2, 3)
mutableNumbers.add(4)

println(numbers[0]); println(numbers.first()); println(numbers.last())

numbers.forEach { num -> println(num) }
val doubled = numbers.map { it * 2 }
val evenNumbers = numbers.filter { it % 2 == 0 }
val firstEven = numbers.find { it % 2 == 0 }
val hasEven = numbers.any { it % 2 == 0 }
val allPositive = numbers.all { it > 0 }

val menu = mapOf(
    "pizza" to 12.99,
    "burger" to 8.99,
    "salad" to 6.99
)
println(menu["pizza"])
menu.forEach { (item, price) -> println("$item: $price") }
val cheapItems = menu.filter { (_, price) -> price < 10 }

val uniqueOrders = setOf("ORD-001", "ORD-002", "ORD-001")
println(uniqueOrders)  // {ORD-001, ORD-002}
```

---

### Day 7: Practice Day 1 — Restaurant Menu System

```kotlin
fun main() {
    val menu = mapOf(
        "pizza" to 12.99, "burger" to 8.99,
        "salad" to 6.99, "pasta" to 10.99
    )
    val customers = listOf(
        "Alice" to listOf("pizza", "salad"),
        "Bob" to listOf("burger", "burger"),
        "Charlie" to listOf("pasta", "pizza")
    )

    customers.forEach { (name, items) ->
        val total = items.map { menu[it] ?: 0.0 }.sum()
        println("$name ordered ${items.size} items: $${"%.2f".format(total)}")
    }

    val mostExpensive = menu.maxByOrNull { it.value }
    println("Most expensive: ${mostExpensive?.key} = $${mostExpensive?.value}")

    val avgPrice = menu.values.average()
    println("Average price: $${"%.2f".format(avgPrice)}")

    val discountedMenu = menu.mapValues { (_, price) -> price * 0.9 }
    println("Discounted menu: $discountedMenu")
}
```

**What You Learned:** variables, types, collections, lambdas, string templates, Elvis operator, stdlib functions (`map`, `sum`, `maxByOrNull`, `average`).

---

# Phase 2: Kotlin Intermediate (Weeks 3–4) — *NEW*
*Goal: Write idiomatic Kotlin. Bridge the gap between "syntax-works" and "code-looks-like-a-senior-wrote-it."*

### Day 8: Control Flow Deep Dive — `when`, Ranges, Loops

#### `when` — the upgraded switch

```kotlin
fun describeOrder(total: Double): String = when {
    total <= 0.0 -> "Invalid"
    total < 10.0 -> "Small"
    total < 50.0 -> "Medium"
    total < 200.0 -> "Large"
    else -> "Enterprise"
}

fun statusLabel(status: String) = when (status) {
    "pending" -> "Waiting"
    "paid", "confirmed" -> "Ready to cook"     // multiple values
    in listOf("cancelled", "refunded") -> "Dead"
    else -> "Unknown"
}

val x: Any = 42
val desc = when (x) {
    is Int -> "Number: $x"                      // smart-cast inside branch
    is String -> "Text of length ${x.length}"
    else -> "Something else"
}
```

`when` is an **expression** — it returns a value. Use it instead of chained `if/else if`.

#### Ranges and progressions

```kotlin
for (i in 1..10) print("$i ")            // 1 2 3 4 5 6 7 8 9 10
for (i in 1 until 10) print("$i ")       // 1..9 (exclusive)
for (i in 10 downTo 1) print("$i ")      // 10..1
for (i in 1..10 step 2) print("$i ")     // 1 3 5 7 9

val age = 25
if (age in 18..65) println("Working age")
```

#### Loops

```kotlin
val orders = listOf("A", "B", "C")
for (o in orders) println(o)
for ((index, o) in orders.withIndex()) println("$index: $o")

var i = 0
while (i < 3) { println(i); i++ }

orders.forEachIndexed { index, o -> println("$index: $o") }
```

---

### Day 9: Exception Handling

```kotlin
fun parsePrice(input: String): Double {
    return try {
        input.toDouble()
    } catch (e: NumberFormatException) {
        0.0
    }
}

fun parsePriceOrNull(input: String): Double? = input.toDoubleOrNull()

// Result / runCatching — idiomatic Kotlin error handling
val result: Result<Double> = runCatching { "12.99".toDouble() }
result
    .onSuccess { println("Parsed $it") }
    .onFailure { println("Failed: ${it.message}") }

val price = result.getOrDefault(0.0)
val priceOrThrow = result.getOrThrow()

// Custom exceptions
class InvalidOrderException(msg: String) : Exception(msg)

fun validateTotal(total: Double) {
    require(total > 0) { "Total must be positive, got $total" }
    check(total < 1_000_000) { "Total suspiciously large: $total" }
}
```

**Rules:**
- Use `toXOrNull()` instead of `try/catch` around `toX()` when possible.
- Use `runCatching { }` + `.onSuccess / .onFailure` for functional-style error handling.
- Use `require` for **argument validation**, `check` for **state validation**.
- Create typed exceptions — never throw generic `Exception` in your own code.

---

### Day 10–11: Scope Functions (`let`, `run`, `apply`, `also`, `with`)

These are the 5 functions that separate tourist-Kotlin from native-Kotlin. Master them.

| Function | Receiver | Returns | Typical Use |
|---|---|---|---|
| `let` | `it` | lambda result | null-check + transform |
| `run` | `this` | lambda result | compute with object context |
| `apply` | `this` | the object | configure/build an object |
| `also` | `it` | the object | side effects (logging) |
| `with` | `this` | lambda result | group calls on one object |

```kotlin
val name: String? = "Kitchen"

name?.let { println("Name is $it, length ${it.length}") }

val result = "5".run { toInt() * 2 }          // 10

val user = User().apply {
    name = "Alice"
    age = 30
    email = "alice@kitchen.com"
}                                              // returns the configured User

val list = mutableListOf(1, 2, 3).also {
    println("Before add: $it")
}.apply {
    add(4)
}

with(user) {
    println(name)
    println(age)
}
```

**Decision tree:**
- Need null safety? → `?.let { }`
- Building/configuring an object? → `apply { }`
- Side effect (log/debug) on a chain? → `also { }`
- Need a transformed result? → `let { }` or `run { }`
- Grouping calls on an existing object? → `with(obj) { }`

---

### Day 12: Classes, Constructors, Visibility

```kotlin
class Restaurant(
    val name: String,                          // public by default
    private var internalRating: Double,        // private
    internal val regionCode: String            // module-private
) {
    var publicFlag: Boolean = false
        private set                             // read-public, write-private

    protected open val slug: String = name.lowercase()

    init {
        require(name.isNotBlank()) { "Name required" }
    }

    constructor(name: String) : this(name, 0.0, "US")   // secondary ctor
}
```

**Visibility modifiers:**
- `public` (default) — everywhere
- `private` — same file or same class
- `internal` — same Gradle module
- `protected` — class + subclasses (no file-level)

---

### Day 13: Practice — Refactor Day 7 with Intermediate Kotlin

Take your Day 7 Restaurant Menu System and refactor it:
1. Replace the `if/else` in discount logic with a `when` expression.
2. Use `apply` to build the menu map.
3. Use `?.let` to guard nullable lookups.
4. Wrap the entire main in `runCatching` and print typed errors.
5. Introduce at least one `private` helper function.

**Deliverable:** same output, fewer lines, cleaner intent.

---

### Day 14: Checkpoint Week 4

**Self-test:**
- [ ] Can you explain the difference between `let` and `also` without looking?
- [ ] Can you write a `when` that smart-casts on `Any`?
- [ ] Can you use `runCatching` to replace a try/catch?
- [ ] Do you know when to use `require` vs `check`?

---

# Phase 3: OOP & Type System (Weeks 5–6) — *EXPANDED*
*Goal: Model a domain correctly. Prefer types over comments.*

### Day 15: Inheritance & Abstract Classes

```kotlin
abstract class Food(val name: String, val price: Double) {
    abstract fun description(): String          // must be overridden
    open fun category(): String = "Generic"     // can be overridden
    fun priceLabel() = "$${"%.2f".format(price)}"  // final
}

class Burger(name: String, price: Double, val hasTopping: Boolean)
    : Food(name, price) {
    override fun description() = "$name (topping: $hasTopping)"
    override fun category() = "Fast Food"
}
```

**Rules:**
- Kotlin classes are `final` by default. Use `open` to allow inheritance.
- Same for methods/properties.
- `abstract` = no implementation, subclass **must** provide one.
- Prefer composition over inheritance unless you have a real "is-a" relationship.

---

### Day 16: Interfaces + Interface Delegation

```kotlin
interface Orderable {
    fun addToCart()
    fun calculatePrice(): Double
}

interface Printable {
    fun print() = println("Printing...")         // default impl
}

class MenuItem(val name: String, val price: Double) : Orderable, Printable {
    override fun addToCart() = println("Added $name")
    override fun calculatePrice() = price
}

// Interface delegation — Kotlin superpower
class LoggedList<T>(private val list: MutableList<T>) : MutableList<T> by list {
    override fun add(element: T): Boolean {
        println("Adding: $element")
        return list.add(element)
    }
}
```

`by list` means "delegate all `MutableList` methods to `list`." You only override what you want to customize. No more writing 20 boilerplate forwarding methods.

---

### Day 17: Data Classes, Enums, Sealed Classes

```kotlin
data class User(val id: Int, val name: String, val email: String)
// auto-generates equals, hashCode, toString, copy, componentN

val u1 = User(1, "Alice", "a@k.com")
val u2 = u1.copy(name = "Alicia")
val (id, name, email) = u1                     // destructuring

enum class OrderStatus(val label: String) {
    PENDING("Waiting"),
    PAID("Paid"),
    SHIPPED("On the way"),
    CANCELLED("Cancelled"),
    REJECTED("Rejected");

    fun isTerminal(): Boolean = this == CANCELLED || this == SHIPPED
}

// SEALED — the killer feature for state modeling
sealed class ApiResponse {
    data class Success(val id: String, val total: Double) : ApiResponse()
    sealed class Error : ApiResponse() {
        object InvalidTotal : Error()
        object OrderRejected : Error()
        data class Network(val code: Int) : Error()
        data class Unknown(val message: String) : Error()
    }
}

fun handle(resp: ApiResponse) = when (resp) {      // exhaustive!
    is ApiResponse.Success -> "OK: ${resp.id}"
    is ApiResponse.Error.InvalidTotal -> "Bad total"
    is ApiResponse.Error.OrderRejected -> "Rejected"
    is ApiResponse.Error.Network -> "Net ${resp.code}"
    is ApiResponse.Error.Unknown -> "? ${resp.message}"
}
```

**Why sealed classes beat strings:**
- Compiler forces you to handle every case (exhaustiveness).
- Refactor-safe: add a new subclass → compiler tells you every `when` that needs updating.
- Replaces "stringly-typed" APIs with type-safe ones.

---

### Day 18: Companion Objects, `object`, Factory Methods

```kotlin
class Order private constructor(
    val id: String,
    var total: Double,
    var status: OrderStatus = OrderStatus.PENDING
) {
    fun addCharge(amount: Double) {
        require(amount > 0) { "Amount must be positive" }
        total += amount
    }

    fun applyDiscount(pct: Double) {
        require(pct in 0.0..100.0) { "Discount 0-100, got $pct" }
        total *= (1 - pct / 100)
    }

    companion object {
        private var ordersCreated = 0
        var dailyRevenue: Double = 0.0
            private set

        fun create(initialTotal: Double): Order {
            require(initialTotal > 0) { "Total must be positive" }
            ordersCreated++
            dailyRevenue += initialTotal
            return Order("order-$ordersCreated", initialTotal)
        }

        fun resetDaily() { dailyRevenue = 0.0 }
    }
}

// Top-level singleton
object ApiConfig {
    const val URL_PATH = "https://api.day5.com"
    const val TIMEOUT = 30
}
```

**Rules of thumb:**
- `object` (top-level) = singleton. Use for **stateless constants/utilities**.
- `companion object` = class-level "static" members. Use for **factory methods**.
- Make constructors `private` + force factory creation when you need to enforce invariants (unique IDs, counters).
- If something takes a network/DB dependency, **don't** make it an `object`. Make it a class and inject it.

---

### Day 19: Extension Functions + Generics Basics

```kotlin
fun String.isValidEmail(): Boolean = contains("@") && contains(".")

fun Double.formatCurrency(): String = "$${"%.2f".format(this)}"

fun <T> List<T>.second(): T? = if (size >= 2) this[1] else null

fun <T : Comparable<T>> List<T>.top3(): List<T> = sortedDescending().take(3)

// Generic class
class Box<T>(val value: T) {
    fun <R> map(transform: (T) -> R): Box<R> = Box(transform(value))
}

// Variance (brief intro; revisit later)
interface Producer<out T> { fun produce(): T }      // covariant
interface Consumer<in T> { fun consume(t: T) }      // contravariant
```

**When to write an extension:**
- Adding a helper to a class you don't own (e.g., `String`, `List`).
- Replacing utility classes like `StringUtils`.
- Don't overuse — if it belongs to your own class, make it a member.

---

### Day 20: Testing — Your First Tests (JUnit 5)

Add to `build.gradle.kts` (Kotlin-only project, Weeks 5–8):
```kotlin
dependencies {
    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.11.0")
}
tasks.test { useJUnitPlatform() }
```
For the Android project (Week 9+), you'll add `androidx.test` + `compose-ui-test` as well. The `kotlin("test")` assertions work everywhere.

`src/test/kotlin/OrderTest.kt`:
```kotlin
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class OrderTest {
    @Test
    fun `create order with positive total works`() {
        val order = Order.create(100.0)
        assertEquals(100.0, order.total)
        assertEquals(OrderStatus.PENDING, order.status)
    }

    @Test
    fun `create order with zero total fails`() {
        assertFailsWith<IllegalArgumentException> { Order.create(0.0) }
    }

    @Test
    fun `applyDiscount above 100 fails`() {
        val o = Order.create(100.0)
        assertFailsWith<IllegalArgumentException> { o.applyDiscount(150.0) }
    }
}
```

**Rules:**
- Test names describe behavior in English: backticks allow spaces.
- One assertion concept per test.
- Test the **boundary** (zero, negative, max) — that's where bugs live.

---

### Day 21: Practice — Typed Domain Model

Build an `OrderService` with:
1. `sealed class OrderResult` with `Success`, `InvalidTotal`, `AlreadyProcessed` variants.
2. `Order` data class with private setters for `status` and `total`.
3. `OrderService.process(order)` returns an `OrderResult`.
4. At least 6 tests covering happy path + every error branch.

---

# Phase 4: Advanced Kotlin — Coroutines & Flow (Weeks 7–8) — *NEW*
*Goal: Write async code without callback hell. Understand structured concurrency.*

### Day 22: Why Coroutines?

The problem: blocking a thread for an HTTP call wastes CPU. The old solution was callbacks (`onSuccess`, `onFailure`) which nest deeper every time. Kotlin coroutines let you write sequential-looking code that actually runs asynchronously.

Add dependency (Kotlin-only project; you'll use `kotlinx-coroutines-android` in Phase 5):
```kotlin
implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.1")
```

```kotlin
import kotlinx.coroutines.*

suspend fun fetchUser(id: Int): String {
    delay(500)                                  // non-blocking "pretend I/O"
    return "User-$id"
}

fun main() = runBlocking {
    val user = fetchUser(1)
    println(user)
}
```

`suspend` = a function that can pause and resume. Can only be called from another `suspend` function or a coroutine builder.

---

### Day 23: `launch` vs `async`, Dispatchers

```kotlin
fun main() = runBlocking {
    val job = launch {                          // fire-and-forget
        delay(1000)
        println("Background work done")
    }

    val deferred = async {                      // returns a result
        delay(500)
        42
    }

    println("Answer = ${deferred.await()}")
    job.join()
}

suspend fun parallel() = coroutineScope {
    val a = async { fetchUser(1) }
    val b = async { fetchUser(2) }
    listOf(a.await(), b.await())                // both run concurrently
}
```

**Dispatchers:**
- `Dispatchers.Main` — Android UI thread
- `Dispatchers.IO` — network, disk
- `Dispatchers.Default` — CPU-bound work
- `Dispatchers.Unconfined` — rarely use

```kotlin
withContext(Dispatchers.IO) { fetchFromDisk() }
```

---

### Day 24: Structured Concurrency

The rule: **coroutines outlive no scope**. When a scope is cancelled, all children are cancelled.

```kotlin
suspend fun loadDashboard() = coroutineScope {
    val profile = async { fetchProfile() }
    val orders = async { fetchOrders() }
    val notifications = async { fetchNotifications() }
    Dashboard(profile.await(), orders.await(), notifications.await())
}
// if ANY of the three throws, the others get cancelled — no leaks
```

Exception handling:
```kotlin
val scope = CoroutineScope(SupervisorJob() + Dispatchers.Default)

scope.launch(CoroutineExceptionHandler { _, e ->
    println("Caught: ${e.message}")
}) {
    throw RuntimeException("boom")
}
```

---

### Day 25: Flow — Cold Async Streams

```kotlin
import kotlinx.coroutines.flow.*

fun orderIdsFlow(): Flow<String> = flow {
    for (i in 1..5) {
        delay(300)
        emit("ORD-$i")
    }
}

fun main() = runBlocking {
    orderIdsFlow()
        .filter { it.endsWith("3").not() }
        .map { "Processing $it" }
        .collect { println(it) }
}
```

Flow is a **cold** stream: nothing happens until you `.collect { }`. Operators (`map`, `filter`, `debounce`, etc.) are chainable like collections but async-aware.

---

### Day 26: StateFlow and SharedFlow

```kotlin
class OrdersRepository {
    private val _orders = MutableStateFlow<List<Order>>(emptyList())
    val orders: StateFlow<List<Order>> = _orders.asStateFlow()

    suspend fun addOrder(order: Order) {
        _orders.value = _orders.value + order
    }
}
```

- **StateFlow** = always has a value, like an observable variable. Perfect for UI state.
- **SharedFlow** = hot stream with configurable buffering. Perfect for one-shot events (navigate, show toast).

---

### Day 27: Practice — Async Order Processor

Build:
1. A `Flow<OrderEvent>` that emits events every 500ms.
2. A processor coroutine that collects events, validates via your `OrderService`, and updates a `StateFlow<List<Order>>`.
3. A second coroutine that "watches" the StateFlow and prints changes.
4. Cancellation handling — stop gracefully when the user types `quit`.

**Deliverable:** terminal app demonstrating concurrent producers/consumers with structured concurrency.

---

### Day 28: Checkpoint Week 8

**Self-test:**
- [ ] Explain `launch` vs `async`.
- [ ] Why is Flow "cold"?
- [ ] Difference between `StateFlow` and `SharedFlow`?
- [ ] What happens if a child coroutine throws in `coroutineScope`?

---

# Phase 5: Android with Jetpack Compose (Weeks 9–10) — *REPLACED*
*Goal: Build UI in Compose. State management before screens.*

### Day 29: Android Project Anatomy + Gradle

**⚠️ Switch IDE here:** Install **Android Studio** (latest Ladybug or newer) alongside your IDEA Ultimate. Open Android Studio, create a new project: **Empty Activity** (this is already Compose-based in modern templates).

**Key files:**
- `app/build.gradle.kts` — dependencies, SDK versions, plugins
- `settings.gradle.kts` — module/plugin declarations
- `AndroidManifest.xml` — permissions, activities, app metadata
- `MainActivity.kt` — entry point
- `gradle/libs.versions.toml` — version catalog (modern, preferred)

**`libs.versions.toml` (version catalog — modern approach):**
```toml
[versions]
kotlin = "2.3.20"
agp = "8.10.0"
composeBom = "2026.03.00"
activityCompose = "1.13.0"
lifecycle = "2.10.0"
navigationCompose = "2.9.7"
hilt = "2.59.2"
room = "2.8.4"
retrofit = "3.0.0"
kotlinxSerialization = "1.8.0"
kotlinxCoroutines = "1.10.1"
ksp = "2.3.20-1.0.28"

[libraries]
compose-bom = { module = "androidx.compose:compose-bom", version.ref = "composeBom" }
compose-ui = { module = "androidx.compose.ui:ui" }
compose-ui-tooling = { module = "androidx.compose.ui:ui-tooling" }
compose-ui-tooling-preview = { module = "androidx.compose.ui:ui-tooling-preview" }
compose-material3 = { module = "androidx.compose.material3:material3" }
activity-compose = { module = "androidx.activity:activity-compose", version.ref = "activityCompose" }
lifecycle-viewmodel-compose = { module = "androidx.lifecycle:lifecycle-viewmodel-compose", version.ref = "lifecycle" }
lifecycle-runtime-compose = { module = "androidx.lifecycle:lifecycle-runtime-compose", version.ref = "lifecycle" }
navigation-compose = { module = "androidx.navigation:navigation-compose", version.ref = "navigationCompose" }
hilt-android = { module = "com.google.dagger:hilt-android", version.ref = "hilt" }
hilt-compiler = { module = "com.google.dagger:hilt-compiler", version.ref = "hilt" }
hilt-navigation-compose = { module = "androidx.hilt:hilt-navigation-compose", version = "1.2.0" }
room-runtime = { module = "androidx.room:room-runtime", version.ref = "room" }
room-ktx = { module = "androidx.room:room-ktx", version.ref = "room" }
room-compiler = { module = "androidx.room:room-compiler", version.ref = "room" }
retrofit = { module = "com.squareup.retrofit2:retrofit", version.ref = "retrofit" }
retrofit-kotlinx-serialization = { module = "com.squareup.retrofit2:converter-kotlinx-serialization", version.ref = "retrofit" }
kotlinx-serialization-json = { module = "org.jetbrains.kotlinx:kotlinx-serialization-json", version.ref = "kotlinxSerialization" }
kotlinx-coroutines-android = { module = "org.jetbrains.kotlinx:kotlinx-coroutines-android", version.ref = "kotlinxCoroutines" }
```

**`app/build.gradle.kts`:**
```kotlin
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)
}

android {
    namespace = "com.kitchen.command"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.kitchen.command"
        minSdk = 26
        targetSdk = 36
        versionCode = 1
        versionName = "0.1.0"
    }

    buildFeatures { compose = true }
    kotlinOptions { jvmTarget = "17" }
}

dependencies {
    implementation(platform(libs.compose.bom))
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.compose.material3)
    implementation(libs.activity.compose)
    implementation(libs.lifecycle.viewmodel.compose)
    implementation(libs.lifecycle.runtime.compose)
    implementation(libs.navigation.compose)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.serialization.json)

    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
    implementation(libs.hilt.navigation.compose)

    implementation(libs.room.runtime)
    implementation(libs.room.ktx)
    ksp(libs.room.compiler)

    implementation(libs.retrofit)
    implementation(libs.retrofit.kotlinx.serialization)

    debugImplementation(libs.compose.ui.tooling)
}
```

**Why KSP, not KAPT:** KSP is 2× faster, Kotlin-native, and **required** for Room 3.0 (in alpha). Starting with KSP means no migration pain later.

**Heads up on Room 3.0 (alpha, March 2026):** Google is modernizing Room. New namespace is `androidx.room3:room3-*`, Kotlin-only code gen, KSP-only, coroutines-first. **For this roadmap, stick with stable 2.8.4.** When 3.0 hits stable (~Q3 2026 estimate), migration is straightforward if your DAOs are already `suspend`-based.

---

### Day 30: First Compose UI

```kotlin
@Composable
fun Greeting(name: String) {
    Text(text = "Hello, $name!")
}

@Composable
fun OrderCard(order: Order) {
    Card(modifier = Modifier.padding(8.dp)) {
        Column(Modifier.padding(16.dp)) {
            Text(order.id, style = MaterialTheme.typography.titleLarge)
            Text("Total: $${order.total}")
            Text("Status: ${order.status}")
        }
    }
}

@Composable
fun OrderList(orders: List<Order>) {
    LazyColumn {
        items(orders) { order -> OrderCard(order) }
    }
}

@Preview
@Composable
fun Preview() {
    OrderList(listOf(/* fake data */))
}
```

**Core composables:** `Text`, `Button`, `Column`, `Row`, `Box`, `LazyColumn`, `LazyRow`, `Card`, `Image`, `Scaffold`, `TopAppBar`.

---

### Day 31: State in Compose — `remember`, `mutableStateOf`, Hoisting

```kotlin
@Composable
fun Counter() {
    var count by remember { mutableStateOf(0) }
    Button(onClick = { count++ }) { Text("Count: $count") }
}

// State hoisting — parent owns state
@Composable
fun CounterStateless(count: Int, onIncrement: () -> Unit) {
    Button(onClick = onIncrement) { Text("Count: $count") }
}

@Composable
fun CounterScreen() {
    var count by remember { mutableStateOf(0) }
    CounterStateless(count, onIncrement = { count++ })
}
```

**Rule:** hoist state to the lowest common ancestor that needs it. Stateless composables are easier to test and reuse.

---

### Day 32: Navigation Compose

```kotlin
@Composable
fun AppNav() {
    val nav = rememberNavController()
    NavHost(nav, startDestination = "list") {
        composable("list") {
            OrderListScreen(onOrderClick = { id -> nav.navigate("detail/$id") })
        }
        composable("detail/{id}") { backStack ->
            val id = backStack.arguments?.getString("id") ?: return@composable
            OrderDetailScreen(id)
        }
    }
}
```

---

### Day 33: Layouts, Theming, Material 3

- `Scaffold { TopAppBar, BottomBar, FAB, content }`
- `Modifier` chain: `Modifier.padding(8.dp).fillMaxWidth().clickable { }`
- `MaterialTheme.colorScheme`, `MaterialTheme.typography`

---

### Day 34: Practice — 3-Screen Compose App

Screens: **Menu List → Menu Detail → Cart**. State hoisted to the nav graph's ViewModel (introduced next phase).

---

# Phase 6: Architecture & Data (Weeks 11–12) — *NEW*
*Goal: Structure the app so it stays maintainable.*

### Day 35: MVVM + ViewModel + StateFlow

```kotlin
class MenuViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(MenuUiState())
    val uiState: StateFlow<MenuUiState> = _uiState.asStateFlow()

    init {
        loadMenu()
    }

    private fun loadMenu() = viewModelScope.launch {
        _uiState.update { it.copy(loading = true) }
        val items = repository.getMenu()         // suspend
        _uiState.update { it.copy(loading = false, items = items) }
    }
}

data class MenuUiState(
    val loading: Boolean = false,
    val items: List<MenuItem> = emptyList(),
    val error: String? = null
)

@Composable
fun MenuScreen(vm: MenuViewModel = viewModel()) {
    val state by vm.uiState.collectAsStateWithLifecycle()
    when {
        state.loading -> CircularProgressIndicator()
        state.error != null -> Text("Error: ${state.error}")
        else -> MenuList(state.items)
    }
}
```

---

### Day 36: Dependency Injection with Hilt

Dependencies already declared in your `libs.versions.toml` (Hilt 2.59.2). Make sure `AndroidManifest.xml` has:
```xml
<application android:name=".KitchenApp" ... />
```

```kotlin
@HiltAndroidApp
class KitchenApp : Application()

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides @Singleton
    fun provideJson(): Json = Json {
        ignoreUnknownKeys = true
        isLenient = true
    }

    @Provides @Singleton
    fun provideRetrofit(json: Json): Retrofit = Retrofit.Builder()
        .baseUrl("https://api.kitchen.com/")
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .build()

    @Provides @Singleton
    fun provideApi(retrofit: Retrofit): KitchenApi = retrofit.create()
}

@HiltViewModel
class MenuViewModel @Inject constructor(
    private val repository: MenuRepository
) : ViewModel() { /* ... */ }
```

In your Compose screens:
```kotlin
@Composable
fun MenuScreen(vm: MenuViewModel = hiltViewModel()) {
    val state by vm.uiState.collectAsStateWithLifecycle()
    /* ... */
}
```

**Why Hilt:** the ViewModel no longer knows how to build its dependencies. Test by injecting fakes. No global singletons polluting your code.

---

### Day 37: Retrofit + Kotlinx Serialization

```kotlin
@Serializable
data class MenuItemDto(val id: String, val name: String, val price: Double)

interface KitchenApi {
    @GET("menu") suspend fun getMenu(): List<MenuItemDto>
    @POST("orders") suspend fun createOrder(@Body req: OrderRequest): OrderResponse
}
```

---

### Day 38: Room Database

```kotlin
@Entity(tableName = "menu_items")
data class MenuItemEntity(
    @PrimaryKey val id: String,
    val name: String,
    val price: Double
)

@Dao
interface MenuDao {
    @Query("SELECT * FROM menu_items") fun observeAll(): Flow<List<MenuItemEntity>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertAll(items: List<MenuItemEntity>)
}

@Database(entities = [MenuItemEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun menuDao(): MenuDao
}
```

---

### Day 39: Repository Pattern (tying it together)

```kotlin
class MenuRepository @Inject constructor(
    private val api: KitchenApi,
    private val dao: MenuDao
) {
    fun observeMenu(): Flow<List<MenuItem>> = dao.observeAll().map { list ->
        list.map { it.toDomain() }
    }

    suspend fun refresh() {
        val remote = api.getMenu()
        dao.upsertAll(remote.map { it.toEntity() })
    }
}
```

Single-source-of-truth pattern: UI observes DB, repository refreshes DB from API.

---

### Day 40: Practice — Menu Screen, Real API, Cached

Build the real thing against a mock API (use `https://jsonplaceholder.typicode.com` or a local Ktor mock):
1. Compose screen observes `MenuViewModel`.
2. `MenuViewModel` observes `MenuRepository`.
3. Repository pulls from Retrofit + caches to Room.
4. Swipe-to-refresh triggers `repository.refresh()`.
5. Works offline.

---

# Phase 7: Real App Building (Weeks 13–16)

### Week 13: Auth & Login
- Login screen + form validation
- DataStore for secure token storage
- Retrofit `Authenticator` for auto-refresh
- Logout flow

### Week 14: Kitchen Command MVP v0.1 (the real one)
- Restaurant selection screen
- Table/Order management screens
- Create/edit order
- Submit order to backend
- **This is where it all comes together.** No new concepts — just integrate.

### Week 15: WebSockets & Realtime
- Add OkHttp WebSocket or Ktor client
- Observe order status changes
- Push updates to UI via StateFlow
- Reconnect logic with exponential backoff

### Week 16: Offline & Error Handling
- Queue outbound actions when offline
- Sync on reconnect
- User-visible error states (snackbars, retry buttons)
- Loading shimmer effects

---

# Phase 8: Hardware & Production (Weeks 17–20) — *EXPANDED*

### Week 17: Bluetooth + Printer Integration
- Android Bluetooth permissions (runtime for 12+)
- Scan, pair, connect flow
- ESC/POS protocol basics for thermal printers
- Print a test receipt
- Graceful disconnect + retry

### Week 18: Testing Deep Dive
- Unit tests: ViewModels, repositories, use cases
- Fakes over mocks (prefer hand-written test doubles)
- Compose UI tests: `composeTestRule`, `onNodeWithText`
- Integration: Room in-memory DB
- Aim: 70%+ coverage on domain + viewmodel layer (UI less important)

### Week 19: Performance & Polish
- Android Studio Profiler — CPU, memory, network
- Recomposition debugging (`Modifier.composed`, layout inspector)
- `LaunchedEffect` vs `remember` traps
- `Stable`/`Immutable` annotations for Compose
- R8/ProGuard rules if needed

### Week 20: Production Release
- Signed release build
- `versionCode` / `versionName` strategy
- Crashlytics (or Sentry) setup
- Play Store listing: screenshots, privacy policy, content rating
- Internal testing track → closed beta → production

---

# Optional C Sidebar

*Dropped from the main track. Use ONLY if you have extra hours AND a specific reason (embedded work, interview-specific, curiosity).*

If you still want to keep C alive, do **1 hour/week max**, on one of these:
- Finish linked list + binary tree from v1
- One Leetcode-style problem in C per week
- Interrupt projects only if they're unblocking something else

**Do not let C eat into Kotlin hours.** Your goal is to ship an Android app.

---

# Active Django Sundays

*Replacement for the passive "read your code" model.*

Each Sunday, pick **one** of these active challenges (30–60 min):

| Week | Active Challenge |
|---|---|
| 1 | Add a `DELETE /api/orders/{id}/` endpoint. Write a test. |
| 2 | Add pagination to `OrderViewSet` using DRF's `PageNumberPagination`. |
| 3 | Add a filter: `GET /api/orders/?status=pending`. |
| 4 | Add a custom action `@action(detail=True) def refund(...)`. |
| 5 | Add a signal that logs when an order is created. |
| 6 | Write a Celery task that sends an email receipt 5 min after order creation. |
| 7 | Add a WebSocket consumer that pushes order status updates. |
| 8 | Profile one slow endpoint with `django-silk`; optimize one N+1. |
| 9 | Add permissions: only the restaurant owner can edit their orders. |
| 10 | Refactor one serializer to use `SerializerMethodField` for a computed field. |
| 11 | Add rate limiting to the login endpoint. |
| 12+ | You decide. Whatever's broken in your backend, fix one thing per Sunday. |

**Rule:** every Sunday ends with a commit. No commit = you didn't learn it.

---

# Assessment Checkpoints

## Week 2 — Fundamentals
- [ ] Use `?.`, `?:`, smart casts fluently
- [ ] Filter/map/reduce collections without looking things up
- [ ] String templates feel natural
- [ ] Write + call lambdas with `it` and named params

**Mini-challenge:** Given `listOf(Order)`, return the top 3 orders by total, formatted as `"ID: $TOTAL"`.

## Week 4 — Intermediate Kotlin
- [ ] Can pick the right scope function (`let`/`apply`/`also`/`run`/`with`) without thinking
- [ ] `when` expressions with smart cast
- [ ] `runCatching` + `Result` instead of try/catch where appropriate
- [ ] Visibility modifiers used intentionally

**Mini-challenge:** Refactor Day 7 project. Target: 30% fewer lines, zero `if/else` chains.

## Week 6 — OOP & Types
- [ ] Sealed classes for state modeling
- [ ] Data classes only where they make sense (no mutable data-class pitfalls)
- [ ] Private constructors + factory for invariants
- [ ] 6+ passing JUnit tests on domain logic

**Mini-challenge:** Model `OrderResult` as a sealed hierarchy. Write tests for every variant.

## Week 8 — Coroutines & Flow
- [ ] Can explain structured concurrency
- [ ] Write a `Flow` producer + collector
- [ ] Use `StateFlow` for observable state
- [ ] Handle cancellation correctly

**Mini-challenge:** Terminal app: concurrent producer + consumer + cancel on user input.

## Week 10 — Compose UI
- [ ] Stateless + stateful composables
- [ ] State hoisting understood
- [ ] LazyColumn with clickable items
- [ ] Basic Material 3 theming

**Mini-challenge:** 3-screen Compose app with Nav, no ViewModel yet.

## Week 12 — Architecture & Data
- [ ] ViewModel + StateFlow wired to Compose
- [ ] Hilt-injected repository
- [ ] Retrofit + Room in single-source-of-truth pattern

**Mini-challenge:** Menu screen: real API → Room cache → Compose UI. Works offline.

## Week 14 — MVP v0.1
- [ ] Full auth flow
- [ ] Create/view/edit order
- [ ] Connected to your Django backend

## Week 16 — MVP v0.2
- [ ] WebSocket realtime updates
- [ ] Offline queueing
- [ ] All error states handled visually

## Week 18 — Testing
- [ ] 70%+ coverage on domain + VM
- [ ] Compose UI tests for 2+ critical screens
- [ ] Instrumentation test for Room DAO

## Week 20 — Production
- [ ] Signed release APK/AAB
- [ ] Crash reporting integrated
- [ ] Play Store internal track submitted
- [ ] No detectable memory leaks (LeakCanary clean on happy path)

---

# Study Tips & Resources

## Learning Optimization
1. **Code-first:** write before reading explanations.
2. **Daily deliverable:** every session ends with runnable code.
3. **Weekly review (Saturday, 1 hr):** re-read Monday's notes, re-run Monday's code.
4. **Spaced repetition:** at week N, re-open week N-2's project and extend it.
5. **Explain out loud:** teach the day's concept to an imaginary junior. If you can't, you don't know it.

## Resources (bookmarked, in priority order)

**Official docs (always up-to-date):**
- **Kotlin Official Docs:** https://kotlinlang.org/docs/home.html
- **What's new in Kotlin 2.3.20:** https://kotlinlang.org/docs/whatsnew2320.html
- **Jetpack Compose Docs:** https://developer.android.com/jetpack/compose/documentation
- **Compose BOM → library mapping:** https://developer.android.com/develop/ui/compose/bom/bom-mapping
- **Kotlin Coroutines Guide:** https://kotlinlang.org/docs/coroutines-guide.html

**Reference codebases (read these weekly):**
- **Now in Android (canonical sample):** https://github.com/android/nowinandroid
- **Android Samples:** https://github.com/android/compose-samples
- **Android Architecture Guide:** https://developer.android.com/topic/architecture

**Learning paths:**
- **Android Basics with Compose (free course):** https://developer.android.com/courses/android-basics-compose/course
- **Kotlin Playground:** https://play.kotlinlang.org/

**Tools & backends for prototyping:**
- **Ktor (Kotlin server):** https://ktor.io/
- **JSONPlaceholder (fake REST API):** https://jsonplaceholder.typicode.com/
- **Reqres (fake auth API):** https://reqres.in/

## IDE Shortcuts (IDEA Ultimate & Android Studio share these)
- `Shift+Shift` — Search Everywhere
- `Ctrl+B` (Cmd+B) — Go to declaration
- `Ctrl+Alt+L` — Reformat
- `Alt+Enter` — Quick fix
- `Ctrl+Shift+F10` — Run current file
- `Shift+F6` — Rename

## Building Momentum (honest expectations)
- **Weeks 1–4:** Feels manageable. Kotlin reads like TypeScript with extras.
- **Weeks 5–6:** OOP + types click. Your code looks like real Kotlin.
- **Weeks 7–8:** Coroutines are confusing for 4 days, then it clicks. Push through.
- **Weeks 9–10:** Compose is MAGIC. You'll be building UIs faster than you expected.
- **Weeks 11–12:** Most frustrating phase — lots of moving parts (Hilt, Retrofit, Room). Expect 2 hours debugging config for every 1 hour of real code.
- **Weeks 13–14:** Momentum peaks. You're shipping features.
- **Weeks 15–16:** Edge cases and error handling. Less fun, more important.
- **Weeks 17–20:** Hardware + polish. You'll feel like a real Android dev.

---

**Total Time Investment:** 5 months to production-ready
**Time to Job-Ready Kotlin/Android:** 4 months (end of Week 16)
**Time to Kitchen Command Mobile shipping:** 5 months (end of Week 20)

This roadmap is your blueprint. It's designed to be **sustainable**, not heroic. Follow it at the pace it's designed for. 12–15 hours a week, every week, for 5 months will get you farther than 30-hour weeks for 6 weeks and burnout.

Don't skip phases. Don't skip the checkpoints. Don't skip the tests.

Good luck. Ship something real.
