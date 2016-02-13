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

  def getArea = {
    width * height
  }

  def hasSameArea(obj: Any) = {
    obj.isInstanceOf[Square] &&
      obj.asInstanceOf[Square].getArea == width * height
  }
}
val sq1 = new Square(5, 3)
val sq2 = new Square(2, 3)
println(sq1.hasSameArea(sq2))



// Example trait
trait HealthMetrics {
  def height(): Unit
  def weight(): Unit
  def calculateBMI(): Unit
}
class Person(name: String, w: Double, h: Double) extends HealthMetrics {

  def height(): Unit = println(s"$name height is $h meters")
  def weight(): Unit = println("$name  weight is $w kgs")
  def calculateBMI(): Unit = {
    val bmi: Double = w / (h * h)
    var bmiCategory = ""

    if (bmi < 18.5) {
      bmiCategory = "Underweight"
    } else if (18.5 < bmi && bmi < 24.9) {
      bmiCategory = "Normal weight"
    } else if (25 < bmi && bmi < 29.9) {
      bmiCategory = "Overweight"
    } else if (30 < bmi) {
      bmiCategory = "Obese"
    }
    println(s"$name's bmi is $bmi ($bmiCategory)")
  }
}
val p = new Person("Tom", 60, 1.50)
p.calculateBMI()

