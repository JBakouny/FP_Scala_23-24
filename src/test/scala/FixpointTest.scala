
class FixpointTest extends munit.FunSuite {

  test("fixpoint succeeds") {
    val expected = 2.0
    val obtained = fixedPoint(x => 1 + x/2.0)(2)
    assertEquals(obtained, expected)
  }

  test("sqrt succeeds") {
    val expected = 3.0
    val obtained = sqrt(9)
    assertEquals(obtained, expected)
  }
}