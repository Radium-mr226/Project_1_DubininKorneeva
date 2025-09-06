fun main() {
    val testt = ("AAADSSSRRTTHAAAA")
    val res = CharArray(testt.length)
    var  k: Int = 1
    var j: Int = 0


    for(i in 0 until  testt.length-1)
    {
        if (testt[i] == testt[i+1]) {
            k++;
        }

        else
        {
            res[j]= testt[i]
            j++

            if (k > 1) {
                res[j] = (k + '0'.code).toChar()
                j++
            }
            k=1

        }
    }
    res[j] = testt.last()
    j++
    if (k > 1) {
        res[j] = (k + '0'.code).toChar()
        j++
    }

    res.forEach { print(it.toString()+"\t") }

}