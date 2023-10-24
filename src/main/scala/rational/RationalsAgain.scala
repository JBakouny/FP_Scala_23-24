package rationals

object RationalsAgain {

  def main(args: Array[String]): Unit = {
      val x = new Rational(1, 3)                      //> x  : rationals.simplified.Rational = 1/3
      val y = new Rational(5, 7)                      //> y  : rationals.simplified.Rational = 5/7
      val z = new Rational(3, 2)                      //> z  : rationals.simplified.Rational = 3/2

      println(x.sub(y).sub(z))                                 //> res0: rationals.simplified.Rational = -79/42
      println(y.add(y))                                        //> res1: rationals.simplified.Rational = 10/7

      // val strange = new Rational(1,0)                 //> strange  : rationals.simplified.Rational = 1/0
      // strange.add(strange)                            //> java.lang.ArithmeticException: / by zero
                                                      //| 	at rationals.simplified.Rational.numer(rationals.simplified.RationalsAga
                                                      //| in.scala:19)
                         
  }
                         //| 	at rationals.simplified.Rational.toString(rationals.simplified.Rationals
                                                  //| Again.scala:40)
                                                  //| 	at scala.runtime.ScalaRunTime$.scala$runtime$ScalaRunTime$$inner$1(Scala
                                                  //| RunTime.scala:332)
                                                  //| 	at scala.runtime.ScalaRunTime$.stringOf(ScalaRunTime.scala:337)
                                                  //| 	at scala.runtime.ScalaRunTime$.stringOf(ScalaRunTime.scala:262)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$show(Worksh
                                                  //| eetSupport.scala:90)
                                                  //| 	at rationals.simplified.RationalsAgain$$anonfun$main$1.apply$mcV$sp(rati
                                                  //| onals.simplified.RationalsAgain.scala:12)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$$anonfun$$exe
                                                  //| cute$1.apply$mcV$sp(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSup
                                                  //| Output exceeds cutoff limit.

}

def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

class Rational(x: Int, y: Int) {
  private lazy val g = gcd(x, y)
  lazy val numer = x /g
  lazy val denom = y /g
  
  def add(that: Rational) = new Rational(
    numer * that.denom + that.numer * denom,
    denom * that.denom)

  def neg = new Rational(-numer, denom)

  def sub(that: Rational) = add(that.neg)

  def mul(that: Rational) = new Rational(
    numer * that.numer,
    denom * that.denom)

  def less(that: Rational) =
    this.numer * that.denom < that.numer * this.denom

  def max(that: Rational) =
    if (this.less(that)) that else this

  override def toString = numer + "/" + denom
}