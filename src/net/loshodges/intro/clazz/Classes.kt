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

interface Job
class FBJob: Job
class TWJob: Job

fun castingExample(job: Job) {
    val fbJob = job as FBJob
}

fun smartCastExample(job: Job) {
    when(job) {
        is FBJob -> handleFbJob(job)
        is TWJob -> handleTWJob(job)
        else -> println("unknown job $job")
    }
}
fun handleTWJob(job: TWJob) {
    TODO("not implemented")
}
fun handleFbJob(job: FBJob) {
    TODO("not implemented")
}


fun deconExample(person: Person) {
    val (name, age, gender) = person

}

fun extExample(idString: String?) {
    if (!idString.isValidId()) {
        throw RuntimeException("invalid")
    }
}

fun String?.isValidId(): Boolean {
    return if (this == null) {
        false
    } else {
        this.length in 4..8
    }
}