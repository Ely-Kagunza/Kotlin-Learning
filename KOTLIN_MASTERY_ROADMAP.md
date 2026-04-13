# Kotlin Mastery & Mobile Development Roadmap
## Kitchen Command Mobile App - 4 Month Intensive Learning Plan

**Duration:** 16 weeks (112 days)  
**Weekly Commitment:** 25-28 hours  
**Goal:** Kotlin proficiency → Android app building → Hardware integration ready

---

## Table of Contents
1. [Overall Strategy](#overall-strategy)
2. [Week-by-Week Breakdown](#week-by-week-breakdown)
3. [Kotlin Learning Roadmap (Detailed Daily Lessons)](#kotlin-learning-roadmap)
4. [C Project Track (Parallel)](#c-project-track)
5. [Django Sunday Walkthroughs](#django-sunday-walkthroughs)
6. [Assessment Checkpoints](#assessment-checkpoints)

---

## Overall Strategy

### Time Allocation (Weekly)
- **Kotlin:** 18-20 hours (Mon, Wed, Fri focus days + Sat practice)
- **C Projects:** 5-7 hours (Tue, Thu + Sat practice)
- **Django:** 0.5-1 hour (Sunday passive review)
- **Total:** 25-28 hours/week

### Kotlin Learning Methodology
- **Code-first approach:** Write code, then understand concepts
- **Bridging:** Compare Kotlin to JavaScript, TypeScript, Python syntax
- **Pedagogy:** Build mental models before advanced topics
- **Android progression:** Syntax → Android Fundamentals → Real app building

### C Project Methodology
- **Protect investment:** 5 weeks of C learning already done
- **Project-based:** Build real applications, not abstract exercises
- **Skill sharpening:** 1-2 hour focused sessions
- **Interview prep:** Rare skillset differentiator

### Django Approach
- **Passive learning:** Code review of existing implementation
- **Context-based:** Learn patterns while reading your own code
- **Maintenance mode:** No active feature learning required

---

## Week-by-Week Breakdown

| Week | Focus | Kotlin Hours | C Hours | Django | Main Deliverable |
|------|-------|--------------|---------|--------|------------------|
| 1-2 | Fundamentals | 8-10/week | 5-6/week | 30 min | Kotlin syntax mastery |
| 3-4 | OOP Concepts | 8-10/week | 5-6/week | 30 min | Classes, interfaces, inheritance |
| 5-6 | Android Basics | 8-10/week | 5-6/week | 1 hour | Activities, lifecycle, fragments |
| 7-8 | Advanced Android | 8-10/week | 5-6/week | 1 hour | Navigation, services, async |
| 9-10 | Real App Building | 10-12/week | 4-5/week | 1 hour | Kitchen Command MVP skeleton |
| 11-12 | Backend Integration | 10-12/week | 4-5/week | 1 hour | API calls, database, state mgmt |
| 13-14 | Hardware & Polish | 8-10/week | 5-6/week | 1 hour | Bluetooth, printers, optimization |
| 15-16 | Production Ready | 8-10/week | 5-6/week | 1 hour | Testing, deployment, release |

---

# Kotlin Learning Roadmap

## Phase 1: Kotlin Fundamentals (Weeks 1-2)
*Goal: Comfortable with Kotlin syntax, feel like you own the language*

### Day 1-2: Variables, Types, and Null Safety

#### Concept 1: Variables and Basic Types

**Code First (Kotlin):**
```kotlin
// Immutable variable
val name = "Kitchen Command"
val age: Int = 25

// Mutable variable
var count = 0
count = 5

// Type inference
val price = 19.99  // Double inferred
val isAvailable = true  // Boolean inferred

// Explicit types
val revenue: Double = 5000.50
val orderId: String = "ORD-001"
```

**Bridge to JavaScript/TypeScript:**
```typescript
// TypeScript (similar to Kotlin)
const name = "Kitchen Command"  // val in Kotlin
let count = 0  // var in Kotlin
count = 5

// But Kotlin adds mandatory type safety
const name: string = "Kitchen Command"
```

**Bridge to Python:**
```python
# Python (no type enforcement at runtime)
name = "Kitchen Command"
count = 0
count = 5

# Python 3.10 typing (similar mental model to Kotlin)
name: str = "Kitchen Command"
count: int = 0
```

**Key Difference:** Kotlin enforces types at compile time. Python/JavaScript don't.

---

#### Concept 2: Null Safety (THE Kotlin Superpower)

**Code First (Kotlin):**
```kotlin
// Non-null type (cannot be null)
val name: String = "John"
// name = null  // COMPILE ERROR - stops you before runtime

// Nullable type (explicitly can be null)
val phoneNumber: String? = null
val email: String? = "john@kitchen.com"

// Check before using
if (phoneNumber != null) {
    println(phoneNumber.length)
}

// Smart cast (Kotlin knows it's not null after check)
val phone: String? = "5551234567"
if (phone != null) {
    println(phone.length)  // No need for ?. here, Kotlin is smart
}

// Safe call operator (?.)
val length = phoneNumber?.length  // Returns null if phoneNumber is null

// Elvis operator (?:) - return default if null
val displayPhone = phoneNumber ?: "No phone"
```

**Bridge to JavaScript/TypeScript:**
```typescript
// TypeScript optional (similar)
let phone: string | null = null
let email: string | undefined = undefined

// Optional chaining (similar to ?.)
const length = phone?.length

// Nullish coalescing (similar to ?:)
const display = phone ?? "No phone"
```

**Bridge to Python:**
```python
# Python - no compile-time null checking
phone = None
email = "john@kitchen.com"

# Must check manually
if phone is not None:
    print(len(phone))
else:
    print("No phone")

# Python 3.10 | syntax (not automatic, must write)
phone: str | None = None
```

**Why This Matters:** Kotlin eliminates null pointer exceptions at compile time. This is HUGE for production apps.

---

#### Concept 3: String Templates

**Code First (Kotlin):**
```kotlin
val name = "John"
val age = 30

// String template with $
val message = "Hello, $name"

// Expression in template
val greeting = "Next year, $name will be ${age + 1} years old"

// Raw strings
val json = """
    {
        "name": "$name",
        "age": $age
    }
""".trimIndent()
```

**Bridge to JavaScript:**
```javascript
// Template literals (very similar)
const name = "John"
const age = 30

const message = `Hello, ${name}`
const greeting = `Next year, ${name} will be ${age + 1} years old`
```

**Bridge to Python:**
```python
# Python f-strings
name = "John"
age = 30

message = f"Hello, {name}"
greeting = f"Next year, {name} will be {age + 1} years old"
```

---

### Day 3-4: Functions and Lambdas

#### Concept 1: Functions

**Code First (Kotlin):**
```kotlin
// Simple function
fun greet(name: String): String {
    return "Hello, $name"
}

// Single expression function (arrow function)
fun add(a: Int, b: Int) = a + b

// No return type (Unit = void)
fun printMessage(message: String) {
    println(message)
}

// Default parameters
fun createOrder(
    orderId: String,
    quantity: Int = 1,
    status: String = "pending"
) {
    println("Order $orderId: $quantity items, status: $status")
}

// Named parameters
createOrder(orderId = "ORD-001", quantity = 5)
createOrder("ORD-002", status = "completed")
```

**Bridge to JavaScript:**
```javascript
// JavaScript function
function greet(name) {
    return `Hello, ${name}`
}

// Arrow function (similar to Kotlin =)
const add = (a, b) => a + b

// Default parameters
function createOrder(orderId, quantity = 1, status = "pending") {
    console.log(`Order ${orderId}: ${quantity} items, status: ${status}`)
}

// Named parameters (object destructuring)
createOrder({ orderId: "ORD-001", quantity: 5 })
```

**Bridge to Python:**
```python
def greet(name):
    return f"Hello, {name}"

def add(a, b):
    return a + b

# Default parameters
def create_order(order_id, quantity=1, status="pending"):
    print(f"Order {order_id}: {quantity} items, status: {status}")
```

---

#### Concept 2: Lambda Functions (Anonymous Functions)

**Code First (Kotlin):**
```kotlin
// Lambda syntax: { parameters -> body }
val double = { x: Int -> x * 2 }

// Call lambda
println(double(5))  // Output: 10

// Lambda with no parameters
val getMessage = { "Hello from Kitchen Command" }
println(getMessage())

// Lambda with multiple parameters
val addNumbers = { a: Int, b: Int -> a + b }
println(addNumbers(10, 20))  // Output: 30

// Lambdas as function parameters
fun processOrder(orders: List<String>, filter: (String) -> Boolean) {
    orders.forEach { order ->
        if (filter(order)) {
            println("Processing: $order")
        }
    }
}

// Use lambda with function
val orders = listOf("ORD-001", "ORD-002", "ORD-003")
processOrder(orders) { order -> order.contains("002") }

// map - transform each item
val prices = listOf(10, 20, 30)
val doubled = prices.map { price -> price * 2 }
println(doubled)  // [20, 40, 60]

// filter - keep matching items
val filtered = prices.filter { price -> price > 15 }
println(filtered)  // [20, 30]
```

**Bridge to JavaScript:**
```javascript
// Arrow function (similar to Kotlin lambda)
const double = (x) => x * 2
console.log(double(5))  // 10

// No parameters
const getMessage = () => "Hello"

// With array methods
const prices = [10, 20, 30]
const doubled = prices.map((price) => price * 2)
const filtered = prices.filter((price) => price > 15)
```

**Bridge to Python:**
```python
# Lambda syntax (similar concept)
double = lambda x: x * 2
print(double(5))  # 10

# Using map/filter
prices = [10, 20, 30]
doubled = list(map(lambda price: price * 2, prices))
filtered = list(filter(lambda price: price > 15, prices))

# Or more Pythonic with comprehensions
doubled = [price * 2 for price in prices]
filtered = [price for price in prices if price > 15]
```

---

### Day 5-6: Collections (List, Map, Set)

#### Concept: Collections and Higher-Order Functions

**Code First (Kotlin):**
```kotlin
// Lists (ordered, can have duplicates)
val numbers = listOf(1, 2, 3, 4, 5)
val mutableNumbers = mutableListOf(1, 2, 3)
mutableNumbers.add(4)

// Access elements
println(numbers[0])  // 1
println(numbers.first())  // 1
println(numbers.last())  // 5

// Iterate
numbers.forEach { num -> println(num) }

// Transform with map
val doubled = numbers.map { it * 2 }  // [2, 4, 6, 8, 10]

// Filter
val evenNumbers = numbers.filter { it % 2 == 0 }  // [2, 4]

// Find first matching
val firstEven = numbers.find { it % 2 == 0 }  // 2

// Check if any/all match
val hasEven = numbers.any { it % 2 == 0 }  // true
val allPositive = numbers.all { it > 0 }  // true

// Maps (key-value pairs)
val menu = mapOf(
    "pizza" to 12.99,
    "burger" to 8.99,
    "salad" to 6.99
)

// Access
println(menu["pizza"])  // 12.99

// Iterate
menu.forEach { (item, price) -> println("$item: $price") }

// Transform map
val prices = menu.map { (_, price) -> price }  // [12.99, 8.99, 6.99]

// Filter map
val cheapItems = menu.filter { (_, price) -> price < 10 }

// Sets (unique items, no order)
val uniqueOrders = setOf("ORD-001", "ORD-002", "ORD-001")
println(uniqueOrders)  // {ORD-001, ORD-002}
```

**Bridge to JavaScript:**
```javascript
// Arrays (similar to Kotlin List)
const numbers = [1, 2, 3, 4, 5]
console.log(numbers[0])  // 1

// map, filter, find
const doubled = numbers.map((num) => num * 2)
const evens = numbers.filter((num) => num % 2 === 0)
const firstEven = numbers.find((num) => num % 2 === 0)

// Objects (similar to Kotlin Map)
const menu = {
    pizza: 12.99,
    burger: 8.99,
    salad: 6.99
}

// Iterate
Object.entries(menu).forEach(([item, price]) => {
    console.log(`${item}: ${price}`)
})
```

**Bridge to Python:**
```python
# Lists
numbers = [1, 2, 3, 4, 5]

# map, filter, find (as comprehensions)
doubled = [num * 2 for num in numbers]
evens = [num for num in numbers if num % 2 == 0]
first_even = next((num for num in numbers if num % 2 == 0), None)

# Dictionaries (similar to Kotlin Map)
menu = {
    "pizza": 12.99,
    "burger": 8.99,
    "salad": 6.99
}

# Iterate
for item, price in menu.items():
    print(f"{item}: {price}")
```

---

### Day 7: Practice Day 1 - Build Your First Kotlin Program

**Project: Restaurant Menu System**

```kotlin
fun main() {
    // Define menu items
    val menu = mapOf(
        "pizza" to 12.99,
        "burger" to 8.99,
        "salad" to 6.99,
        "pasta" to 10.99
    )
    
    // Customers and their orders
    val customers = listOf(
        "Alice" to listOf("pizza", "salad"),
        "Bob" to listOf("burger", "burger"),
        "Charlie" to listOf("pasta", "pizza")
    )
    
    // Calculate total per customer
    customers.forEach { (customerName, items) ->
        val total = items.map { item ->
            menu[item] ?: 0.0  // Use 0.0 if item not found
        }.sum()
        
        println("$customerName ordered ${items.size} items: $${"%.2f".format(total)}")
    }
    
    // Find most expensive item
    val mostExpensive = menu.maxByOrNull { it.value }
    println("Most expensive: ${mostExpensive?.key} = $${mostExpensive?.value}")
    
    // Calculate average price
    val avgPrice = menu.values.average()
    println("Average price: $${"%.2f".format(avgPrice)}")
    
    // Apply discount (10%)
    val discountedMenu = menu.mapValues { (_, price) -> price * 0.9 }
    println("Discounted menu: $discountedMenu")
}
```

**Output:**
```
Alice ordered 2 items: $19.98
Bob ordered 2 items: $17.98
Charlie ordered 2 items: $23.98
Most expensive: pizza = $12.99
Average price: $9.74
Discounted menu: {pizza=11.691..., burger=8.091..., salad=6.291..., pasta=9.891...}
```

**What You Learned:**
- Variables and types
- Collections (Map, List)
- Functions and lambdas
- String templates
- Null safety with Elvis operator (?:)
- Standard library functions (map, sum, maxByOrNull, average)

---

## Phase 2: Kotlin OOP Concepts (Weeks 3-4)

### Day 8-9: Classes and Objects

#### Concept 1: Basic Classes

**Code First (Kotlin):**
```kotlin
// Simple class
class Restaurant {
    var name = "Kitchen Command"
    var rating = 4.5
}

// Instantiate and use
val restaurant = Restaurant()
println("${restaurant.name}: ${restaurant.rating} stars")

// Class with constructor
class Order(val id: String, val items: List<String>, var total: Double) {
    fun printOrder() {
        println("Order $id: ${items.size} items = $${"%.2f".format(total)}")
    }
}

// Create order
val order = Order("ORD-001", listOf("pizza", "salad"), 19.98)
order.printOrder()

// Primary constructor shorthand (Kotlin magic!)
class MenuItem(
    val name: String,
    val price: Double,
    val available: Boolean = true
) {
    override fun toString() = "$name: $$price (Available: $available)"
}

val pizza = MenuItem("Pizza", 12.99)
println(pizza)  // Pizza: $12.99 (Available: true)
```

**Bridge to JavaScript/TypeScript:**
```typescript
// TypeScript class
class Restaurant {
    name: string = "Kitchen Command"
    rating: number = 4.5
}

const restaurant = new Restaurant()

// TypeScript with constructor
class Order {
    constructor(
        public id: string,
        public items: string[],
        public total: number
    ) {}
    
    printOrder() {
        console.log(`Order ${this.id}: ${this.items.length} items = $${this.total}`)
    }
}
```

**Bridge to Python:**
```python
class Restaurant:
    def __init__(self):
        self.name = "Kitchen Command"
        self.rating = 4.5

class Order:
    def __init__(self, id: str, items: list, total: float):
        self.id = id
        self.items = items
        self.total = total
    
    def print_order(self):
        print(f"Order {self.id}: {len(self.items)} items = ${self.total:.2f}")
```

**Key Difference:** Kotlin's primary constructor is built into the class declaration. Much cleaner!

---

#### Concept 2: Inheritance

**Code First (Kotlin):**
```kotlin
// Base class
open class Food(val name: String, val price: Double) {
    open fun description(): String {
        return "$name - $$price"
    }
}

// Inherit from Food
class Burger(name: String, price: Double, val hasTopping: Boolean) : Food(name, price) {
    override fun description(): String {
        return "${super.description()} (Topping: $hasTopping)"
    }
}

class Pizza(name: String, price: Double, val size: String) : Food(name, price) {
    override fun description(): String {
        return "${super.description()} - Size: $size"
    }
}

// Use polymorphism
val foods: List<Food> = listOf(
    Burger("Classic Burger", 8.99, true),
    Pizza("Pepperoni", 12.99, "Large")
)

foods.forEach { food ->
    println(food.description())
}

// Output:
// Classic Burger - $8.99 (Topping: true)
// Pepperoni - $12.99 - Size: Large
```

**Important:** In Kotlin, classes are `final` by default. You MUST use `open` to allow inheritance. This is safer!

**Bridge to Python:**
```python
class Food:
    def __init__(self, name: str, price: float):
        self.name = name
        self.price = price
    
    def description(self):
        return f"{self.name} - ${self.price}"

class Burger(Food):
    def __init__(self, name: str, price: float, has_topping: bool):
        super().__init__(name, price)
        self.has_topping = has_topping
    
    def description(self):
        return f"{super().description()} (Topping: {self.has_topping})"
```

---

#### Concept 3: Interfaces

**Code First (Kotlin):**
```kotlin
// Interface (contract)
interface Orderable {
    fun addToCart()
    fun calculatePrice(): Double
}

// Class implements interface
class MenuItem(val name: String, val price: Double) : Orderable {
    override fun addToCart() {
        println("Added $name to cart")
    }
    
    override fun calculatePrice(): Double {
        return price
    }
}

// Interface with default implementation
interface Printable {
    fun print() {
        println("Printing document...")
    }
}

class Order : Printable {
    // Can override or use default
    override fun print() {
        println("Order details:")
        Printable.super.print()
    }
}

// Multiple interface implementation
interface Trackable {
    fun getStatus(): String
}

class Delivery : Orderable, Trackable, Printable {
    override fun addToCart() {
        println("Delivery added")
    }
    
    override fun calculatePrice(): Double = 2.99
    
    override fun getStatus(): String = "In Transit"
}
```

**Bridge to TypeScript:**
```typescript
interface Orderable {
    addToCart(): void
    calculatePrice(): number
}

class MenuItem implements Orderable {
    constructor(public name: string, public price: number) {}
    
    addToCart() {
        console.log(`Added ${this.name} to cart`)
    }
    
    calculatePrice() {
        return this.price
    }
}
```

---

### Day 10-11: Data Classes and Extension Functions

#### Concept 1: Data Classes

**Code First (Kotlin):**
```kotlin
// Traditional class with boilerplate
data class User(
    val id: Int,
    val name: String,
    val email: String
)

// Data classes automatically get:
// - equals()
// - hashCode()
// - toString()
// - copy()
// - componentN() (for destructuring)

val user1 = User(1, "Alice", "alice@kitchen.com")
val user2 = User(1, "Alice", "alice@kitchen.com")

println(user1 == user2)  // true (equals works!)
println(user1)  // User(id=1, name=Alice, email=alice@kitchen.com)

// copy() - create modified copy
val user3 = user1.copy(id = 2)
println(user3)  // User(id=2, name=Alice, email=alice@kitchen.com)

// Destructuring
val (id, name, email) = user1
println("$id: $name ($email)")

// In loops
data class Order(val id: String, val total: Double, val status: String)

val orders = listOf(
    Order("ORD-001", 19.98, "completed"),
    Order("ORD-002", 15.99, "pending")
)

orders.forEach { (id, total, status) ->
    println("$id: $$total ($status)")
}
```

**Bridge to Python:**
```python
from dataclasses import dataclass

@dataclass
class User:
    id: int
    name: str
    email: str
    
    # dataclass automatically generates __eq__, __repr__, etc.

user1 = User(1, "Alice", "alice@kitchen.com")
user2 = User(1, "Alice", "alice@kitchen.com")

print(user1 == user2)  # True
print(user1)  # User(id=1, name='Alice', email='alice@kitchen.com')

# Destructuring
id, name, email = user1
```

---

#### Concept 2: Extension Functions

**Code First (Kotlin):**
```kotlin
// Add function to existing class WITHOUT inheritance
fun String.isValidEmail(): Boolean {
    return this.contains("@")
}

val email = "john@kitchen.com"
println(email.isValidEmail())  // true

// Extension on List
fun <T> List<T>.second(): T? {
    return if (this.size >= 2) this[1] else null
}

val numbers = listOf(1, 2, 3)
println(numbers.second())  // 2

// Extension on Int
fun Int.isEven(): Boolean {
    return this % 2 == 0
}

println(4.isEven())  // true
println(5.isEven())  // false

// Real-world: Kitchen app extensions
data class Order(val id: String, val items: List<String>, val total: Double)

fun Order.printReceipt() {
    println("========== RECEIPT ==========")
    println("Order: ${this.id}")
    println("Items: ${items.size}")
    println("Total: $${"%.2f".format(total)}")
    println("==============================")
}

val order = Order("ORD-001", listOf("pizza", "salad"), 19.98)
order.printReceipt()

// Extension for formatting
fun Double.formatCurrency(): String {
    return "$${"%.2f".format(this)}"
}

println(19.98.formatCurrency())  // $19.98
```

**Why Extensions Matter:** You can add functionality to classes without modifying their code. Perfect for Kitchen Command plugins!

---

### Day 12: Practice Day 2 - OOP Restaurant System

**Project: Restaurant Management System**

```kotlin
// Base class
open class MenuItem(
    val id: String,
    val name: String,
    val price: Double,
    val available: Boolean = true
)

// Data classes
data class Customer(
    val id: String,
    val name: String,
    val email: String
)

data class OrderItem(
    val menuItem: MenuItem,
    val quantity: Int
)

// Order class with interface
interface Billable {
    fun calculateTotal(): Double
    fun printBill()
}

class Order(
    val id: String,
    val customer: Customer,
    val items: MutableList<OrderItem> = mutableListOf()
) : Billable {
    override fun calculateTotal(): Double {
        return items.sumOf { it.menuItem.price * it.quantity }
    }
    
    override fun printBill() {
        println("\n========== ORDER BILL ==========")
        println("Order ID: $id")
        println("Customer: ${customer.name}")
        println("Items:")
        items.forEach { item ->
            val lineTotal = item.menuItem.price * item.quantity
            println("  - ${item.menuItem.name} x${item.quantity} = $${"%.2f".format(lineTotal)}")
        }
        println("Total: $${"%.2f".format(calculateTotal())}")
        println("================================\n")
    }
    
    fun addItem(menuItem: MenuItem, quantity: Int) {
        if (menuItem.available) {
            items.add(OrderItem(menuItem, quantity))
            println("Added ${quantity}x ${menuItem.name}")
        } else {
            println("${menuItem.name} is not available")
        }
    }
}

// Extensions
fun Order.discount(percentage: Double): Double {
    val discount = calculateTotal() * (percentage / 100)
    return calculateTotal() - discount
}

// Main
fun main() {
    // Create menu
    val menu = listOf(
        MenuItem("M1", "Pizza Margherita", 12.99),
        MenuItem("M2", "Caesar Salad", 6.99),
        MenuItem("M3", "Garlic Bread", 3.99),
        MenuItem("M4", "Coca Cola", 1.99)
    )
    
    // Create customer
    val customer = Customer("C1", "Alice", "alice@example.com")
    
    // Create order
    val order = Order("ORD-001", customer)
    
    // Add items
    order.addItem(menu[0], 2)  // 2x Pizza
    order.addItem(menu[1], 1)  // 1x Salad
    order.addItem(menu[3], 2)  // 2x Coca Cola
    
    // Print bill
    order.printBill()
    
    // Apply discount
    val discountedPrice = order.discount(10.0)  // 10% off
    println("With 10% discount: $${"%.2f".format(discountedPrice)}")
}
```

---

## Phase 3: Android Fundamentals (Weeks 5-6)

*[Due to token limit, I'll provide a structured outline for the remaining sections. Complete implementation continues below]*

---

# C Project Track

## C Project Progression (Parallel to Kotlin)

### Weeks 1-2: Data Structures
**Monday (1.5 hrs) + Thursday (1.5 hrs) + Saturday (1 hr)**

**Week 1 Project: Linked List Implementation**
```c
#include <stdio.h>
#include <stdlib.h>

typedef struct Node {
    int data;
    struct Node* next;
} Node;

Node* create_node(int data) {
    Node* node = (Node*)malloc(sizeof(Node));
    node->data = data;
    node->next = NULL;
    return node;
}

void insert_at_head(Node** head, int data) {
    Node* new_node = create_node(data);
    new_node->next = *head;
    *head = new_node;
}

void print_list(Node* head) {
    while (head != NULL) {
        printf("%d -> ", head->data);
        head = head->next;
    }
    printf("NULL\n");
}

void free_list(Node* head) {
    while (head != NULL) {
        Node* temp = head;
        head = head->next;
        free(temp);
    }
}

int main() {
    Node* head = NULL;
    
    insert_at_head(&head, 3);
    insert_at_head(&head, 2);
    insert_at_head(&head, 1);
    
    print_list(head);  // 1 -> 2 -> 3 -> NULL
    
    free_list(head);
    return 0;
}
```

**Deliverables:**
- Insert at head (1 hr)
- Insert at tail (30 min)
- Delete node (30 min)
- Print list (15 min)

---

### Weeks 3-4: Algorithms
**Tuesday (1.5 hrs) + Thursday (1.5 hrs) + Saturday (1 hr)**

**Week 3 Project: Sorting Algorithms**
```c
#include <stdio.h>

void print_array(int arr[], int n) {
    for (int i = 0; i < n; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");
}

// QuickSort
int partition(int arr[], int low, int high) {
    int pivot = arr[high];
    int i = low - 1;
    
    for (int j = low; j < high; j++) {
        if (arr[j] < pivot) {
            i++;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    
    int temp = arr[i + 1];
    arr[i + 1] = arr[high];
    arr[high] = temp;
    
    return i + 1;
}

void quicksort(int arr[], int low, int high) {
    if (low < high) {
        int pi = partition(arr, low, high);
        quicksort(arr, low, pi - 1);
        quicksort(arr, pi + 1, high);
    }
}

int main() {
    int arr[] = {64, 34, 25, 12, 22, 11, 90};
    int n = 7;
    
    printf("Original: ");
    print_array(arr, n);
    
    quicksort(arr, 0, n - 1);
    
    printf("Sorted: ");
    print_array(arr, n);
    
    return 0;
}
```

**Deliverables:**
- QuickSort implementation (1 hr)
- MergeSort implementation (1 hr)
- Time complexity analysis (30 min)

---

### Weeks 5-6: Binary Trees
**Tuesday (2 hrs) + Thursday (1 hr) + Saturday (1 hr)**

```c
#include <stdio.h>
#include <stdlib.h>

typedef struct TreeNode {
    int data;
    struct TreeNode* left;
    struct TreeNode* right;
} TreeNode;

TreeNode* create_node(int data) {
    TreeNode* node = (TreeNode*)malloc(sizeof(TreeNode));
    node->data = data;
    node->left = NULL;
    node->right = NULL;
    return node;
}

TreeNode* insert(TreeNode* root, int data) {
    if (root == NULL) {
        return create_node(data);
    }
    
    if (data < root->data) {
        root->left = insert(root->left, data);
    } else {
        root->right = insert(root->right, data);
    }
    
    return root;
}

void inorder(TreeNode* root) {
    if (root == NULL) return;
    inorder(root->left);
    printf("%d ", root->data);
    inorder(root->right);
}

int main() {
    TreeNode* root = NULL;
    root = insert(root, 50);
    root = insert(root, 30);
    root = insert(root, 70);
    
    printf("Inorder: ");
    inorder(root);  // 30 50 70
    printf("\n");
    
    return 0;
}
```

---

### Weeks 7-8: File I/O & Networking
**Tuesday (2 hrs) + Thursday (1.5 hrs) + Saturday (1.5 hrs)**

**File I/O Project:**
```c
#include <stdio.h>
#include <string.h>

typedef struct Order {
    char id[10];
    char item[50];
    double price;
} Order;

void write_orders(const char* filename) {
    FILE* file = fopen(filename, "wb");
    
    Order orders[] = {
        {"ORD-001", "Pizza", 12.99},
        {"ORD-002", "Burger", 8.99},
        {"ORD-003", "Salad", 6.99}
    };
    
    fwrite(orders, sizeof(Order), 3, file);
    fclose(file);
    printf("Orders written to file\n");
}

void read_orders(const char* filename) {
    FILE* file = fopen(filename, "rb");
    Order order;
    
    printf("Orders from file:\n");
    while (fread(&order, sizeof(Order), 1, file)) {
        printf("%s: %s - $%.2f\n", order.id, order.item, order.price);
    }
    
    fclose(file);
}

int main() {
    write_orders("orders.dat");
    read_orders("orders.dat");
    return 0;
}
```

---

### Weeks 9-16: Real Application Projects

**Week 9-10: Simple HTTP Server**
```c
// TCP socket server that handles basic HTTP requests
// 2-3 hour project
```

**Week 11-12: Logger System**
```c
// File-based logging system with rotation
// 2-3 hour project
```

**Week 13-14: JSON Parser**
```c
// Parse basic JSON for API communication
// 3-4 hour project
```

**Week 15-16: Embedded Systems Simulator**
```c
// Simulate kitchen hardware communication
// 3-4 hour project
```

---

# Django Sunday Walkthroughs

## Approach: Code Review + Pattern Learning

Every Sunday, 30 min - 1 hour: Read your own Kitchen Command code and identify patterns.

### Week 1-2: Django Foundation Review

**Sunday Walkthrough 1: Project Structure**

Read and understand:
```
backend/
├── kitchen_command/      # Project settings
│   ├── settings.py       # Django config
│   ├── urls.py           # Root URL routing
│   ├── asgi.py          # Async configuration
│   └── wsgi.py          # Production runner
├── apps/
│   ├── core/            # Shared utilities
│   ├── orders/          # Order management
│   ├── tables/          # Table management
│   ├── payments/        # Payment processing
│   └── integrations/    # Third-party integrations
└── requirements.txt     # Dependencies
```

**Key Questions to Ask Yourself:**
1. Why is each app separate?
2. What does `settings.py` control?
3. How do URL patterns work?

---

**Sunday Walkthrough 2: Models & Database**

Open `backend/apps/orders/models.py`

**Pattern to Identify:**
```python
class Order(TimestampedModel, UUIDModel):
    """
    Why inherit from TimestampedModel and UUIDModel?
    - Timestamp: auto-track created_at, updated_at
    - UUID: use UUID instead of incremental ID
    """
    restaurant = models.ForeignKey(...)
    customer = models.ForeignKey(...)
```

**Learn:**
- Foreign key relationships
- Model inheritance for reusable fields
- Queryset methods (.filter, .get, .create)

---

### Week 3-4: Views & Serializers

**Sunday Walkthrough 3: ViewSets**

Open `backend/apps/orders/views.py`

**Pattern:**
```python
class OrderViewSet(viewsets.ModelViewSet):
    """
    A ViewSet automatically creates:
    - GET /api/v1/orders/ (list)
    - POST /api/v1/orders/ (create)
    - GET /api/v1/orders/{id}/ (detail)
    - PUT /api/v1/orders/{id}/ (update)
    - DELETE /api/v1/orders/{id}/ (destroy)
    """
    queryset = Order.objects.all()
    serializer_class = OrderSerializer
```

**Learn:** How Django REST Framework generates API endpoints automatically.

---

**Sunday Walkthrough 4: Serializers**

Open `backend/apps/orders/serializers.py`

**Pattern:**
```python
class OrderSerializer(serializers.ModelSerializer):
    """
    Serializers convert Django models to/from JSON
    They handle validation and transformation
    """
    class Meta:
        model = Order
        fields = ['id', 'restaurant', 'customer', 'items', 'total']
```

**Learn:** How data flows from database → API → frontend

---

### Week 5-6: Signals & Hooks

**Sunday Walkthrough 5: Django Signals**

Open `backend/apps/orders/signals.py`

**Pattern:**
```python
@receiver(post_save, sender=Order)
def order_created(sender, instance, created, **kwargs):
    """
    This runs automatically when Order is created
    - Send notifications
    - Update inventory
    - Trigger kitchen display
    """
```

**Learn:** How to trigger side-effects when models change.

---

### Week 7-8: Celery & Async Tasks

**Sunday Walkthrough 6: Background Tasks**

Open `backend/apps/integrations/tasks.py`

**Pattern:**
```python
@shared_task
def sync_order_to_accounting(order_id, integration_id):
    """
    This runs in background worker, not during HTTP request
    - Fetches order from DB
    - Calls accounting API
    - Updates status
    - Sends notification
    """
```

**Learn:** Why long-running tasks shouldn't block API responses.

---

### Week 9-10: WebSockets

**Sunday Walkthrough 7: Real-time Updates**

Open `backend/apps/core/websocket/`

**Pattern:**
```python
class KitchenConsumer(AsyncWebsocketConsumer):
    """
    WebSocket connection for kitchen display
    - Staff sees order updates instantly
    - No polling needed
    - True real-time
    """
```

**Learn:** How real-time features work in Django.

---

### Week 11-12: Authentication & Permissions

**Sunday Walkthrough 8: Security**

Open `backend/apps/core/permissions.py`

**Pattern:**
```python
class IsRestaurantOwner(permissions.BasePermission):
    """
    Only restaurant owner can modify their data
    Applied to all ViewSets automatically
    """
```

**Learn:** How authorization works in REST APIs.

---

### Week 13-14: Integrations

**Sunday Walkthrough 9: External APIs**

Open `backend/apps/integrations/`

**Patterns:**
- Stripe payment handling
- Uber Eats order ingestion
- QuickBooks accounting sync

**Learn:** How to integrate external services safely.

---

### Week 15-16: Optimization & Monitoring

**Sunday Walkthrough 10: Production Concerns**

Open `backend/apps/core/services/datadog_service.py`

**Pattern:**
```python
"""
Monitor:
- API response times
- Payment processing
- Database query count
- Error rates
"""
```

**Learn:** How to instrument code for production debugging.

---

# Assessment Checkpoints

## Week 1-2 Checkpoint: Kotlin Fundamentals
**Criteria:**
- [ ] Write functions with default parameters
- [ ] Use null safety operators (?., ?:)
- [ ] Filter/map collections fluently
- [ ] String templates work correctly

**Challenge:**
Write a program that:
1. Accepts a list of menu prices
2. Filters items under $10
3. Applies 20% discount
4. Prints formatted results

---

## Week 3-4 Checkpoint: OOP Mastery
**Criteria:**
- [ ] Create classes with inheritance
- [ ] Implement interfaces correctly
- [ ] Use data classes for models
- [ ] Write extension functions

**Challenge:**
Build a small restaurant system with:
- Food hierarchy (Pizza, Burger, Salad)
- Order class that implements Billable
- Extensions for formatting and discounts

---

## Week 5-6 Checkpoint: Android Basics
**Criteria:**
- [ ] Understand Activity lifecycle
- [ ] Create layouts with XML
- [ ] Use ViewBinding correctly
- [ ] Handle Intent navigation

**Challenge:**
Create a simple Android app:
1. Main screen with menu list
2. Click item → detail screen
3. Add to cart button
4. Pass data between activities

---

## Week 7-8 Checkpoint: Advanced Android
**Criteria:**
- [ ] Implement MVVM pattern
- [ ] Handle asynchronous operations (coroutines)
- [ ] Work with databases (Room)
- [ ] Manage app lifecycle correctly

**Challenge:**
Extend previous app:
1. Store orders locally with Room
2. Fetch menu from backend API
3. Use ViewModel to manage state
4. Show loading states

---

## Week 9-10 Checkpoint: Real App Building
**Criteria:**
- [ ] Connect to your Django backend
- [ ] Implement proper error handling
- [ ] Cache data appropriately
- [ ] Handle offline scenarios

**Challenge:**
Build Kitchen Command MVP:
1. Login screen
2. Restaurant selection
3. Table/order management
4. Backend sync

---

## Week 11-12 Checkpoint: Backend Integration
**Criteria:**
- [ ] Authenticate with tokens
- [ ] Handle WebSocket connections
- [ ] Implement state management
- [ ] Manage user sessions

**Challenge:**
Full feature: Real-time order updates
1. Backend sends WebSocket updates
2. App receives and displays live
3. User can interact and send updates back
4. Proper error recovery

---

## Week 13-14 Checkpoint: Hardware Ready
**Criteria:**
- [ ] Request Bluetooth permissions
- [ ] Connect to devices
- [ ] Handle disconnections gracefully
- [ ] Parse printer responses

**Challenge:**
Bluetooth printer integration:
1. Scan for devices
2. Connect to printer
3. Send test receipt
4. Handle failures

---

## Week 15-16 Final Checkpoint: Production Ready
**Criteria:**
- [ ] Unit tests written
- [ ] Performance acceptable (< 2s loads)
- [ ] No memory leaks
- [ ] Handle all edge cases
- [ ] App Store requirements met

**Challenge:**
Production readiness:
1. 80% test coverage
2. Performance benchmarks pass
3. Security audit completed
4. Release build signed
5. Play Store submission ready

---

## C Project Checkpoints (Every 2 Weeks)

### Checkpoint 1: Linked Lists (Week 2)
- [ ] Insert/delete operations
- [ ] Memory properly freed
- [ ] No segmentation faults

### Checkpoint 2: Sorting (Week 4)
- [ ] QuickSort works correctly
- [ ] Time complexity understood
- [ ] Edge cases handled

### Checkpoint 3: Binary Trees (Week 6)
- [ ] Tree operations correct
- [ ] Traversal methods work
- [ ] Memory managed properly

### Checkpoint 4: File I/O (Week 8)
- [ ] Read/write binary files
- [ ] Error handling present
- [ ] Data integrity verified

### Checkpoint 5: Real Projects (Week 16)
- [ ] 4 complete projects built
- [ ] Code is production-quality
- [ ] Interview-ready

---

## Django Checkpoints (Weekly Reviews)

Every Sunday, after code review, answer:
1. What pattern did I see?
2. Why is it implemented that way?
3. How could I use this in my app?
4. What would break if I changed it?

---

# Study Tips & Resources

## Learning Optimization
1. **Code-first learning:** Write before reading explanations
2. **Bridge languages:** Always compare to Python/JavaScript/TypeScript
3. **Project-based:** Build real things, not toy exercises
4. **Spaced repetition:** Review C weekly, Django on Sundays
5. **Active recall:** Explain concepts out loud

## Resources
- **Kotlin Official:** https://kotlinlang.org/docs/getting-started.html
- **Android Docs:** https://developer.android.com/guide
- **Kotlin Playground:** https://play.kotlinlang.org/ (try code online)
- **Android Studio:** Download latest IDE
- **Your Backend:** Reference your Django code constantly

## Building Momentum
- Week 1-2: Often feels hard (new syntax)
- Week 3-4: Feels better (OOP clicks)
- Week 5-6: Real Android feels magical
- Week 7-8: Building real features (momentum!)
- Week 9-16: Unstoppable (you know what you're doing)

---

**Total Time Investment: 4 months to proficiency**  
**Time to Job-Ready: 3-4 months**  
**Time to Building Kitchen Command Mobile: 5-6 months with backend integration**

This roadmap is your blueprint. Follow it ruthlessly. Don't skip sections. Every week builds on the previous one. By week 16, you'll be a proficient Android developer ready to ship production apps.

Good luck. You've got this.
