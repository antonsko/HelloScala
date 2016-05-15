/**
  * Created by anton.skovorodko on 04/18/2016.
  */

import scala.util.control.Breaks

class LoopExamples() {
  def run() = {

    val list = List(1,2,3,4)
    for(a <- list) {
      println(s"for: value of $a")
    }

    var a = 0
    while(a < 4) {
      println(s"while value of $a")
      a+=1
    }

    val loop = new Breaks()
    loop.breakable {
      for(a <- 0 to 3){
        println(s"breakable for: $a")
        if (a==1)
          loop.break()
      }
    }
  };
}
