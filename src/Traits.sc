/*
 * Similar to interfaces in Java, traits are used to define object types by
 * specifying the signature of the supported methods. Like in Java 8, Scala
 * allows traits to be partially implemented; i.e. it is possible to define
 * default implementations for some methods. In contrast to classes, traits
 * may not have constructor parameters. Here is an example:
 */
trait Area {
  def hasSameArea(x: Any): Boolean
  def doesNotHaveSameArea(x: Any): Boolean = !hasSameArea(x)
}
class Square(w: Int, h: Int) extends Area {
  val width: Int = w
  val height: Int = h

  def getArea() = {
    width * height
  }

  def hasSameArea(obj: Any) = {
    obj.isInstanceOf[Square] &&
    obj.asInstanceOf[Square].getArea() == width * height
  }
}
val sq1 = new Square(5, 3)
val sq2 = new Square(2, 3)
println(sq1.hasSameArea(sq2))
