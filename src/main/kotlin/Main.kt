fun main() {
    println("Введите номер задания(1-6):")
    val com: Int = readln().toInt()


    when (com) {
        1 -> {
            val testt = ("AAADSSSRRTTHAAAA")
            var res = CharArray(testt.length)
            var k: Int = 1
            var j: Int = 0


            for (i in 0 until testt.length - 1) {
                if (testt[i] == testt[i + 1]) {
                    k++;
                } else {
                    res[j] = testt[i]
                    j++

                    if (k > 1) {
                        res[j] = (k + '0'.code).toChar()
                        j++
                    }
                    k = 1

                }
            }
            res[j] = testt.last()
            j++
            if (k > 1) {
                res[j] = (k + '0'.code).toChar()
                j++
            }

            res.forEach { print(it.toString() + "\t") }
        }
        2->{
            //print("Введите комбинацию из букв: ")
            val letters = ("AASADDSS")


            val symbol = CharArray(letters.length)   //массив для уникальных символов (по порядку первого вхождения)
            val count = IntArray(letters.length)     //массив для количества повторений каждого символа

            var unique = 0; //кол-во найденых уникальных букв

            for (i in letters.indices) {
                val current = letters[i]
                var found = false;
                for (j in 0 until unique) {
                    if (symbol[j] == current) {
                        count[j]++                   // нашли повтор — увеличиваем счётчик
                        found = true
                        break
                    }
                }
                if (!found) {
                    symbol[unique] = current         // новый символ — записываем в массив
                    count[unique] = 1
                    unique++                         // увеличиваем счётчик уникальных символов
                }
            }
            val pairs = mutableListOf<Pair<Char, Int>>()
            for (i in 0 until unique) {
                pairs.add(symbol[i] to count[i])     // собираем пары
            }

            for ((char, count) in pairs) {
                println("$char - $count")            // выводим результат в порядке появления
            }
        }
        3->{
            println("Введите число:")
            var dec = readln().toInt()

            var doub = IntArray(size = 100)
            var k:Int = 0

            while (dec != 0)
            {
                var ost:Int = dec % 2
                dec /=2
                doub[k] = ost;
                k++
            }
            for ( i in k downTo  0)
            {
                if (i==k && doub[i] == 0)
                {}
                else
                    print("\t" + doub[i].toString())
            }
        }
        4->{
            println("Введите выражение в формате: ЧИСЛО1 ЧИСЛО2 ОПЕРАЦИЯ (например: 5.5 2.0 +)")

            var input = readln().trim()
            val parts = input.split(" ")

            val num1 = parts[0].toDouble()
            val num2 = parts[1].toDouble()
            val operation = parts[2]
            var result:Double = 0.0
            when(operation){
                "+"-> result = num1 + num2
                "-"-> result = num1 - num2
                "*"-> result = num1 * num2
                "/"-> {
                    if (num2 !=0.0)
                        result = num1 / num2
                    else
                        println("На ноль делить нельзя")
                }

            }
            println(result)

        }
        5->{
            println("Введите целое число n и основание x через пробел: ")
            val input = readln().trim().split(" ")

            val n = input[0].toDouble()
            val x = input[1].toDouble()
            if (n == 0.0)
            {
                println("Целого показателя не сушествует для n = " + n.toString())
            }
            else if (x == 0.0)
            {
                println("Целого показателя не сушествует для x = " + x.toString())
            }
            else
            {
                val res = (Math.log(n)/Math.log(x)).toInt()
                println(res.toString())

            }
        }
        6->{

        }
    }
}