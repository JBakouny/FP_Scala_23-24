
def mapReduce(zero: BigInt, op: (BigInt, BigInt) => BigInt, f : BigInt => BigInt, a: BigInt, b: BigInt) : BigInt = {
  if (a > b) zero
  else op(f(a), mapReduce(zero, op, f, a+1, b))
}

def product(f : BigInt => BigInt, a: BigInt, b: BigInt) : BigInt =
  mapReduce(1, _ * _, f, a, b)

def sum(f : BigInt => BigInt, a: BigInt, b: BigInt) : BigInt =
  mapReduce(0, _ + _, f, a, b)

def sumInts(a: BigInt, b: BigInt) : BigInt =
  sum(x => x, a, b)

def sumCubes(a: BigInt, b: BigInt) : BigInt =
  sum(x => x * x * x, a, b)

def fact(n : BigInt) : BigInt =
  product(x => x, 1, n)

def sumFact(a: BigInt, b: BigInt): BigInt =
  sum(fact, a, b)

@main def hello: Unit =
  println(sumInts(0, 50))
  println(sumCubes(0, 50))
  println(sumFact(0, 5))

