
def suml(xs: List[Int]) = (0 :: xs) reduceLeft(_ + _)
def productl(xs: List[Int]) = (1 :: xs) reduceLeft(_ * _)


def sumr(xs: List[Int]) = (0 :: xs) reduceRight(_ + _)
def productr(xs: List[Int]) = (1 :: xs) reduceRight(_ * _)

suml(List(1,2,3,4))
productl(List(1,2,3,4))

sumr(List(1,2,3,4))
productr(List(1,2,3,4))
