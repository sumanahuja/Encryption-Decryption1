package encryptdecrypt

import java.io.File
import java.net.URLDecoder
import java.net.URLEncoder

fun main(args: Array<String>) {
    val sizeArgs = args.size
    var encodedText = ""
    var decodedText = ""
    val list = mutableListOf<String>()
    for (i in 0 until sizeArgs) {
        list.add(args[i])
    }
    var mode = "enc"
    var key = "0"
    var data1: String = ""
    var inFile: String = ""
    var outFile: String = ""
    var alg: String = "shift"
    if(list.size >= 1) {
        for (i in 0 until list.size) {
            if (list[i] == "-mode" ){
                mode = list[i+1]
            } else if (list[i] == "-key") {
                key = list[i+1]
            }  else if (list[i] == "-alg") {
                alg = list[i+1]
                //println("alg= $alg")
            } else if (list[i] == "-data") {
                data1 = list[i+1]
            }  else if (list[i] == "-in") {
                inFile = list[i+1]
            }  else if (list[i] == "-out") {
                outFile = list[i+1]
                //println(outFile)
            }

        }
       //
    }
    if (data1 == "" && inFile != "") {
        try {
            data1 = File(inFile).readText()
          //  println(data1)
        } catch (x: Exception) {
            println(x.message)
        }
    }
    val data1Length = data1.length
  //  println("$data1Length\t $data1")
    //println("M= $mode \t D= $data1 \t K= $key\t A= $alg IN= $inFile")

    if(mode == "" || mode == "enc" || data1 == ""){
//
//        encodedText = encode(data1, key.toInt() )
//    } else if (mode == "" || mode == "enc" || data1 == "" || inFile != "") {

        encodedText = encode(data1, key.toInt(), alg)
        //encodedText += "&"
        if (outFile != "" && encodedText != "") {
            val absPath = System.getProperty("user.dir")
          //  println(absPath)
            val saperator = File.separator
            val outFileName = "$absPath$saperator$outFile"
            // println(outFileName)
            File(outFileName).writeText(encodedText)
            //println("EncodedText")
            //println("Encoded Text is : $encodedText")
        } else println(encodedText)
    } else {
        decodedText = decode(data1, key.toInt(), alg)
        // decodedText += "&"
        if (outFile != "" && decodedText != "") {
            // if (File(outFile).exists()) {
            val absPath = System.getProperty("user.dir")
            val saperator = File.separator
            val outFileName = "$absPath$saperator$outFile"
            //println(outFileName)
            File(outFileName).writeText(decodedText)
            //println("decodedText")
            //println("Decoded Text is : $decodedText")
            // }
        } else println(decodedText)
    }
}

fun encode(str: String, key: Int , alg: String) :String {
    val myList = mutableListOf<Char>()
    var sum = 0
    for( i in str.indices) {
        if(alg == "unicode") {
            sum = (str[i].code + key)
            myList.add((sum).toChar())
           // println(myList.toString())
        } else {
            when (str[i].code) {
                in 65..90 -> {
                    sum = (str[i].code + key - 65) % 26 + 65
                    myList.add((sum).toChar())
                    //println("CAPITAL $sum ${sum.toChar()}")

                }
                in 97..122 -> {

                    sum = (str[i].code + key - 97) % 26 + 97
                    myList.add((sum).toChar())
                    //println(sum.toChar())
                    //println("SMALL $sum ${sum.toChar()}")

                }
                32 -> {
                    myList.add(str[i])
                    //println("M SPACE")

                }
                33 -> {
                    myList.add(str[i])
                    //println("M !")

                }

                else -> {
                    sum= (str[i].code + key )- 26
                    myList.add(sum.toChar())
                    //print("M ELSE $sum ${sum.toChar()}")
                }
            }
        }
    }
    // myList.add(myList.size,'&')
    return (myList.joinToString().replace(", ",""))
    //println(myList.joinToString().replace(", ",""))

}
fun decode (str: String, key: Int, alg: String): String {
    // println("DECODE")
    val myList = mutableListOf<Char>()
    var sum = 0
    for( i in str.indices) {
        if(alg == "unicode") {
            sum = (str[i].code - key)
            myList.add((sum).toChar())
            // println(myList.toString())
        } else {
            if( (str[i].code - key in  65..90) && (str[i].code in 65..90 )) {
                    sum = (str[i].code - key - 65) % 26 + 65
                    //println("CAPITAL $sum ${sum.toChar()}")
                    myList.add((sum).toChar())

                } else if(str[i].code - key in 97..122 && str[i].code in 97..122) {

                    sum = (str[i].code - key - 97) % 26 + 97
                    //println("SMALL $sum ${sum.toChar()}")
                    myList.add((sum).toChar())
                    //println(sum.toChar())
                } else if(str[i].code == 32) {
                    //println ("M SPACE ${str[i].code}")
                    myList.add(' ')
                } else if(str[i].code == 33)  {
                   // println("M ! ${str[i].code}")
                    myList.add('!')
                } else {
                    //if((str[i].code - key) !in 97..122 && (str[i].code - key) !in 65..90)
                    sum= ((str[i].code - key )+ 26)
                    myList.add(sum.toChar())
                  //  print(((str[i].code - key )+ 26).toChar())
            //        println("M ELSE $sum ${sum.toChar()}")
                }
            }
        }

    // myList.add(myList.size,'&')
    return (myList.joinToString().replace(", ",""))
    //println(myList.joinToString().replace(", ",""))
}