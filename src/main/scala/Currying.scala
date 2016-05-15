/**
  * Created by anton.skovorodko on 05/01/2016.
  * Demo of Currying and Anonymous functions
  */
class Currying() {
  def run() = {

    def sumInts = sum(x => x)
    def sumCubes = sum(x => x * x * x)

    def sum(f: Int => Int): (Int, Int) => Int = {
      def sumF(a: Int, b: Int): Int =
        if (a > b) 0
        else f(a) + sumF(a+1, b)
      sumF
    }

    val result = sumInts(1, 2)// + sumCubes(10, 20)
    println(s"Anonymous functions result:$result")

    // Currying
    def filter(xs: List[Int], p: Int => Boolean): List[Int] =
      if (xs.isEmpty) xs
      else if (p(xs.head)) xs.head :: filter(xs.tail, p)
      else filter(xs.tail, p)

    def modN(n: Int)(x: Int) = ((x % n) == 0)

    val numbers = List(1, 2, 3, 4, 5, 6, 7, 8)
    println(filter(numbers, modN(2)))
    println(filter(numbers, modN(3)))
  }
}
