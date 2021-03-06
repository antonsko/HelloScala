/**
  * Created by anton.skovorodko on 05/10/2016.
  */
class Collections() {
  def run() = {

    val r: Range = 1 until 10 by 2 // to=inclusive / until=exclusive

    val a = Array(1,2,3,44)
    val m = a map (x => x * 2)

    val s = "Tesadasd"
    s filter (c => c.isUpper)
    s exists (c => c.isUpper)

    val pairs = List("XO", "X1", "X2") zip List("Y0", "Y1", "Y2")
    pairs.unzip

    Vector(1, 2 ,3 ,4, 5)

    s flatMap (c => List('.', c))

    // For expression (nested loop in imperative languages)
    for{
      i <- 1 until 3
      j <- 1 until 4
    } yield (i, j)

    case class Person(name: String, isMale: Boolean = true)

    val stars = Set(Person("Michael"), Person("David"), Person("Prince"))
    for{
      p <- stars
      n = p.name
      if (n contains "a")
    } yield n

    Set("a", "b", "b")

    (1 to 6) toSet

    Iterable

    val romanNumerals = Map("I" -> 1, "V" -> 5, "X" -> 10)
    // romanNumerals ("I") //throws exception
    romanNumerals get "I"

    val romanNumeralsWithDefault = Map("I" -> 1, "V" -> 5, "X" -> 10) withDefaultValue "Unknown"
    romanNumeralsWithDefault("II")

    val fruits : List[String] = List("oranges", "mangoes", "apples", "pears")
    fruits sortWith (_.length < _.length)  // word length order predicate
    fruits.sorted // Lexicographic order

    // params example
    class Poly(terms: (Int, Double)*)
    new Poly(3-> 2.0, 1 -> 7.0, 0 -> 2.3)
  }
}
