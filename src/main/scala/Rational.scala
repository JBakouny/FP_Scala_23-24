import scala.annotation.tailrec
import math.abs

def gcd(x: Int, y: Int): Int = {
    @tailrec
    def aux(x: Int, y: Int): Int =
        if (y == 0) x else aux(y, x % y)

    abs(aux(x, y))
}

abstract class Base {
  def foo = 1
  def bar : Int
}

class Sub extends Base {
  override def foo = 2
  override def bar: Int = 1
}


case class Rational(x : Int, y : Int) {
  def this(x : Int) = this(x, 1)

  require(y > 0, "denominator must be positive")

  val storedGcd = gcd(x, y)
  val numer = x / storedGcd
  val denom = y / storedGcd

  def +(that: Rational) =
    new Rational(numer*that.denom + denom*that.numer, denom*that.denom)

  def <(that: Rational) : Boolean =
    numer * that.denom < that.numer * denom

  def max(that: Rational) : Rational =
    if (this < that) that else this

  lazy val unary_- =
    new Rational(-numer, denom)

  def -(that: Rational) : Rational =
    this + -that

  def *(that: Rational) : Rational =
    new Rational(numer * that.numer, denom * that.denom)

  override val toString: String =
    numer + " / " + denom


}