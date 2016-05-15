/**
  * Created by anton.skovorodko on 04/20/2016.
  */

class Generics() {

  // Generic method
  def genericPrint[A](stuff: A): Unit = {
    println(s"generic method value = $stuff")
  }

  // Generic class
  class GenericPrinter[A](stuff: A) {
    def printIt():Unit = {
      println(s"generic class value= $stuff")
    }

    // Generic constraint (called View Bound in scala)
    def replace[A <% String](a: A) = a.replace(' ', '+')
    def compare[A <% Ordered[A]](a: A, b:A) = if (a < b) a else b

    // Context Bound
    //def f[A : Ordering](a: A) = g(a) // where g requires an implicit value of type B[A]
    //def f[A : String](n: Int) = new Array[A](n)
    //def f[A : Ordering](a: A, b: A) = implicitly[Ordering[A]].compare(a, b)

    // TypeTag
//    def genericMeth[A : TypeTag](xs: List[A]) = typeOf[A] match {
//      case t if t =:= typeOf[String] => "list of strings"
//      case t if t <:< typeOf[Foo] => "list of foos"
//    }

    // ClassTag
  }

  def run() = {
    genericPrint("text text")
    genericPrint(1)
    genericPrint(Some(12L))

    val gp = new GenericPrinter("asd")
    gp.printIt()

    val replaced = gp.replace("view bound: geasd aswe eqw")
    println(replaced)

    val a = gp.compare(5, 4)
    println(s"view bound compare:$a")
  }
}
