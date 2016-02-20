import scala.math.sqrt

val xs = Array(42, 77, 159, 1, 0)
xs map (x => x / 2.0)


val s = "This is a paragraph"
s filter (c => c.isUpper)

s exists (c => c.isUpper)
s forall (c => c.isUpper)


val pairs = List(1, 2, 3) zip s
pairs.unzip

s flatMap(c => List('.', c))


// LIst of all combinations of numbers x and y
// where x is drawn from 1..M and y is drawn from 1..N
//(1 to M) flatMap (x => (1..N) map (y => (x, y))

def scalarProduct(xs: Vector[Double], ys: Vector[Double]): Double =
  (xs zip ys).map(xy => xy._1 * xy._2).sum

def scalarProductPM(xs: Vector[Double], ys: Vector[Double]): Double =
  (xs zip ys).map{case (x, y) => x * y}.sum


def isPrime(n : Int): Boolean = {
  if (n <= 0) return false
  else if (n == 2) return true

  for (x <- 2 to sqrt(n).toInt + 1) {
    if  (n % x == 0) return false
  }
  return true
}


def isPrimeC(n: Int): Boolean = (2 until n) forall (d => n % d != 0)


val l = (1 to 10).toList

l filter (x => isPrime(x))

val ss = Set(1, 2, 3, 4, 5)

ss contains 1

ss map (_ / 2)
