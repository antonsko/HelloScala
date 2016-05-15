/**
  * Created by anton.skovorodko on 04/20/2016.
  */
class ExtensionMethods() {

    implicit class RichInt(i: Int) {
      def square = i * i
      def twice = i + i
    }

    def run() = {
      val theInt = 20
      println(s"extension method square: $theInt.square")
      println(s"extension method twice: $theInt.twice")
    }
}
