/**
  * Created by anton.skovorodko on 04/18/2016.
  */
import interface.classexamples.ClassExamples

object EntryPoint {
  def main(args: Array[String]): Unit = {

    println("Entry point via singleton object")

    new CallByValueCallByName().run()

    new ClassExamples().run()

    new LoopExamples().run()

    new ExtensionMethods().run()

    new Generics().run()

    new Futures().run()

    new Configs().run()

    new DependencyInjection().run

    new SqlConnection().run

    new Currying().run

    new PatternMatching().run

    new Lists().run

    new Collections().run

    new LazyEvaluation().run
  }
}