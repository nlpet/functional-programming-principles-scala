//
//package idealized.scala
//
//// Pure Booleans
//abstract class Boolean {
//  def ifThenElse[T](t: => T, e: => T): T
//
//  def && (x: => Boolean): Boolean = ifThenElse(x, false)
//  def || (x: => Boolean): Boolean = ifThenElse(true, x)
//  def unary_! : Boolean = ifThenElse(false, true)
//
//  def == (x: Boolean): Boolean = ifThenElse(x, x.unary_!)
//  def != (x: Boolean): Boolean = ifThenElse(x.unary_!, x)
//}
// Peano numbers
abstract class Nat {
  def isZero: Boolean
  def predecessor: Nat
  def successor = new Succ(this)
  def + (that: Nat): Nat
  def - (that: Nat): Nat
}
object Zero extends Nat {
  def isZero = true
  def predecessor = throw new Exception("Zero has no predecessor")
  def + (that: Nat) = that
  def - (that: Nat) = if (that.isZero) this else throw new Exception("Negative number")
}
class Succ(n: Nat) extends Nat {
  def isZero = false
  def predecessor = n
  def + (that: Nat) = new Succ(n + that)
  def - (that: Nat) = if (that.isZero) this else n - that.predecessor
}

