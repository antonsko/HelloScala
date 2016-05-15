/**
  * Created by anton.skovorodko on 05/05/2016.
  */
class Lists() {
  def run() = {
    val fruits: List[String] = List("apples", "oranges", "mangoes")
    val numbers: List[Int] = List(1, 2, 3)
    val diag: List[List[Int]] = List(List(1), List(2), List(3))
    val emptyList: List[Nothing] = List()
    val vegs: List[String] = List("tomatoes", "carrots")

    fruits.length
    fruits.last
    fruits.init
    fruits take 1
    fruits drop 2
    fruits(1)
    fruits apply 1
    fruits ++ vegs
    fruits ::: vegs
    fruits.reverse
    fruits updated (2, "NULL")
    fruits indexOf "apples"
    fruits contains "apples"

    println(mergeSort(vegs)(Ordering.String))
    println(scaleList(List(1.2, 2.5, 3.5), 10))

    println(numbers map (x => x * x))

    println(numbers filter (x => x > 2))
    println(numbers filterNot  (x => x > 2))

    println(numbers partition  (x => x > 2))

    println(numbers takeWhile (x => x == 1))
    println(numbers dropWhile (x => x == 1))
    val (take, dontTake) = numbers span (x => x == 1)
    println(take ++ dontTake)
  }

  def mergeSort[T](xs: List[T])(implicit order: Ordering[T]): List[T] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
        case (Nil, ys) => ys
        case (xs, Nil) => xs
        case (x :: xs1, y :: ys1) =>
          if (order.lt(x, y)) x :: merge(xs1, ys)
          else y :: merge(xs, ys1)
      }
      val (fst, snd) = xs splitAt n
      merge(mergeSort(fst), mergeSort(snd))
    }
  }

  def scaleList(xs: List[Double], factor: Double): List[Double] = xs match {
    case Nil => xs
    case y :: ys => y * factor :: scaleList(ys, factor)
  }
}
