package net.loshodges.intro.clazz


class RateLimiter(val maxPermits: Int,
                  val refillRate: Double) {

    var availablePermits = maxPermits

    fun getPermits(requested: Int): Boolean {
        if (this.availablePermits >= requested) {
            this.availablePermits-=requested
        }
        return true
    }
}

data class Person(val name: Name,
                  val age: Int,
                  val gender: Gender)

data class Name(val first: String,
                val last: String,
                val middle: String? = null)

enum class Gender {
    MALE,FEMALE,NA
}

fun main(args: Array<String>) {
    val person = Person(
            Name("Mattie", "Brickowski"),
            24,
            Gender.MALE
    )
    person.copy(age = 25)
    println(person)
}