/**
  * Created by anton.skovorodko on 05/05/2016.
  */
class PatternMatching() {
  def run() = {

    def matchTest(x: Int): String = x match {
      case 1 => "one"
      case 2 => "two"
      case _ => "many"
    }
    println(matchTest(3))
  }
}