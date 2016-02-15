

def filter(xs: List[Int], p: Int => Boolean): List[Int] =
  if (xs.isEmpty) xs
  else if (p(xs.head)) xs.head :: filter(xs.tail, p)
  else filter(xs.tail, p)


def modN(n: Int)(x: Int): Boolean = (x % n) == 0
val nums = List(1, 2, 3, 4, 5, 6, 7, 8, 9)

println(filter(nums,modN(2)))
println(filter(nums,modN(3)))


def filterStr(xs: List[String], p: String => Boolean): List[String] =
  if (xs.isEmpty) xs
  else if (p(xs.head)) xs.head :: filterStr(xs.tail, p)
  else filterStr(xs.tail, p)


def containsOnlyVowels(s: String): Boolean = {
  val vowels = "aeiou"
  for (char <- s) {
    if (vowels.indexOf(char) == -1) return false
  }
  return true
}


def filterChars(xs: List[Char], fs: String): List[Char] = {
  if (xs.isEmpty) xs
  else if (fs.indexOf(xs.head) == -1) xs.head :: filterChars(xs.tail, fs)
  else filterChars(xs.tail, fs)
}


def stripCharsFromStrings(xs: Array[String], fs: String) = {
  for ((s, i) <- xs.view.zipWithIndex) {
    xs(i) = filterChars(s.toList, fs).mkString("")
  }
  xs
}

val ss = Array("abcd", "bcde", "cdef")
val toRemove = "ae"
stripCharsFromStrings(ss, toRemove)
