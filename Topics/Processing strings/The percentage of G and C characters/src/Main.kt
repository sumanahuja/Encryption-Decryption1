fun main() {
    val str = readln().toString()
    var count = 0.0
    for (i in str.indices) {
        if (str[i] == 'g' || str[i] == 'G' || str[i] == 'c' || str[i] == 'C') {
            count++
        }
    }

    print((count * 100 / str.length).toDouble())
}
