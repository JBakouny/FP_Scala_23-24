import scala.concurrent.Future
import scala.concurrent.ExecutionContext

object FutureSimpleExample {
  implicit val ec : ExecutionContext = ExecutionContext.global
  
  def main(args: Array[String]): Unit = {
    val a = Future{Thread.sleep(50); 1 + 2}
    val b = Future{Thread.sleep(100); 3 + 4}
    
    val c = for {
      x <- a
      y <- b
    } yield x + y
    
    c.onComplete( t => t.fold(println(_), println(_)))

    println("Start of program");
    Thread.sleep(2000);
    println("End of program");
    
  }
}