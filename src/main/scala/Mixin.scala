
trait Singer{
  def sing = { 
    println(" singing … ") 
    }
}


trait Dancer{
  def dance = { 
    println(" dance … ") 
    }
}


class Person {
    def tell = {  
        println (" Human ") 
    }
}

class Actor extends Person with Singer with Dancer {
    def act = {
        println("acting...")
    }
}


// @main
// def main : Unit = {
//     val p = Person();
//     p.tell
//     val singer = new Person() with Singer
//     singer.tell
//     singer.sing
//     val a = Actor()
//     a.tell
//     a.act
//     a.sing
//     a.dance
// }