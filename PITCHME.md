
## Intro to Kotlin

![LOGO](https://kotlinlang.org/assets/images/open-graph/kotlin_250x250.png)

A practical intro to kotlin for java devs.

---

## What is it?

- developed by jetbrains
- more consice than java
- interoperable
- pragmatic
- safe

---

## Where can I use it?

- jvm
- android
- javascript
- native targets

---

## Enough chit-chat, let's get into the details

---

## Basics

+++

### Basics 
#### val/var

```kotlin
// val == 'final'
val aString = "really, a string"

// var == 'not final'
var anotherString = aString
```

+++

### Basics 
#### type inference

```kotlin
val anInt: Int = 42
val aCompileError: String = 98L
```

---

## Functions

+++

### Functions 
#### structure

```kotlin
fun add(left: Int, right: Int): Int {
    return left + right
}
```

+++

### Functions 
#### named & default args

```kotlin

fun sayHi(greeting: String = "Goodbye", name:String = "Honored Guest") {
    println("$greeting, $name!")
}

fun main(args: Array<String>) {
    sayHi()
    sayHi(name = "Shane")
    sayHi(name = "Dave", greeting = "welcome to the conference room")
}
```

- sayBye(name = "Builder Pattern")      <!-- .element: class="fragment" -->
