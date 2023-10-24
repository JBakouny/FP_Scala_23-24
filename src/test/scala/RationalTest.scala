class RationalTest extends munit.FunSuite {

  test("Rational.add succeeds") {
    val a = Rational(2, 3);
    val b = Rational(3, 5);
    val actual = a + b;
    val expected = Rational(19, 15);
    assertEquals(actual, expected)
  }

  test("Rational.add with simplification") {
    val a = Rational(1, 2);
    val actual = a + a;
    val expected = Rational(1, 1);
    assertEquals(actual, expected)
  }

}
