package de.krokoyt.primenumber

import java.util.Collections
import kotlin.math.abs

fun main(args: Array<String>) {
    var primeNumberSize = 30
    for (x in args.indices) {
        when (args[x]) {
            "-size" -> {
                primeNumberSize = args[x + 1].toInt()
            }
        }
    }
    var current = 1
    val primeNumbers = arrayListOf<Int>()
    val absolute = arrayListOf<Int>()
    while (primeNumbers.size < primeNumberSize) {
        current++
        var primeNumber = true
        var factors = 0
        var absoluteNumber = false
        for (x in 1..current + 1)
            if (current % x == 0) {
                factors++
                if (factors > 2) {
                    primeNumber = false
                    break
                }
            }
        if (primeNumber) {
            if (isAbsolute(current)) {
                absoluteNumber = true
                absolute.add(current)
            }
            println("$current ${if (absoluteNumber) "Abs" else ""}")
            primeNumbers.add(current)
        }
    }
    if(absolute.isNotEmpty()) {
        Collections.sort(absolute, Comparator.naturalOrder())
        println("")
        println("-- Absolute --")
        for (abs in absolute) {
            println(abs)
        }
    }
}

fun isAbsolute(number: Int): Boolean {
    val string = number.toString()
    val numbers = ArrayList<Int>()
    var current = string
    for (args in 0..string.length) {
        current = current.substring(1) + current.substring(0, 1)
        if (current.toInt() != number && !numbers.contains(current.toInt()))
            numbers.add(current.toInt())
    }
    var matches = 0
    for(number in numbers) {
        var factors = 0
        var primeNumber = true
        for(x in 1 .. number)
        if (number % x == 0) {
            factors++
            if (factors > 2) {
                primeNumber = false
                break
            }
        }
        if(primeNumber)
            matches++
    }
    return matches == numbers.size
}