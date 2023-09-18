
import annotation.tailrec

@tailrec
def mapReduce(zero: BigInt, op: (BigInt, BigInt) => BigInt)
(f : BigInt => BigInt)(a: BigInt, b: BigInt) : BigInt = {
  if (a > b) zero
  else mapReduce(op(f(a), zero), op)(f)(a+1, b)
}

def product = mapReduce(1, _ * _)

def sum = mapReduce(0, _ + _)

def sumInts = sum(x => x)

def sumCubes = sum(x => x * x * x)

def fact(n : BigInt) : BigInt = product(x => x)(1, n)

def sumFact = sum(fact)

@main def hello: Unit =
  println(sumInts(0, 50))
  println(sumCubes(0, 50))
  println(sumFact(0, 5))

