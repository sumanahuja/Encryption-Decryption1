fun main() {
    val str = readln().toString()
    val muList = str.split("-").toMutableList()
    val strY = muList.get(0)
    muList.removeAt(0)
    muList.add(strY)
    print(muList.joinToString().replace(", ", "/"))
}
