/**
  * Created by anton.skovorodko on 04/24/2016.
  */
class DependencyInjection() {

  // Cake Pattern
  // ------------
  // This trait is how you would express a dependency
  // Any class that needs a Processor would mix in this trait
  // along with using a self type to allow us to mixin either
  // a mock / test double
  trait ProcessorComponent {

    //abstract implementation, inheritors provide implementation
    val processor : Processor

    trait Processor {
      def Process() : Unit
    }
  }

  // An actual Processor
  trait ActualProcessorComponent extends ProcessorComponent {

    val processor = new ActualProcessor()

    class ActualProcessor() extends Processor {
      def Process(): Unit = {
        println("ActualProcessor")
      }
    }
  }

  // An test double Processor
  trait TestProcessorComponent extends ProcessorComponent {

    val processor = new TestProcessor()

    class TestProcessor() extends Processor {
      def Process(): Unit = {
        println("TestProcessor!")
      }
    }
  }

  // The service that needs the Processor dependency
  // satisfied.Which happens via the use of mixins
  // and the use of a self type
  class OrderService {

    // NOTE : The self type that allows to
    // mixin and use a ProcessorComponent
    this: ProcessorComponent => def ProcessOrder() {
      processor.Process()
    }
  }

  def run() = {
    // DI libs:
    //    Google Guice: https://github.com/google/guice/wiki
    //    MacWire:      https://github.com/adamw/macwire

    //val defaultOrderServiceComponent = new DefaultOrderServiceComponent with ActualProcessorComponent

    // To use the test double or mock we would use a line similar to this
    val defaultOrderServiceComponent = new OrderService with TestProcessorComponent
    defaultOrderServiceComponent.ProcessOrder()
  }
}
