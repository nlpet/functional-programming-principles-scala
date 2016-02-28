
def from(n: Int): Stream[Int] = n #:: from(n + 1)


// The stream of all natural numbers
val nats = from(0)
// The stream of all multiples of 9
val m9s = nats map (_ * 9)

(m9s take 100).toList

// Sieve of Eratosthenes
def sieve(s: Stream[Int]): Stream[Int] =
  s.head #:: sieve(s.tail filter (_ % s.head != 0))


val primes = sieve(from(2))


primes.take(100).toList


def sqrtStream(x: Double): Stream[Double] = {
  def improve(guess: Double) = (guess + x / guess) / 2
  lazy val guesses: Stream[Double] = 1 #:: (guesses map improve)
  guesses
}


sqrtStream(2.0)