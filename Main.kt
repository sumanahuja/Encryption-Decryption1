package encryptdecrypt

fun main() {
    val str = "we found a treasure!"
    var newstr=""
    val strLength = str.length
    for (i in 0..strLength-1)
    {
        if(str[i] == 'w') {
            newstr = newstr + "d"
        }
        if(str[i] == 'e') {
            newstr = newstr+"v"
        }
        if(str[i] == 'f') {
            newstr = newstr+"u"
        }
        if(str[i] == 'o') {
            newstr = newstr+"l"
        }
        if(str[i] == 'u') {
            newstr = newstr+"f"
        }
        if(str[i] == 'n') {
            newstr = newstr+"m"
        }
        if(str[i] == 'd') {
            newstr = newstr+"w"
        }
        if(str[i] == ' ') {
            newstr = newstr+" "
        }
        if(str[i] == 'a') {
            newstr += "z"
        }
        if(str[i] == 't') {
            newstr = newstr+"g"
        }
        if(str[i] == 'r') {
            newstr = newstr+"i"
        }
        if(str[i] == 's') {
            newstr = newstr+"h"
        }
        if(str[i] == '!') {
            newstr = newstr+"!"
        }
    }

    println(newstr)

}