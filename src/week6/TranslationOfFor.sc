

def mapFun[T, U](xs: List[T], f: T => U): List[U] =
  for (x <- xs) yield f(x)


def flatMap[T, U](xs: List[T], f: T => Iterable[U]): List[U] =
  for (x <- xs; y <- f(x)) yield y


def filter[T](xs: List[T], p: T => Boolean): List[T] =
  for (x <- xs if p(x)) yield x



// A simple for-expression
// for (x <- e1) yield e2
// is translated to
// e1.map(x => e2)

// for (x <- e1 if f; s) yield e2
// can be written as
// for (x <- e1.withFilter(x => f); s) yield e2
