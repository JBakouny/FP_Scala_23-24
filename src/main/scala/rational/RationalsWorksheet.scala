package rational

object RationalsWorksheet {
                                 //> res2: rationals.intro.Rational = 7/6
  class Rational(x: Int, y: Int) {
    def numer = x
    def denom = y
    
    def add(that: Rational) = new Rational(
        numer * that.denom + that.numer * denom,
        denom * that.denom)
        
    override def toString = numer + "/" + denom
  }

  def main(args: Array[String]): Unit = {
      val x = new Rational(4, 10)                      //> x  : rationals.intro.Rational = 1/2
      x.numer                                         //> res0: Int = 1
      x.denom                                         //> res1: Int = 2
      
      val y = new Rational(2,3)                       //> y  : rationals.intro.Rational = 2/3
      println(x.add(y))                              //> res2: rationals.intro.Rational = 7/6x.add(y)    
  }
}

