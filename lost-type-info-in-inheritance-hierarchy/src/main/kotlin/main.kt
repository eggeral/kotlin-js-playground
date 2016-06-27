abstract class Base {}

class Derived : Base(), Comparable<Derived> {
    override fun compareTo(other: Derived): Int {
        throw UnsupportedOperationException("not implemented")
    }
}

fun main(args: Array<String>) {
    val bla: Any = Derived()
    when {
        bla is Base -> println("is Base")
        else -> println("is not Base")
    }
}
