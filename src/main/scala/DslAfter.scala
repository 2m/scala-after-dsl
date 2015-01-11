object DslAfter extends App {

  /**
   * This is an implicit class. Whenever compiler sees that
   * a method on an Int (which is any integer number) is called
   * that is not defined on a integer, it will look for any
   * implicit class that has a constructor with parameter of
   * type Int. Then it wraps original Int with a found implicit
   * class.
   *
   * Essentialy this is what happens:
   * 1.second => RichInt(1).second
   *
   * This allows easily and cleanly to extends libraries.
   */
  implicit class RichInt(i: Int) {
    def second = i * 1000
  }

  /**
   * This has two parameter lists. Will be useful when combines
   * with a fact that almos everywhere we can use ( ) and { }
   * interchangeably. Also a parameter in the second parameter
   * list is acceptet by name (=> next to type). That means
   * that it will only be evaluated on the use site and not on
   * the pass to the function site. This allows passing code
   * as the parameter that is evaluated as late as possible.
   */
  def after(ms: Int)(block: => Unit) = {
    Thread.sleep(ms)
    block
  }

  /**
   * Here we use the fact that we can omit dots (.) from a
   * method calls.
   */
  after(1 second) {
    println("O Hi!")
  }

}
