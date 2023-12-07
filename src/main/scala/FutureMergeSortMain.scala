import scala.concurrent._
import scala.concurrent.ExecutionContext
import scala.concurrent.duration._

object FutureMergeSortMain {
  private val duration = Duration(100, MILLISECONDS)

  implicit val ec = ExecutionContext.global
  
  def msort[T](xs: List[T])(implicit ord: Ordering[T]): Future[List[T]] = {
    val n = xs.length / 2
    if (n == 0) Future(xs)
    else {
      def merge(xs: List[T], ys: List[T]) : List[T] =
      (xs, ys) match {
      		case (Nil, ys) => ys
      		case (xs, Nil) => xs
      		case (x :: xs1, y::ys1) => if (ord.lt(x, y)) x :: merge(xs1, ys)
      															else y :: merge(xs, ys1)
      }
      val (fst, snd) = xs splitAt n
      for {
      	l1 <- msort(fst)
      	l2 <- msort(snd)
      } yield merge(l1, l2)
    }
  }
  
  def main(args: Array[String]): Unit = {
    val nums = List(2, -4, 5, 7, 3)
    println(Await.result(msort(nums), duration))
    
    val fruits = List("banana", "apple", "orange")
    println(Await.result(msort(fruits), duration))
  }
  
}