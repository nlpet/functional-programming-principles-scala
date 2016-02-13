import scala.math.pow

val powXModY = (n: Int, x: Int, y: Int) => pow(n, x) % y
val onlyOdd = (n : Int) => if (n % 2 == 0) false else true

for (x <- 1 to 10) {
  val res = powXModY(x, 2, 13)
  println(res)
}
var lst = List(1, 2, 3, 5, 8, 13, 21)
println(lst.filter(onlyOdd))
