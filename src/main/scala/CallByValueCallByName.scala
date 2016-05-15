/**
  * Created by anton.skovorodko on 04/25/2016.
  * Demo of the call by val and call by name differences and also
  * high order function usage
  */
class CallByValueCallByName() {
  def run() = {
    callByValue(something())
    callByName(something())
  }

  def something() = {
    println("something")
    1
  }

  def callByValue(x: Int) = {
    println("callByValue")
    println("x1=" + x)
    println("x2=" + x)
  }

  def callByName(x: => Int) = {
    println("callByName")
    println("x1=" + x)
    println("x2=" + x)
  }
}
