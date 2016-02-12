
def gcd(a: Int,b: Int): Int = {
  if (b == 0) a else gcd(b, a % b)
}

class Rational(x: Int, y: Int) {
  def numer = x
  def denom = y

  def add(that: Rational) = {
    new Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom
    )
  }

  def subtract(that: Rational) = {
    new Rational(
      numer * that.denom - that.numer * denom,
      denom * that.denom
    )
  }

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

  override def toString = {
    val gcdNum = gcd(numer, denom)

    if (numer == denom) "1"
    else if (gcdNum > 1) {
      (numer / gcdNum) + "/" + (denom / gcdNum)
    } else {
      s"$numer/$denom"
    }
  }
}

val r1 = new Rational(1, 2)
val r2 = new Rational(1, 10)
r1.add(r2)
r1.multiply(r2)
r1.neg
r2.neg
r1.divide(r2)
r1.subtract(r2)

val x = new Rational(1, 3)
val y = new Rational(5, 7)
val z = new Rational(3, 2)
x.subtract(y).subtract(z)