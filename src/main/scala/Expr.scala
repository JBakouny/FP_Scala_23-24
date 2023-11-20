

enum Expr {
    case Number(n : Int) extends Expr
    case Sum(e1 : Expr, e2: Expr) extends Expr
    case Prod(e1 : Expr, e2: Expr) extends Expr
    case Var(x : String) extends Expr
}
import Expr._

def show(e : Expr) : String = e match {
    case Prod(e1 @ Sum(_,_), e2 @ Sum(_,_)) => "(" + show(e1) + ") * ("  + show(e2) + ")"
    case Prod(e1 @ Sum(_,_), e2) => "(" + show(e1) + ") * "  + show(e2)
    case Prod(e1, e2 @ Sum(_,_)) => show(e1) + " * ("  + show(e2) + ")"
    case Prod(e1, e2) => show(e1) + " * "  + show(e2)

    case Number(n) => n.toString 
    case Sum(e1, e2) => show(e1) + " + "  + show(e2)
    case Var(x) => x
}



val p = Sum(Prod(Sum(Prod(Var("a"), Var("x")), Prod(Var("a"), Var("b"))), Var("c")),
Prod(Sum(Prod(Var("a"), Var("x")), Prod(Var("a"), Var("b"))), Var("d")))

@main def main =
    println(show(p))
