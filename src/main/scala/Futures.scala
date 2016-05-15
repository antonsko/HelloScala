/**
  * Created by anton.skovorodko on 04/24/2016.
  */

import scala.concurrent._
import scala.concurrent.duration._
import scala.util.{Failure, Success, Try}
import ExecutionContext.Implicits.global

case class Futures() {

  def run(): Unit = {
    val intFuture: Future[Int] = Future {23}

    intFuture onComplete {
      case Success(t) => {
        println(s"Future success callback value=$t")
      }
      case Failure(e) => {
        println(s"An error occured: $e.getMessage")
      }
    }

    val result: Try[Int] = Await.ready(intFuture, 10 seconds).value.get

    val resultEither = result match {
      case Success(t) => Right(t)
      case Failure(e) => Left(e)
    }

    resultEither match {
      case Right(t) => println(s"Right: $t")
      case Left(e) => println(s"Left: $e")
    }

    // Await.result
    lazy val stringFuture = Future {"hello"}
    val realString: String = Await.result(stringFuture, 1 second)
    println(realString)

    // Promise

    // Async await lib: https://github.com/scala/async
//    val future1 : Future[Double] = Future { 1 }
//    val future2 : Future[Double] = Future { 2 }
//    val future3 : Future[Double] = Future { 3 }
//
//    //use Scala Async Library here, note the Async-Await
//    async {
//      val s = await {future1} + await {future2} + await {future3}
//      println(s"Sum:  $s")
//    } onFailure { case e => /* Handle failure */ }

  }
}
