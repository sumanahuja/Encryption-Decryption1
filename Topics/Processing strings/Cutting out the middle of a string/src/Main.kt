fun main() {
    val str = readln().toString()
    var r1: Int
    var r2: Int = 0
    if (str.length % 2 == 0) {
        r1 = str.length / 2 - 1.toInt()
        r2 = str.length / 2 + 1.toInt()
    } else {
        r1 = str.length / 2
        r2 = r1 + 1
    }
    val sub = str.substring(r1, r2)
    print(str.replaceFirst(sub, ""))

}
