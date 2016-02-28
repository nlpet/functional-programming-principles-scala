def expr = {
  val x = { print("x"); }
  lazy val y = { print("y"); }
  def z = { print("z"); }
  z + y + x + z + y + x
}

expr // xzyz