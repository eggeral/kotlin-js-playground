enum class Foo { bar1, bar2 }

fun main(args: Array<String>) {
    val bla : Any = Foo.bar1
    println((bla as Comparable<Foo>).compareTo(Foo.bar1))
}
