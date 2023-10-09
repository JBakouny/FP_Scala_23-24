// For more information on writing tests, see
// https://scalameta.org/munit/docs/getting-started.html
class MapReduceTest extends munit.FunSuite {

  test("sumInts succeeds") {
    val expected: BigInt = sumInts(0, 500)
    val obtained: BigInt = 125250
    assertEquals[BigInt, BigInt](obtained, expected)
  }


  test("sumCubes succeeds") {
    val expected: BigInt = sumCubes(0, 50)
    val obtained: BigInt = BigInt(1625625)
    assertEquals[BigInt, BigInt](obtained, expected)
  }

  test("sumFact succeeds") {
    val expected: BigInt = sumFact(0, 5)
    val obtained: BigInt = BigInt(154)
    assertEquals[BigInt, BigInt](obtained, expected)
  }

  test("fact succeeds") {
    val expected: BigInt = fact(5)
    val obtained: BigInt = 120
    assertEquals[BigInt, BigInt](obtained, expected)
  }


  test("sumInts performance test") {
    val expected: BigInt = sumInts(0, 50000000)
    val obtained: BigInt = BigInt(1250000025) * BigInt(1000000)
    assertEquals[BigInt, BigInt](obtained, expected)
  }
}
