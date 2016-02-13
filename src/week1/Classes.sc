
// Point
class Point(xc: Int, yc: Int) {
  var x: Int = xc
  var y: Int = yc
  def move(dx: Int, dy: Int) {
    x = x + dx
    y = y + dy
  }
  override def toString(): String = s"($x, $y)"
}


// Square
val pt = new Point(1, 2)
println(pt)
pt.move(10, 10)
println(pt)

class Square(s: Int) {
  var side: Int = s
  
  def area(): Unit = {
    val area: Int = side * side
    println(s"Area of the square is $area")
  }
}


val sq = new Square(5)
sq.area()
