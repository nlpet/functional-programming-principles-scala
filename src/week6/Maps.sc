

val romanNumerals = Map("I" -> 1, "V" -> 5, "X" -> 10)
romanNumerals get "I"
romanNumerals get "K"
def getNumeral(numeral: String) = romanNumerals.get(numeral) match {
  case Some(value) => value
  case None => "missing value"
}

getNumeral("I")
getNumeral("K")
val veggies = List("tomatoes", "cucumber", "radishes", "lettuce")
veggies sortWith (_.length < _.length)
veggies.sorted
veggies groupBy (_.head)
class Poly(terms0: Map[Int, Double]) {
  val terms = terms0 withDefaultValue 0.0
  def + (other: Poly) = new Poly(terms ++ (other.terms map adjust))
  def adjust(term: (Int, Double)): (Int, Double) = {
    val (exp, coeff) = term
    exp -> (coeff + terms(exp))
  }
  override def toString =
    (for ((exp, coeff) <- terms.toList.sorted.reverse) yield coeff + "x^" + exp) mkString " + "
}


val p1 = new Poly(Map(1 -> 2.0, 3 -> 4.0, 5 -> 7))
val p2 = new Poly(Map(0 -> 3.0, 3 -> 5.2))
p1 + p2
p1.terms(11)
val rnum = romanNumerals withDefaultValue "<unknown>"
rnum("VV")