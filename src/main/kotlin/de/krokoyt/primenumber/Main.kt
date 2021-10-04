package de.krokoyt.primenumber

fun main(args: Array<String>) {
    var primeNumberSize = 10
    for(x in args.indices) {
        when(args[x]) {
            "-size" -> {
                primeNumberSize = args[x + 1].toInt()
            }
        }
    }
    var current = 1
    val primeNumbers = arrayListOf<Int>()
    while (primeNumbers.size < primeNumberSize) {
        current++
        var primeNumber = true
        var factors = 0
        for (x in 1 ..current + 1)
            if(current % x == 0) {
                factors++
                if(factors > 2) {
                    primeNumber = false
                    break
                }
            }
        if(primeNumber) {
            println(current)
            primeNumbers.add(current)
        }
    }
}