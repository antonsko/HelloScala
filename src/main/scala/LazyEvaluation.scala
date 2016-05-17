/**
  * Created by antonsko on 5/17/16.
  */
class LazyEvaluation() {
  def run() = {

    // Streams
    // More efficient than lists, tail is only evaluated if accessed
    val s0 = Stream.cons(1, Stream.cons(2, Stream.cons(3, Stream.empty)))
    val s1 = Stream(1,2,3)
    val s2 = List(1,2,3).toStream
    // s1 #:: s2 == Stream.cons(s1, s2)

    // Evaluation example
    def expr = {
      val x = { print("x"); 1}  // by value
      lazy val y = {print("y"); 2}  // lazy
      def z = { print("z"); 3} // by name
      z + y + x + z + y + x
    }
    expr

    // Infinite stream of Integers
    def from(n: Int): Stream[Int] = n #:: from(n+1)
    from(1)
  }
}
