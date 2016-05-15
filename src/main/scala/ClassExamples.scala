/**
  * Created by anton.skovorodko on 04/18/2016.
  * Demo for Class, Traits, Inheritance, properties, constructors, operators
  */
package interface.classexamples

class ClassExamples {

  class SimpleClass(weight: Int, height: Int) {
    require(height > 0, "Height must be positive")

    def test() = {
      assert(weight > 0, "Weight must be positive")
    }
  }

  trait ISomeInterface {
    def greet(name: String): String
  }

  class SomeClass(name: String,
                  val desc: String = "default",
                  val someParam: Any = Some("s"),
                  val noneParam: Any = None) extends ISomeInterface {
    override def greet(name: String): String = {
      return "hello" + name
    }
  }

  // Primary constructor
  class Person(var first: String, last: String) {

    def firstPublicField = first

    // Secondary constructor
    def this(first: String) {
      this(first, "")
    }

    override def toString: String = {
      return s"first: $first, last: $last"
    }

    // Operators
    def +(that: Person) = new Person(this.first + that.firstPublicField)

    def unary_- : Person = new Person('-' + this.first)
  }

  def run() = {
    // throws illegalArgument exception due to 'require'
    //new SimpleClass(2, 0)

    // throws AssertionError exception due to 'assert'
    //new SimpleClass(0, 1).test()

    // Class + Interface
    val s = new SomeClass("string")
    println(s.desc)

    val greeting = s.greet("anton")
    println(greeting)

    val p = new Person("Peter")
    val cp = p + new Person("sen")
    println(cp)

    // Type Cast - not recommended in Scala
    println("cp isInstanceOf Person? " + cp.isInstanceOf[Person])
    //var np = cp.asInstanceOf[Person]

    println(-cp)
  }
}