object ConventionalAfter extends App {

  /**
   * This is a "conventional" way to implement a way to delay
   * some code execution. Its an abstract class that has one
   * method left to implement for the user.
   */
  abstract class After() {
    var ms: Int = 0

    def block(): Unit

    def run() = {
      Thread.sleep(ms)
      block()
    }
  }

  /**
   * Abstract class is extended with a wanted logic implemented.
   */
  class AfterThatSaysHi extends After {
    def block() = {
      println("O Hi!")
    }
  }

  // instantiate class, mutate fields, call a method that side efects.
  val after = new AfterThatSaysHi()
  after.ms = 1000
  after.run()

}
