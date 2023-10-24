package rational

object FirstRationalsExercice {
  class Rational(x: Int, y: Int) {
    def numer = x
    def denom = y

    def add(that: Rational) = new Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom)

    def neg = new Rational(-numer, denom)

    def sub(that: Rational) = add(that.neg)

    def mul(that: Rational) = new Rational(
      numer * that.numer,
      denom * that.denom)

    override def toString = numer + "/" + denom
  }

  def main(args: Array[String]) = {
    val x = new Rational(1, 3)                      //> x  : rationals.exercice1.Rational = 1/3
    val y = new Rational(5, 7)                      //> y  : rationals.exercice1.Rational = 5/7
    val z = new Rational(3, 2)                      //> z  : rationals.exercice1.Rational = 3/2

    println(x.sub(y).sub(z))                                 //> res0: rationals.exercice1.Rational = -79/42
    println(x.mul(y))                                       //> y.add(y) 
  }                                       //> res1: rationals.exercice1.Rational = 70/49
}

