enum Expr {
  case Var(s: String)
  case Sum(e1: Expr, e2: Expr)
  case Prod(e1: Expr, e2: Expr)

  def simpleShow: String = this match {
    case Var(name) => name
    case Sum(e1, e2) => "(" + e1.simpleShow + " + " + e2.simpleShow + ")"
    case Prod(e1, e2) => "(" + e1.simpleShow + " * " + e2.simpleShow + ")"
  }

  def show: String = this match {
    case Var(name) => name

    case Prod(e1@Sum(_, _), e2@Sum(_, _)) => "(" + e1.show + ")" + " * " + "(" + e2.show + ")"
    case Prod(Sum(a, b), e2) => "(" + Sum(a, b).show + ")" + " * " + e2.show
    case Prod(e1, Sum(c, d)) => e1.show + " * " + "(" + Sum(c, d).show + ")"
    case Prod(e1, e2) => e1.show + " * " + e2.show

    case Sum(exp1, exp2) => exp1.show + " + " + exp2.show
  }

  def factor: Expr = this match {
    //This code only factorises expressions of the form: a * b + c * d = a * (b + d)  ssi a == c || a == d || b == c || b == d
    case Sum(Prod(a, b), Prod(c, d)) if (a == c) =>
      if (a == c) Prod(a.factor, Sum(b.factor, d.factor))
      else if (a == d) Prod(a.factor, Sum(b.factor, c.factor))
      else if (b == c) Prod(b.factor, Sum(a.factor, d.factor))
      else if (b == d) Prod(b.factor, Sum(a.factor, c.factor))
      else Sum(Prod(a.factor, b.factor), Prod(c.factor, d.factor))


    case Sum(a, b) => Sum(a.factor, b.factor)
    case Prod(a, b) => Prod(a.factor, b.factor)
    case x => x
  }
}

@main def main =
  val p = Expr.Sum(Expr.Prod(Expr.Sum(Expr.Prod(Expr.Var("a"), Expr.Var("x")), Expr.Prod(Expr.Var("a"), Expr.Var("b"))), Expr.Var("c")),
    Expr.Prod(Expr.Sum(Expr.Prod(Expr.Var("a"), Expr.Var("x")), Expr.Prod(Expr.Var("a"), Expr.Var("b"))), Expr.Var("d")))
  println("Without imports...")
  println(p.simpleShow)
  println(p.show)
  println(p.factor.show)
  println("========")
  println(p)
  println(p.factor)

@main def mainAlternative =
  import Expr._
  val p = Sum(Prod(Sum(Prod(Var("a"), Var("x")), Prod(Var("a"), Var("b"))), Var("c")),
    Prod(Sum(Prod(Var("a"), Var("x")), Prod(Var("a"), Var("b"))), Var("d")))
  println("With imports...")
  println(p.simpleShow)
  println(p.show)
  println(p.factor.show)
  println("========")
  println(p)
  println(p.factor)
