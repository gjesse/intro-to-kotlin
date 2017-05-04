package net.loshodges.intro.clazz


class RateLimiter(val maxPermits: Int,
                  val refillRate: Double) {

    var availablePermits = maxPermits

    fun getPermits(requested: Int): Boolean {
        return if (this.availablePermits >= requested) {
            this.availablePermits -= requested
            true
        } else {
            false
        }
    }
}

data class Person(val name: Name,
                  val age: Int,
                  val gender: Gender)

data class Name(val first: String,
                val last: String,
                val middle: String? = null)

enum class Gender {
    MALE, FEMALE, NA
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

fun nullExample() {
    //var name: Name = Name(first = "Cliff", last="Martinez")
    //name = null


    // val name: Name? = Name(first = "Cliff", last="Martinez")
    // println(name.first)

    val name: Name? = Name(first = "Cliff", last = "Martinez")

    val maybeNullMiddle: String? = name?.middle
    val middleWithDefault: String = name?.middle ?: "n/a"
    val middleOrError: String = name?.middle ?:
            throw RuntimeException("noooo")

}