package net.loshodges.intro.clazz

import java.util.*
import kotlin.coroutines.experimental.EmptyCoroutineContext.plus


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
class FBJob : Job
class TWJob : Job

fun castingExample(job: Job) {
    val fbJob = job as FBJob
}

fun smartCastExample(job: Job) {
    when (job) {
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


sealed class ServiceResult<T>
data class Success<T>(val result: T) : ServiceResult<T>()
sealed class Failure : ServiceResult<Nothing>() {
    data class Permanent(val message: String) : Failure()
    data class Retriable(val message: String, val retriesRemaining: Int) : Failure()
    data class Unknown(val message: String) : Failure()
}

fun <T> handleResult(res: ServiceResult<T>) {
    return when (res) {
        is Success -> handleSuccess(res.result)
        is Failure -> {
            when (res) {
                is Failure.Permanent -> TODO()
                is Failure.Retriable -> TODO()
                is Failure.Unknown -> TODO()
            }
        }
    }
}

fun <T> handleSuccess(successPerson: T) {
    TODO()
}


object SingletonWhatever {
    fun getWhat() = "What"
    fun getEver() = "eveeerrr"
}

// temporary object
fun anytimeObject() {
    val point = object {
        val x = 22.2
        val y = 44.2
    }
    print(point.x)
}

interface Answer {
    fun getAnswer(): Double
}

class AnswerImpl : Answer {
    override fun getAnswer() = 42.2
}

class AnswerPlus(val answer: Answer) : Answer by answer {
    // can do other stuff here
}

fun act() {
    val aPlus = AnswerPlus(AnswerImpl())
    println(aPlus.getAnswer())
}

fun stringFun(a: String, b: String) {
    println("a = $a, b length = ${b.length}")
}

fun lambda() {
    val sum = { a: Int, b: Int -> a + b }
    sum(1, 2) // 3

    fun doSomething(a: Int, something: (Int) -> Int): Int {
        return something(a)
    }

    val res = doSomething(4, { input -> input / 2 })

    val res2 = doSomething(2) {
        it * 2
    }
}

fun lambda3() {
    listOf(Name("joe", "schmoe"))
            .map { Name::last }

    val fName = Name::first
}

fun stdLibReceivers() {
    val p = Properties().apply {
        this.put("p1", 22)
        this.put("p2", 42)
    }



fun collectionGoodies() {
    val list:List<Iterable<Int>> = listOf(
            listOf(1,2,3,4,5,6,7,8,9,10),
            4..55
    )

    // WARNING: NOT LAZY
    val groupedFlattenedFiltered : Map<Int, List<Int>> = list
            .asSequence()
            .flatten()
            .filter { it % 2 == 0 }
            .map{ it - 1 }
            .filter {
                it > 4
            }
            .groupBy { it % 4 }
}






}












