abstract class Base {}

class Derived : Base(), Comparable<Derived> {
    override fun compareTo(other: Derived): Int {
        throw UnsupportedOperationException("not implemented")
    }
}

enum class Foo { bar1, bar2 }

fun isDoesNotMatchTheBaseTypeIfDerivedTypeImplementsComparable() {
    val bla: Any = Derived()
    when {
        bla is Base -> println("OK   : is matches Base.")
        else -> println("ERROR: val should be Base but is not.")
    }
}


fun illegalCastWhenComparingEnum() {
    try {
        val bla: Any = Foo.bar1
        println("OK   : bla can be compared to Foo.bar1. Result: ${(bla as Comparable<Foo>).compareTo(Foo.bar1)}.")
    } catch (ex: Throwable) {
        println("ERROR: Exception when comparing bla to Foo.bar1 : ${ex.message}.")
    }
}

fun synchronizedUsingAnyDoesNotWork() {
    synchronized("sync") {
        println("OK   : Synchronized on a String works.")
    }
    try {
        synchronized(Any()) {
            println("OK   : Synchronized on Any() works.")
        }
    } catch (ex: Throwable) {
        println("ERROR: Exception using Any() in synchronized : ${ex.message}.")
    }
}


fun main(args: Array<String>) {
    isDoesNotMatchTheBaseTypeIfDerivedTypeImplementsComparable()
    illegalCastWhenComparingEnum()
    synchronizedUsingAnyDoesNotWork()
}


