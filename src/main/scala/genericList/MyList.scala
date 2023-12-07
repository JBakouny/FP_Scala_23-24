package genericList

trait List[+T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
}

class Cons[T](override val head: T, override val tail: List[T]) extends List[T] {
  def isEmpty: Boolean = false
}

object Nil extends List[Nothing] {
  def isEmpty: Boolean = true

  def head: Nothing = throw new NoSuchElementException("Nil.head")

  def tail: Nothing = throw new NoSuchElementException("Nil.tail")
}

def nth[T](n: Int, xs: List[T]): T = {
    if (xs.isEmpty || n < 0) 
        throw new IndexOutOfBoundsException
    else if (n == 0) xs.head
    else nth(n - 1, xs.tail)
}

object List {
  def apply[T](x : T) : List[T] = new Cons(x, Nil)
  def apply[T](x1 : T, x2 : T) : List[T]  = new Cons(x1, apply(x2))
  def apply[T](x1 : T, x2 : T, x3 : T) : List[T]  = new Cons(x1, apply(x2, x3))
//   def apply[T](xs : T*) : List[T] ={
    
//   }
}

@main
def main : Unit = {
    val l = List(1)
    println(l)
}


