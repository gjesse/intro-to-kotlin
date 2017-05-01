package net.loshodges.intro.fn

fun sayHi(greeting: String = "Howdy",
          name: String = "Honored Guest") {
    println("$greeting, $name!")
}

fun main(args: Array<String>) {
    sayHi()
    sayHi(name = "Shane")
    sayHi(name = "Dave",
            greeting = "Welcome to the conference room")
}



fun getServiceResult(condition: Boolean) = if (condition) {
    "Service OK"
} else {
    "Service Failure"
}