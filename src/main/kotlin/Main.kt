import kotlin.math.roundToInt

fun main() {
    var com: Int = 1
    while (com != 0) {
        println()
        println("Введите номер задания(1-6):")
        com = readln().toInt()
        when (com) {
            1 -> {
                task1()
            }

            2 -> {
                task2()
            }

            3 -> {
                task3()
            }

            4 -> {
                task4()
            }

            5 -> {
                task5()
            }

            6 -> {
                task6()
            }
        }
    }
}

fun task6() {
    println("Приложение пользователь вводит две различных цифры. На выходе приложение выдает, если это возможно, из введенных цифр, нечетное число. ")
    println("Введите первую цифру: ")
    val num1: String = readln()
    println("Введите вторую цифру: ")
    val num2: String = readln()
    var result: String = "0"
    if (num1.toInt() % 2 == 0 && num2.toInt() % 2 == 0)
        println("Создать нечетное число невозможно")
    else if ((num1.toInt() % 2 != 0 && num2.toInt() % 2 != 0) && num2 != num1) {
        println("нечетные числа из введенных цифр: " + num1 + num2 + ", " + num2 + num1)
    } else if (num1.toInt() % 2 == 1) {
        result = num2 + num1
        println("нечетное число из введенных цифр: " + result)
    } else if (num2.toInt() % 2 == 1) {
        result = num1 + num2
        println("нечетное число из введенных цифр: " + result)
    }
}

fun task5() {
    println("приложение, с помощью которого пользователь, введя целое число n и основание степени x узнает, существует ли целочисленный показатель степени y для которого выполняется равенство xy = n.")
    println("Введите целое число n и основание x через пробел: ")
    val input = readln().trim().split(" ")

    val n = input[0].toDouble()
    val x = input[1].toDouble()
    if (n == 0.0) {
        println("Целого показателя не сушествует для n = " + n.toString())
    } else if (x == 0.0) {
        println("Целого показателя не сушествует для x = " + x.toString())
    } else {
        val res = (Math.log(n) / Math.log(x)).toInt()
        println(res.toString())

    }
}

fun task4() {
    println("Введите выражение в формате: ЧИСЛО1 ЧИСЛО2 ОПЕРАЦИЯ (например: 5.5 2.0 +)")

    var input = readln().trim()
    val parts = input.split(" ")

    val num1 = (parts[0]).toDouble()
    val num2 = (parts[1]).toDouble()
    val operation = parts[2]
    var result = 0.0
    when (operation) {
        "+" -> result = num1 + num2
        "-" -> result = num1 - num2
        "*" -> result = num1 * num2
        "/" -> {
            if (num2 != 0.0) {
                result = num1 / num2
            } else {
                println("На ноль делить нельзя")
            }
        }
    }
    if (result.roundToInt().toDouble() == result)
        println(result.toInt())
    else if (result.roundToInt().toDouble() != result)
        println(result)
}

fun task1() {
    println("Программа подсчитывает количество подряд идущих одинаковых символов во введенной строке(AAADSSSRRTTHAAAA -> A3DS3R2T2HA4")
    val testt = readln()
    var res = CharArray(testt.length)
    var counter = 1
    var counter_2: Int = 0


    for (i in 0 until testt.length - 1) {
        if (testt[i] == testt[i + 1]) {
            counter++;
        } else {
            res[counter_2] = testt[i]
            counter_2++

            if (counter > 1) {
                res[counter_2] = (counter + '0'.code).toChar()
                counter_2++
            }
            counter = 1

        }
    }
    res[counter_2] = testt.last()
    counter_2++
    if (counter > 1) {
        res[counter_2] = (counter + '0'.code).toChar()
        counter_2++
    }

    res.forEach { print(it.toString() + "\t") }
}

fun task2() {
    println("Программа подсчитывает количество различных символов во введенной строке. Символы в ответе расположить в алфавитном порядке")
    var letters = readln()
    val sort_letters = letters.toCharArray().sortedArray()

    val symbol = CharArray(sort_letters.size - 1)
    val count = IntArray(sort_letters.size - 1)

    var unique = 0;

    for (i in sort_letters.indices) {
        val current = sort_letters[i]
        var found = false;
        for (j in 0 until unique) {
            if (symbol[j] == current) {
                count[j]++
                found = true
                break
            }
        }
        if (!found) {
            symbol[unique] = current
            count[unique] = 1
            unique++
        }
    }
    val pairs = mutableListOf<Pair<Char, Int>>()
    for (i in 0 until unique) {
        pairs.add(symbol[i] to count[i])
    }

    for ((char, count) in pairs) {
        println("$char - $count")
    }
}

fun task3() {
    println("Приложение преобразует введенное пользователем натуральное число из 10-ичной системы в двоичную")
    println("Введите число:")
    var dec = readln().toInt()

    var doub = IntArray(size = 100)
    var counter: Int = 0

    while (dec != 0) {
        var ost: Int = dec % 2
        dec /= 2
        doub[counter] = ost;
        counter++
    }
    for (i in counter downTo 0) {
        if (i == counter && doub[i] == 0) {
        } else
            print("\t" + doub[i].toString())
    }
}