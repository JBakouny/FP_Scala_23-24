

import annotation.tailrec
import math.abs

val tolerance = 0.0000000000000000001

def fixedPoint(f: Double => Double)(firstGuess: Double) = {
    def isCloseEnough(expected: Double, actual: Double, precision: Double = tolerance) =
        abs((expected - actual) / expected) < precision

    @tailrec
    def iterate(x: Double): Double = {
        val next = f(x)
        if (isCloseEnough(x, next)) next
        else iterate(next)
    }

    iterate(firstGuess)
}

def averageDamp(f: Double => Double)(x: Double): Double = (x + f(x)) / 2

def sqrt(x : Double) = fixedPoint(averageDamp(y => x / y))(1.0)
