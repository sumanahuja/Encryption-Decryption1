fun main() {
    val numbers = readLine()!!.split(' ').map { it.toInt() }.toMutableList()
    // do not touch the lines above
    val len = numbers.size
    val value = numbers.get(len - 2)
    numbers.removeAt(len - 2)
    numbers.add(0, numbers.sum() + value)

    // do not touch the lines below
    println(numbers.joinToString(" "))
}
