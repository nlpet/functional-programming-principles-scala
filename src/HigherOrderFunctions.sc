
def apply(f: List[Int] => String, v: List[Int]) = f(v)

class Decorator(sep: String) {
  def layout(lst: List[Int]): String = lst.mkString(sep)
}
val decorator = new Decorator(":: ")
println(apply(decorator.layout, List(1, 2, 3, 4, 5)))

def applyTuples(f: List[(Int, String)] => String, v: List[(Int, String)]) = f(v)
class TupleDecorator(mapper: String, sep: String) {
  var delimiter = sep

  def layout(lst: List[(Int, String)]): String = {
    var result: String = ""
    for ((i, s) <- lst) {
      if ((i, s) == lst.last) delimiter = ""
      result += s"$i $mapper $s $delimiter"
    }
    result
  }
}
val tdec = new TupleDecorator("->", "| ")
println(applyTuples(tdec.layout, List((1, "A"), (2, "B"))))


def sum(f: Int => Int, a: Int, b: Int): Int =
  if (a > b) 0
  else f(a) + sum(f, a + 1, b)

def sumInts(a: Int, b: Int) = sum(id, a, b)
def sumCubes(a: Int, b: Int) = sum(cube, a, b)

def id(x: Int): Int = x
def cube(x: Int): Int = x * x * x
