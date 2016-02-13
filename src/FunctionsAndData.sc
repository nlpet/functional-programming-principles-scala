

class Rational(x: Int, y: Int) {

  require(y != 0, "denominator cannot be zero")

  private def gcd(a: Int,b: Int): Int = if (b == 0) a else gcd(b, a % b)
  private val g = gcd(x, y)
  def numer = x / g
  def denom = y / g

  def add(that: Rational) = {

    new Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom
    )
  }

  def subtract(that: Rational) = add(that.neg)

  def multiply(that: Rational) = {
    new Rational(
      numer * that.numer, denom * that.denom
    )
  }

  def divide(that: Rational) = {
    new Rational(
      numer * that.denom, denom * that.numer
    )
  }

  def neg: Rational = {
    new Rational(-numer, denom)
  }

  def less(that: Rational) = numer * that.denom < that.numer * denom

  def max(that: Rational) = if (this.less(that)) that else this

  override def toString = {
    if (numer == denom) "1"
    else s"$numer/$denom"
  }
}

val r1 = new Rational(1, 2)
val r2 = new Rational(1, 10)
//r1.add(r2)
//r1.multiply(r2)
//r1.neg
//r2.neg
//r1.divide(r2)
//r1.subtract(r2)
val x = new Rational(1, 3)
val y = new Rational(5, 7)
//val z = new Rational(3, 2)
//x.subtract(y).subtract(z)
//
//val a = new Rational(70, 49)
x.less(y)
x.max(y)

