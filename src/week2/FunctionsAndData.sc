
class Rational(x: Int, y: Int) {

  require(y != 0, "denominator cannot be zero")

  private def gcd(a: Int,b: Int): Int = if (b == 0) a else gcd(b, a % b)
  private val g = gcd(x, y)
  def numer = x / g
  def denom = y / g

  //def this(x: Int) = this(x, 1)

  def + (that: Rational) = {

    new Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom
    )
  }

  def - (that: Rational) = this + -that

  def * (that: Rational) = {
    new Rational(
      numer * that.numer, denom * that.denom
    )
  }

  def / (that: Rational) = {
    new Rational(
      numer * that.denom, denom * that.numer
    )
  }

  def unary_- : Rational = {
    new Rational(-numer, denom)
  }

  def < (that: Rational) = numer * that.denom < that.numer * denom

  def max(that: Rational) = if (this < that) that else this

  def min(that: Rational) = if (this < that) this else that

  override def toString = {
    if (numer == denom) "1"
    else if (numer == 0 || denom == 0) "0"
    else s"$numer/$denom"
  }
}

// Tests
val n = new Rational(6, 8)
val m = new Rational(2, 3)
println("Max of n and m is " + (n max m))
println("Min of n and m is " + (n min m))