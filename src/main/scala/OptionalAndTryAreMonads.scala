import scala.util.Success
import scala.util.Failure
import scala.util.Try

object OptionalAndTryAreMonads {
  def main(args: Array[String]): Unit = {
	val a : Option[Int] = Some(7);
	val b : Option[Int] = Some(10);
	val c : Option[Int] = None;
	
	
	val r0 = a.flatMap(x => b.map(y => x + y))
	
	val r1 = for {
		x <- a
		y <- b
	} yield x + y
	
	val r2 = a.flatMap(x => c.map(y => x + y))
	
	val r3 = for {
		x <- a
		y <- c
	} yield x + y
    	
    println("a + b = " + r0)
    println("a + b = " + r1)
    println("a + c = " + r2)
    println("a + c = " + r3)
    
    println("sum(a,b) = " + sum(a,b))
    println("sum(a,c) = " + sum(a,c))
    
    
    val x1 = Success(10)
    val x2 = Failure(new IllegalArgumentException)
    val x3 = Success(7)
    
    println("sum(x1, x2) = " + sum(x1, x2))
    println("sum(x1, x3) = " + sum(x1, x3))
  }
  
  def sum(a : Option[Int], b : Option[Int]) : Option[Int] =
    for {
    		x <- a
    		y <- b
    	} yield x + y
  
  def sum(a : Try[Int], b : Try[Int]) : Try[Int] =
    for {
    		x <- a
    		y <- b
    	} yield x + y
}