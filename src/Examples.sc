object SquareRoot {

  def abs(x: Double) = if (x < 0) -x else x

  def sqrtIterate(guess: Double, x: Double): Double =
    if (isGoodEnough(guess, x)) guess
    else sqrtIterate(improve(guess, x), x)

  def isGoodEnough(guess: Double, x: Double) =
    abs(guess * guess - x) < 0.000000001

  def improve(guess: Double, x: Double) =
    (guess + x / guess) / 2

  def sqrt(x: Double) = sqrtIterate(1.0, x)

  sqrt(49)
}