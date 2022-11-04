package encryptdecrypt

fun main() {
    val operation = readln()
    val str = readln().toString()
    val key = readln().toInt()
    if (operation == "enc") {
        encode(str, key)
    } else if (operation == "dec") {
        dencode(str, key)
    }

}
fun encode (str: String, key: Int) {
    val myList = mutableListOf<Char>()
    var sum = 0
    // print(('z'.code + 5 -97) / 26 + 97 )
    for( i in str.indices) {
//        if (str[i].code in 97..122 || str[i] == ' ') {
//            if (str[i] == ' ') {
//                myList.add(' ')
//                //print("space")
//            } else {
                sum = (str[i].code + key )
                myList.add((sum).toChar())
                //println(sum.toChar())
          //  }

        //}
    }
    //println(myList.toString())
    println(myList.joinToString().replace(", ",""))

}
fun dencode (str: String, key: Int) {
    val myList = mutableListOf<Char>()
    var sum = 0
    // print(('z'.code + 5 -97) / 26 + 97 )
    for (i in str.indices) {
//        if (str[i].code in 97..122 || str[i] == ' ') {
//            if (str[i] == ' ') {
//                myList.add(' ')
//                //print("space")
//            } else {
                sum = (str[i].code - key)
                myList.add((sum).toChar())
                //println(sum.toChar())
        //    }

        //}
    }
    //println(myList.toString())
    println(myList.joinToString().replace(", ", ""))
}